package cn.itcast.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;

@Controller("baseDictAction")
@Scope("prototype")
public class BaseDictAction extends ActionSupport {
	
	private String dict_type_code;
	private BaseDictService baseDictService;
	@Override
	public String execute() throws Exception {
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//将list转换为json格式
		//String json = JSONArray.fromObject(list).toString();
		String json = new Gson().toJson(list);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;//告诉struts2不需要进行结果集处理
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	@Resource(name="baseDictService")
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
}
