package cn.itcast.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		ServletContext servletContext = sce.getServletContext();
		/*Object source = sce.getSource();
		ServletContext servletContext = (ServletContext)source;*/
//		System.out.println("context创建了....");
		Timer timer = new Timer();
		/*timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.println("银行计息了.....");
			}
		}, new Date(), 5000);*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime="2018-08-30 00:00:00";
		Date  parse = null;
		try {
			parse = sdf.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.println("银行计息了.....");
			}
		}, parse, 24*60*60*1000);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context销毁了....");
	}

}
