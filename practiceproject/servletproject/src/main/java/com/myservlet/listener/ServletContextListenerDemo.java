package com.myservlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListenerDemo
 *
 */
public class ServletContextListenerDemo implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListenerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         String value = sce.getServletContext().getInitParameter("name");
         System.out.println(value);
    }
	
}
