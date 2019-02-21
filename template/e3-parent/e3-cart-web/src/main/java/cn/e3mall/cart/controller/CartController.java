package cn.e3mall.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.cart.service.CartService;
import cn.e3mall.common.utils.CookieUtils;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.service.ItemService;

@Controller
public class CartController {

	@Autowired
	private ItemService itemService;
	@Value("${COOKIE_CART_EXPIRE}")
	private Integer COOKIE_CART_EXPIRE;
	@Autowired
	private CartService cartService;

	@RequestMapping("/cart/add/{itemId}")
	public String addCart(@PathVariable Long itemId, @RequestParam(defaultValue = "1") Integer num,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = (TbUser) request.getAttribute("user");
		if(user != null){
			cartService.addCart(user.getId(), itemId, num);
			return "cartSuccess";
		}
		// 从cookie中取购物车列表
		List<TbItem> cartList = getCartListFromCookie(request);
		// 判断商品在商品列表中是否存在
		boolean flag = false;
		for (TbItem tbItem : cartList) {
			// 如果存在数量相加
			if (tbItem.getId() == itemId.longValue()) {
				flag = true;
				// 找到商品，数量相加
				tbItem.setNum(tbItem.getNum() + num);
				// 跳出循环
				break;
			}
		}
		// 如果不存在，根据商品id查询商品信息，得到一个TbItem对象
		if (!flag) {
			TbItem tbItem = itemService.getItemById(itemId);
			tbItem.setNum(num);
			String image = tbItem.getImage();
			if (StringUtils.isNotBlank(image)) {
				tbItem.setImage(image.split(",")[0]);
			}
			// 把商品添加到商品列表
			cartList.add(tbItem);
		}
		// 写入cookie
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(cartList), COOKIE_CART_EXPIRE, true);
		// 返回添加成功页面
		return "cartSuccess";
	}

	/**
	 * 从cookie中取购物车列表处理
	 * 
	 * @param request
	 * @return
	 */
	private List<TbItem> getCartListFromCookie(HttpServletRequest request) {
		String json = CookieUtils.getCookieValue(request, "cart", true);
		// 判断json是否为空
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		// 把json转换成商品列表
		List<TbItem> list = JsonUtils.jsonToList(json, TbItem.class);
		return list;
	}

	/**
	 * 展示购物车列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/cart/cart")
	public String showCatList(HttpServletRequest request,HttpServletResponse response) {
		//从cookie中取购物车列表
		List<TbItem> cartList = getCartListFromCookie(request);
		//判断用户是否为登录状态
		TbUser user = (TbUser) request.getAttribute("user");
		if(user!=null){
			cartService.mergeCart(user.getId(), cartList);
			CookieUtils.deleteCookie(request, response, "cart");
			cartList = cartService.getCartList(user.getId());
		}
		//未登录状态
		request.setAttribute("cartList", cartList);
		return "cart";
	}

	/**
	 * 更新购物车商品数量
	 */
	@RequestMapping("/cart/update/num/{itemId}/{num}")
	@ResponseBody
	public E3Result updateCartNum(@PathVariable Long itemId, @PathVariable Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		TbUser user = (TbUser) request.getAttribute("user");
		if(user != null){
			E3Result result = cartService.updateCartNum(user.getId(), itemId, num);
			return result;
		}
		List<TbItem> cartList = getCartListFromCookie(request);
		for (TbItem tbItem : cartList) {
			if (tbItem.getId().longValue() == itemId) {
				tbItem.setNum(num);
				break;
			}
		}
		// 写入cookie
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(cartList), COOKIE_CART_EXPIRE, true);
		return E3Result.ok();
	}
	/**
	 * 删除购物车商品
	 */
	@RequestMapping("/cart/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId,HttpServletRequest request,HttpServletResponse response){
		TbUser user = (TbUser) request.getAttribute("user");
		if(user != null){
			cartService.deleteCartItem(user.getId(), itemId);
			return "redirect:/cart/cart.html";
		}
		List<TbItem> cartList = getCartListFromCookie(request);
		for (TbItem tbItem : cartList) {
			if (tbItem.getId().longValue() == itemId) {
				cartList.remove(tbItem);
				break;
			}
		}
		// 写入cookie
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(cartList), COOKIE_CART_EXPIRE, true);
		return "redirect:/cart/cart.html";
	}
}
