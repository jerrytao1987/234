package cn.itcast.springboot.controller;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello world!";
	}
	public static void main(String[] args) {
		//SpringApplication.run(HelloApplication.class, args);
		SpringApplication springApplication = new SpringApplication(HelloApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);//关闭banner
		springApplication.run(args);
	}
}
