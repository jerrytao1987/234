package cn.itcast.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import net.sf.json.JSONArray;

public class SearchWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("word");
		ProductService service = new ProductService();
		List<Product> productList=null;
		try {
			productList = service.findProductByWord(word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*JSONArray fromObject = JSONArray.fromObject(productList);
		System.out.println(fromObject.toString());*/
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}