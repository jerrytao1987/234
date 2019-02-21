package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;
import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.domain.User;
import cn.itcast.service.ProductService;
import cn.itcast.utils.CommonsUtils;
import cn.itcast.utils.JedisPoolUtils;
import cn.itcast.utils.PaymentUtil;
import redis.clients.jedis.Jedis;

public class ProductServlet extends BaseServlet {
	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String methodName =
	 * request.getParameter("method"); if(methodName.equals("productList")){
	 * productList(request,response); }else
	 * if(methodName.equals("categoryList")){ categoryList(request,response);
	 * }else if(methodName.equals("index")){ index(request,response); }else
	 * if(methodName.equals("productInfo")){ productInfo(request,response); } }
	 * 
	 * public void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doGet(request,
	 * response); }
	 */
	public void myOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		ProductService service = new ProductService();
		List<Order> orderList = service.findAllOrders(user.getUid());
		if(orderList!=null){
			for (Order order : orderList) {
				String oid = order.getOid();
				List<Map<String, Object>> mapList = service.findAllOrderItemByOid(oid);
				for (Map<String, Object> map : mapList) {
					Product product=new Product();
					OrderItem orderItem = new OrderItem();
					try {
						BeanUtils.populate(product, map);
						BeanUtils.populate(orderItem, map);
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
					orderItem.setProduct(product);
					order.getOrderItems().add(orderItem);
				}
			}
		}
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/order_list.jsp").forward(request, response);
	}
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> properties = request.getParameterMap();
		Order order = new Order();
		try {
			BeanUtils.populate(order, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		ProductService service = new ProductService();
		service.updateOrderAddr(order);

//		String pd_FrpId = request.getParameter("pd_FrpId");
		/*
		 * if(pd_FrpId.equals("ABC-NET-B2C")){
		 * 
		 * }else if(pd_FrpId.equals("ICBC-NET-B2C")){
		 * 
		 * }
		 */
		// 获得 支付必须基本数据
		String orderid = request.getParameter("oid");
//		String money = order.getTotal()+"";
		String money = "0.01";
		// 银行
		String pd_FrpId = request.getParameter("pd_FrpId");

		// 发给支付公司需要哪些数据
		String p0_Cmd = "Buy";
		String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
		String p2_Order = orderid;
		String p3_Amt = money;
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
		// 第三方支付可以访问网址
		String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback");
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";
		// 加密hmac 需要密钥
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId=" + pd_FrpId + "&p0_Cmd=" + p0_Cmd
				+ "&p1_MerId=" + p1_MerId + "&p2_Order=" + p2_Order + "&p3_Amt=" + p3_Amt + "&p4_Cur=" + p4_Cur
				+ "&p5_Pid=" + p5_Pid + "&p6_Pcat=" + p6_Pcat + "&p7_Pdesc=" + p7_Pdesc + "&p8_Url=" + p8_Url
				+ "&p9_SAF=" + p9_SAF + "&pa_MP=" + pa_MP + "&pr_NeedResponse=" + pr_NeedResponse + "&hmac=" + hmac;

		// 重定向到第三方支付平台
		response.sendRedirect(url);
	}

	public void submitOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		Order order = new Order();
		String oid = CommonsUtils.getUUID();
		order.setOid(oid);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = df.format(new Date());
		/*
		 * try { order.setOrdertime(df.parse(datetime)); } catch (ParseException
		 * e) { e.printStackTrace(); }
		 */
		order.setOrdertime(datetime);
		Cart cart = (Cart) session.getAttribute("cart");
		double total = cart.getTotal();
		order.setTotal(total);
		order.setState(0);
		order.setAddress(null);
		order.setName(null);
		order.setTelephone(null);
		order.setUser(user);
		Map<String, CartItem> cartItems = cart.getCartItems();
		for (Map.Entry<String, CartItem> entry : cartItems.entrySet()) {
			CartItem cartItem = entry.getValue();
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(CommonsUtils.getUUID());
			orderItem.setCount(cartItem.getBuyNum());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		ProductService service = new ProductService();
		service.submitOrder(order);
		session.setAttribute("order", order);
		response.sendRedirect(request.getContextPath() + "/order_info.jsp");
	}

	public void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}

	public void delProFromCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			Map<String, CartItem> cartItems = cart.getCartItems();
			cart.setTotal(cart.getTotal() - cartItems.get(pid).getSubtotal());
			cartItems.remove(pid);
		}
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}

	public void addProductToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));
		ProductService service = new ProductService();
		Product product = service.findProductByPid(pid);
		double subtotal = product.getShop_price() * buyNum;
		CartItem cartItem = new CartItem();
		cartItem.setBuyNum(buyNum);
		cartItem.setProduct(product);
		cartItem.setSubtotal(subtotal);

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		Map<String, CartItem> cartItems = cart.getCartItems();
		if (cartItems.containsKey(product.getPid())) {
			CartItem cartItem2 = cartItems.get(product.getPid());
			int oldBuyNum = cartItem2.getBuyNum();
			oldBuyNum += buyNum;
			cartItem2.setBuyNum(oldBuyNum);
			cartItem2.setSubtotal(oldBuyNum * product.getShop_price());
		} else {
			cartItems.put(product.getPid(), cartItem);
		}

		double total = cart.getTotal() + cartItem.getSubtotal();
		cart.setTotal(total);
		session.setAttribute("cart", cart);

		// request.getRequestDispatcher("/cart.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}

	public void categoryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService service = new ProductService();
		Jedis jedis = JedisPoolUtils.getJedis();
		String categoryListJson = jedis.get("categoryListJson");
		if (categoryListJson == null) {
			List<Category> categoryList = service.findAllCategory();
			Gson gson = new Gson();
			categoryListJson = gson.toJson(categoryList);
			jedis.set("categoryListJson", categoryListJson);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryListJson);
	}

	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();
		// 准备热门商品--List<Product>
		List<Product> hotProductList = service.findHotProductList();
		// 准备最新商品
		List<Product> newProductList = service.findNewProductList();
		// 准备分类数据
		// List<Category> categoryList = service.findAllCategory();
		request.setAttribute("hotProductList", hotProductList);
		request.setAttribute("newProductList", newProductList);
		// request.setAttribute("categoryList", categoryList);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void productInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		String cid = request.getParameter("cid");
		String pid = request.getParameter("pid");
		Cookie[] cookies = request.getCookies();
		String pids = pid;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("pids".equals(cookie.getName())) {
					pids = cookie.getValue();
					String[] split = pids.split("-");
					List<String> asList = Arrays.asList(split);
					LinkedList<String> list = new LinkedList<String>(asList);
					if (list.contains(pid)) {
						list.remove(pid);
						list.addFirst(pid);
					} else {
						list.addFirst(pid);
					}
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < list.size()/* &&i<7 */; i++) {
						sb.append(list.get(i));
						/*
						 * if(i!=list.size()-1){ sb.append("-"); }
						 */
						sb.append("-");
					}
					pids = sb.substring(0, sb.length() - 1);
				}
			}
		}
		Cookie cookie_pids = new Cookie("pids", pids);
		/*
		 * cookie_pids.setMaxAge(60*60); cookie_pids.setPath("/");
		 */
		response.addCookie(cookie_pids);

		ProductService service = new ProductService();
		Product product = service.findProductByPid(pid);
		request.setAttribute("product", product);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("cid", cid);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
	}

	public void productList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 12;
		ProductService service = new ProductService();
		PageBean pageBean = service.findProductListByCid(cid, currentPage, currentCount);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("cid", cid);
		List<Product> historyProductList = new ArrayList<Product>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("pids".equals(cookie.getName())) {
					String pids = cookie.getValue();
					String[] split = pids.split("-");
					for (String pid : split) {
						Product product = service.findProductByPid(pid);
						historyProductList.add(product);
					}
				}

			}
		}
		request.setAttribute("historyProductList", historyProductList);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}
}