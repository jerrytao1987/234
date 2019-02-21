package cn.itcast.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.Product;
import cn.itcast.service.AdminProductService;

public class AdminUpdateProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> properties = request.getParameterMap();
		Product product = new Product();
		try {
			BeanUtils.populate(product, properties);
		} catch (IllegalAccessException|InvocationTargetException e) {
			e.printStackTrace();
		}
		product.setPimage("products/1/c_0033.jpg");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String pdate = sdf.format(new Date());
		product.setPdate(pdate);
		product.setPflag(0);
//		System.out.println(product.getPname()+"..."+product.getMarket_price()+"..."+product.getShop_price()+"..."+product.getPimage()+"..."+product.getPdate()+"..."+product.getIs_hot()+"..."+product.getPdesc()+"..."+product.getPflag()+"..."+product.getCid()+"..."+product.getPid());
		AdminProductService service = new AdminProductService();
		service.updateProduct(product);
		response.sendRedirect(request.getContextPath()+"/adminProductList");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}