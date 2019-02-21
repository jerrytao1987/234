package com.itheima.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.exception.MessageException;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping(value = {"/item/itemlist.action","/item/itemlist1.action"})
	public ModelAndView itemList() throws MessageException{
//		Integer i = 1/0;
		List<Items> list = itemService.selectItemsList();
		/*if(null != list){
			throw new MessageException("商品信息不能为空");
		}*/
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		//model.addAttribute("itemList", list);
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
	public String updateitem(QueryVo qv, MultipartFile pictureFile) throws Exception{
		
		//保存图片到D：\ upload
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String filename = pictureFile.getOriginalFilename();
		String ext = FilenameUtils.getExtension(filename);
		pictureFile.transferTo( new File("D:\\upload\\" + name + "." + ext) );
		qv.getItems().setPic(name + "." + ext);
		
		itemService.updateItemsById(qv.getItems());
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("success");*/
		return "redirect:/itemEdit.action?id="+qv.getItems().getId();
	}
	@RequestMapping("/deletes.action")
	//public ModelAndView deletes(Integer[] ids){
	public ModelAndView deletes(QueryVo qv){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	@RequestMapping(value="/updates.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView updates(QueryVo qv){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	//json交互
	@RequestMapping(value="/json.action")
	public @ResponseBody Items json(@RequestBody Items items){
		return items;
	}
	//RestFul 风格
	@RequestMapping(value = "/itemEdit/{id}.action")
//	public ModelAndView toEdit(@RequestParam(value="id",required = false,defaultValue = "1") Integer idadbsd,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model) {
	public ModelAndView toEdit1(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model) {
		/*String id = request.getParameter("id");
		Items items = itemService.selectItemsById(Integer.parseInt(id));*/
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}
	@RequestMapping(value="/login.action",method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/login.action",method = RequestMethod.POST)
	public String login(String username,HttpSession httpSession){
		httpSession.setAttribute("USER_SESSION", username);
		return "redirect:/item/itemlist.action";
	}
}
