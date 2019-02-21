package cn.itcast.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.dao.AdminProductDao;
import cn.itcast.domain.Category;
import cn.itcast.domain.Product;
import cn.itcast.utils.DataSourceUtils;
import cn.itcast.vo.Condition;

public class AdminProductService {

	public List<Product> findAllProduct() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllProduct();
	}

	public List<Category> findAllCategory() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllCategory();
	}

	public void addProduct(Product product) {
		AdminProductDao dao = new AdminProductDao();
		try {
			dao.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delProductByPid(String pid) {
		AdminProductDao dao = new AdminProductDao();
		try {
			dao.delProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delAllbyId(String[] delIdArray) {
		AdminProductDao dao = new AdminProductDao();
		String[][] delId = new String[delIdArray.length][1];
		for(int i=0;i<delId.length;i++){
			delId[i][0] = delIdArray[i];
		}
		try {
			dao.delAllbyId(delId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*try {
			DataSourceUtils.startTransaction();
			for (String delId : delIdArray) {
				
				dao.delAllbyId(delId);
			}
			
		} catch (SQLException e) {
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}

	public Product findProductByPid(String pid) {
		AdminProductDao dao = new AdminProductDao();
		Product product=null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public void updateProduct(Product product) {
		AdminProductDao dao = new AdminProductDao();
		try {
			dao.updateProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> findProductListByCondition(Condition condition) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductListByCondition(condition);
	}

}
