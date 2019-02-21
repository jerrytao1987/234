package cn.itcast.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
import cn.itcast.vo.PageBean;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findAllProduct();
	}

	public PageBean<Product> findPageBean(int currentPage, int currentCount) throws SQLException {
		ProductDao dao = new ProductDao();
		
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage((int)Math.ceil(1.0*totalCount/currentCount));
		int index = (currentPage-1)*currentCount;
		List<Product> productList = dao.findProductListForPageBean(index,currentCount);
		pageBean.setProductList(productList);
		return pageBean;
	}

	public List<Product> findProductByWord(String word) throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findProductByWord(word);
	}

	public PageBean<Product> findPageBean(int currentPage, int currentCount, String pname) throws SQLException {
		ProductDao dao = new ProductDao();
		
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = dao.getTotalCount(pname);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage((int)Math.ceil(1.0*totalCount/currentCount));
		int index = (currentPage-1)*currentCount;
		List<Product> productList = dao.findProductListForPageBean(index,currentCount,pname);
		pageBean.setProductList(productList);
		return pageBean;
	}

}
