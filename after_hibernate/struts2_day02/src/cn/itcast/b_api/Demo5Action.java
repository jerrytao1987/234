package cn.itcast.b_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//如何在action中获得原生servletApi
public class Demo5Action extends ActionSupport {
	public String execute(){
		//request域=>map(struts2并不推荐使用原生request域)
		Map<String, Object> requestScope = (Map<String, Object>) ActionContext.getContext().get("request");
		ActionContext.getContext().put("name", "requestTom");
		//session域=>map(struts2并不推荐使用原生request域)
		Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		sessionScope.put("name", "sessionTom");
		//application域=>map(struts2并不推荐使用原生request域)
		Map<String, Object> applicationScope = ActionContext.getContext().getApplication();
		applicationScope.put("name", "applicationTom");
		return "success";
	}
	
}
