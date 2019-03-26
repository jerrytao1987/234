package com.springdemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class UserDao extends JdbcDaoSupport {
	
	public void find(){
		Customer c = this.getJdbcTemplate().queryForObject("select * from cst_customer where cust_id=?", new RowMapper<Customer>() {

			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer c = new Customer();
				Long id = rs.getLong(1);
				String name = rs.getString("cust_name");
				c.setCustId(id);
				c.setCustName(name);
				return c;
			}
		},9l);
		System.out.println(c.getCustId()+":"+c.getCustName());
	}
}
