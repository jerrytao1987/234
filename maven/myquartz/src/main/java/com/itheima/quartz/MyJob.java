package com.itheima.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob {
	public void run(){
		System.out.println("自定义的作业类执行了："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
