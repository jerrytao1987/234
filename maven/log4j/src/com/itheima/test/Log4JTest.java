package com.itheima.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4JTest {
	@Test
	public void test1(){
		//获得一个日志记录器对象
		Logger logger = Logger.getLogger(Log4JTest.class);
		logger.fatal("致命错误");
		logger.error("普通错误");
		logger.warn("警告信息");
		logger.info("普通信息");
		logger.debug("调试信息");
		logger.trace("堆栈信息");
	}
}
