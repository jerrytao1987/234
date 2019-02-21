package cn.itcast.gjp.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;

public class Test {
	public static void main(String[] args) {
		String sql = "select * from gjp_zhangwu";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		List<ZhangWu> list=null;
		try {
			list = qr.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class) );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ZhangWu zhangWu : list) {
			System.out.println(zhangWu);
		}
	}
}
