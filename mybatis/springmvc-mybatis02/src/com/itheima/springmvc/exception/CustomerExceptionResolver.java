package com.itheima.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		ModelAndView mav = new ModelAndView();
		//判断异常类型
		if(e instanceof MessageException){
			MessageException me = (MessageException) e;
			mav.addObject("error",me.getMsg());
		}else{
			mav.addObject("error", "未知异常");
		}
		
		mav.setViewName("error");
		return mav;
	}

}
