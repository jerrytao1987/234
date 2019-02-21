package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	@RequestMapping(value="/content/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result addContent(TbContent content){
		E3Result result = contentService.addContent(content);
		return result;
	}
	@RequestMapping("/content/query/list")
	public @ResponseBody EasyUIDataGridResult selectContent(@RequestParam(name="categoryId",defaultValue="0")Long cid,int page,int rows){
		EasyUIDataGridResult result = contentService.selectContent(cid,page,rows);
		return result;
	}
	@RequestMapping(value="/content/edit",method=RequestMethod.POST)
	@ResponseBody
	public E3Result editContent(TbContent content){
		E3Result result = contentService.editContent(content);
		return result;
	}
	@RequestMapping(value="/content/delete",method=RequestMethod.POST)
	public @ResponseBody E3Result deleteContent(String ids){
		E3Result result = contentService.deleteContent(ids);
		return result;
	}
}
