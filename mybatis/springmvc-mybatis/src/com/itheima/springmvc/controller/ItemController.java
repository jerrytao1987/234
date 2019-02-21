package com.itheima.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList() {
		List<Items> list = itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	@RequestMapping(value = "/itemEdit.action")
//	public ModelAndView toEdit(@RequestParam(value="id",required = false,defaultValue = "1") Integer idadbsd,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model) {
	public ModelAndView toEdit(Integer id,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model) {
		/*String id = request.getParameter("id");
		Items items = itemService.selectItemsById(Integer.parseInt(id));*/
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}
	/*@RequestMapping("/updateitem.action")
	public ModelAndView updateitem(Items items){
		
		itemService.updateItemsById(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}*/
	@RequestMapping("/updateitem.action")
	public ModelAndView updateitem(QueryVo qv){
		
		itemService.updateItemsById(qv.getItems());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
}
