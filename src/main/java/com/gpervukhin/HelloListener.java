package com.gpervukhin;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HelloListener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent)
	{
		System.out.println("***** HelloListener contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent)
	{
		System.out.println("***** HelloListener contextDestroyed");
	}
}