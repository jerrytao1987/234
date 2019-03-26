package cn.itcast.springboot.springconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

import cn.itcast.springboot.dao.UserDao;

@Configuration // 通过该注解来表明该类是一个Spring的配置，相当于一个xml文件
@ComponentScan(basePackages = { "cn.itcast.springboot" }) // 配置扫描包
@PropertySource(value = { "classpath:db.properties" }, ignoreResourceNotFound = true) // 通过@PropertySource可以指定读取的配置文件，通过@Value注解获取值
public class SpringConfig {
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.username}")
	private String jdbcUsername;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Bean
	public DataSource getDataSource() {
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
		boneCPDataSource.setDriverClass(jdbcDriver);
		boneCPDataSource.setJdbcUrl(jdbcUrl);
		boneCPDataSource.setUsername(jdbcUsername);
		boneCPDataSource.setPassword(jdbcPassword);
		// 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
		boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
		// 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
		boneCPDataSource.setIdleMaxAgeInMinutes(30);
		// 每个分区最大的连接数
		boneCPDataSource.setMaxConnectionsPerPartition(100);
		// 每个分区最小的连接数
		boneCPDataSource.setMinConnectionsPerPartition(5);
		return boneCPDataSource;
	}

	@Bean // 通过该注解来表明是一个Bean对象，相当于xml中的<bean>
	public UserDao getUserDao() {
		UserDao userDao = new UserDao();
		DataSource dataSource = this.getDataSource();
		userDao.setDataSource(dataSource);
		return userDao;// 直接new对象做演示
	}
}
