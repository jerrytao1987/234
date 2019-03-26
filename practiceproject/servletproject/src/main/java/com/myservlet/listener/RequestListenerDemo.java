package com.myservlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListenerDemo implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		String name = sre.getServletRequest().getParameter("name");
		if(name!=null&&name.equals("jerry")){
			System.out.println(name);
		}
	}

}
