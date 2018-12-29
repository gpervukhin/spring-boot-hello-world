package com.gpervukhin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
public class SpringBootHelloWorldApplication
{

	public static void main(String[] args)
	{
		//SpringApplication.run(SpringBootHelloWorldApplication.class, args);

		SpringApplication application = new SpringApplication(
			SpringBootHelloWorldApplication.class);
		application.addListeners(new MyListener());
		application.run(args);
	}

	@Bean
	public GracefulShutdown gracefulShutdown()
	{
		System.out.println("***** gracefulShutdown");
		return new GracefulShutdown();
	}

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory(
		final GracefulShutdown gracefulShutdown)
	{
		System.out.println("***** Configure Tomcat");
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addConnectorCustomizers(gracefulShutdown);
		return factory;
	}

	private static class MyListener implements ApplicationListener<ContextClosedEvent>
	{
		@Override
		public void onApplicationEvent(ContextClosedEvent contextClosedEvent)
		{
			System.out.println("***** MyListener ContextClosedEvent (wait): " + contextClosedEvent);
			try { Thread.sleep(10000); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
