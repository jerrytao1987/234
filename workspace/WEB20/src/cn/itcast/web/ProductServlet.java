package cn.itcast.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import cn.itcast.vo.PageBean;

public class ProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pname = request.getParameter("search");
		ProductService service = new ProductService();
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null){
			currentPageStr="1";
		}
		int currentPage =Integer.parseInt(currentPageStr);
		String currentCountStr = request.getParameter("currentCount");
		if(currentCountStr==null){
			currentCountStr="12";
		}
		int currentCount = Integer.parseInt(currentCountStr);
		PageBean<Product> pageBean = null;
		try {
			pageBean= service.findPageBean(currentPage,currentCount,pname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}