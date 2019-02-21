package cn.itcast.web.action;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();
	private CustomerService cs;
	
	//上传的文件会自动封装到File对象中
	//在后台提供一个与前台input type=file组件name相同的属性
	private File photo;
	//在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
	private String photoFileName;
	//在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中text/html
	private String photoContentType;
	
	private Integer currentPage;
	private Integer pageSize;
	
	
	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		PageBean<Customer> pageBean = cs.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean",pageBean);
		return "list";
	}
	
	public String add() throws Exception {
		if(photo!=null){
			System.out.println("文件名称："+photoFileName);
			System.out.println("文件类型："+photoContentType);
			//将上传文件保存到指定位置
			photo.renameTo(new File("D:/upload/haha.jpg"));
		}
		cs.save(customer);
		return "toList";
	}
	
	public String toEdit() throws Exception {
		
		Customer c = cs.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", c);
		
		return "edit";
	}

	public String industryCount() throws Exception {
		List<Object[]> list = cs.getIndustryCount();
		ActionContext.getContext().put("list", list);
		return "industryCount";
	}

	@Override
	public Customer getModel() {
		
		return customer;
	}
	@Resource(name="customerService")
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
}
