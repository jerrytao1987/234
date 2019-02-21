package cn.e3mall.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.e3mall.cart.service.CartService;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.order.pojo.OrderInfo;
import cn.e3mall.order.service.OrderService;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbUser;

@Controller
public class orderController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@RequestMapping("/order/order-cart")
	public String showOrderCart(HttpServletRequest request){
		TbUser user = (TbUser) request.getAttribute("user");
		//根据用户id取收货地址列表
		//取支付方式
		//根据用户id取购物车列表
		List<TbItem> cartList = cartService.getCartList(user.getId());
		request.setAttribute("cartList", cartList);
		return "order-cart";
	}
	@RequestMapping(value="/order/create",method=RequestMethod.POST)
	public String createOrder(OrderInfo orderInfo,HttpServletRequest request){
		TbUser user = (TbUser) request.getAttribute("user");
		orderInfo.setUserId(user.getId());
		orderInfo.setBuyerNick(user.getUsername());
		E3Result result = orderService.createOrder(orderInfo);
		if(result.getStatus()==200){
			cartService.clearCartItem(user.getId());
		}
		request.setAttribute("orderId", result.getData());
		request.setAttribute("payment", orderInfo.getPayment());
		return "success";
	}
	
}
