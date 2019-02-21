package cn.itcast.web.action;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.PageBean;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private Integer currentPage;
	private Integer pageSize;
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
		PageBean<User> pb = userService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public User getModel() {
		return user;
	}
	
}
