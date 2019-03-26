package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

public class TestDBUtils {
	public static void main(String[] args) throws SQLException {
		/*QueryRunner qr = new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="update t_user set username=? where id=?";
		Object[] params={"ddd","5"};
		int count = qr.update(conn, sql, params);
		System.out.println(count);
		JDBCUtils.CloseResource(conn);*/
		QueryRunner qr = new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select * from t_user";
		List<Object[]> query = qr.query(conn,sql, new ArrayListHandler());
		for (Object[] objects : query) {
			System.out.println(Arrays.toString(objects));
		}
		JDBCUtils.CloseResource(conn);
		
	}
}
