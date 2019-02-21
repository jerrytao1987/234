package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	public int addZhangWu(ZhangWu zw){
		try {
			String sql = "insert into gjp_zhangwu(flname,money,zhanghu,createtime,description) values(?,?,?,?,?)";
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			return qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加账务失败");
		}
	}
	public List<ZhangWu> select(String startDate,String endDate){
		try {
			String sql = "select * from gjp_zhangwu where createtime between ? and ?";
			Object[] params = {startDate,endDate};
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class), params);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("条件查询账务失败");
		}
	}
	public List<ZhangWu> selectAll(){
		try {
			String sql = "select * from gjp_zhangwu";
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询所有账务失败");
		}
	}
	public int editZhangWu(ZhangWu zw) {
		try {
			String sql = "update gjp_zhangwu set flname=?,zhanghu=?,money=?,createtime=?,description=? where zwid=?";
			Object[] params ={zw.getFlname(),zw.getZhanghu(),zw.getMoney(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			return qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改账务失败");
		}
	}
	public int deleteZhangWu(int id) {
		try {
			String sql = "delete from gjp_zhangwu where zwid = ?";
			return qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除账务失败");
		}
	}
}
