package cn.itcast.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.annotation.MyExclude;
import cn.itcast.annotation.UserExclusionStrategy;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.PageBean;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private Integer page;
	private Integer rows;
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
		
		return "toHome";
	}
	
	

	public String regist() throws Exception {
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		return "toLogin";
	}

	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if(user.getUser_name()!=null){
			dc.add(Restrictions.like("user_name", "%"+user.getUser_name()+"%"));
		}
		PageBean<User> pb = userService.getPageBean(dc,page,rows);
//		ActionContext.getContext().put("pageBean", pb);
		Map map = new HashMap();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		
		/*JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"user","saleVisits"});
		String json = JSONArray.fromObject(map,config).toString();*/
		
		/*String json = JSON.toJSONString(map);*/
		
		Gson gson = new GsonBuilder().setExclusionStrategies(new UserExclusionStrategy(MyExclude.class)).setPrettyPrinting().create();
		String json = gson.toJson(map);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	
	public void toEdit() throws Exception {
		User u = userService.getById(user.getUser_id());
		u.setUser_password("");
		Gson gson = new Gson();
		String json = gson.toJson(u);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
	}
	public void delete() throws Exception {
		userService.deleteById(user.getUser_id());
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	@Override
	public User getModel() {
		return user;
	}
	
}
