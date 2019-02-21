package cn.itcast.birthday;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.mail.MailUtils;

public class BirthdayListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
				String currentDate = sdf.format(new Date());
				QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
				String sql = "select * from customer where birthday like ?";
				List<Customer> customerList = null;
				try {
					customerList = qr.query(sql, new BeanListHandler<Customer>(Customer.class), "%"+currentDate);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(customerList!=null&&customerList.size()>0){
					for(Customer c:customerList){
						String emailMsg = "亲爱的:"+c.getRealname()+",Tom祝您生日快乐！";
						try {
							MailUtils.sendMail(c.getEmail(), "生日祝福", emailMsg);
							System.out.println(c.getRealname()+"邮件发送完毕");
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		}, new Date(), 1000*10);//实际开发中起始时间是一个固定的时间,实际开发中间隔时间是1天
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
