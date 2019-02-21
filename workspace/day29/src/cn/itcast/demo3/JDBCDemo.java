package cn.itcast.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.Sort;
import cn.itcast.jdbcutil.JDBCUtils;

public class JDBCDemo {

	public static void main(String[] args) throws Exception {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = con.prepareStatement("select * from sort");
		ResultSet rs = pst.executeQuery();
		List<Sort> list = new ArrayList<Sort>();
		while(rs.next()){
			Sort s = new Sort(rs.getInt("sid"),rs.getString("sname"),rs.getDouble("sprice"),rs.getString("sdesc"));
			list.add(s);
		}
		JDBCUtils.close(con, pst,rs);
		for (Sort sort : list) {
			System.out.println(sort);
		}
	}

}
