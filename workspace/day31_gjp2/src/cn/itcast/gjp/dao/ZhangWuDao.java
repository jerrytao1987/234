package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.utils.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	public List<ZhangWu> selectAll() {
		String sql = "select * from gjp_zhangwu";
		List<ZhangWu> list=null;
		try {
			list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<ZhangWu> select(Date startDate, Date endDate) {
		String sql = "select * from gjp_zhangwu where createtime between ? and ?";
		Object[] params ={startDate,endDate};
		List<ZhangWu> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(ZhangWu.class), params );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int updateZhangWu(ZhangWu zw) {
		String sql = "update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
		int update=0;
		try {
			update = qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	
}
