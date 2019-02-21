package cn.itcast.demo1;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import cn.itcast.jdbcutil.NewJDBCUtils;

public class QueryRunnerDemo {
	private static QueryRunner qr = new QueryRunner(NewJDBCUtils.getDataSource());
	public static void main(String[] args) {
//		insert();
		select();
	}
	public static void select(){
		String sql = "select * from sort";
		try {
			List<Object[]> result = qr.query(sql,new ArrayListHandler());
			for (Object[] objects : result) {
				for (Object object : objects) {
					System.out.print(object+"\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("数据查询失败");
		}
	}
	public static void insert(){
		String sql = "insert into sort(sname,sprice,sdesc) values(?,?,?)";
		Object[] params = {"水果",100.12,"刚刚上市的核桃"};
		try {
			int row = qr.update(sql,params);
			System.out.println(row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("数据添加失败");
		}
	}

}
