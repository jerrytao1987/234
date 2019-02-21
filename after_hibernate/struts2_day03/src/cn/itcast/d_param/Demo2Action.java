package cn.itcast.d_param;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.bean.User;
//ModelDriven的本质方法
public class Demo2Action extends ActionSupport implements Preparable {
	
	private User u = new User();
	public String execute() throws Exception {
		System.out.println(u);
		return SUCCESS;
	}
	@Override
	public void prepare() throws Exception {
		//压入栈顶
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(u);
		
	}
	
}
