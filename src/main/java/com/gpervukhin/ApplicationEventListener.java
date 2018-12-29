package com.gpervukhin;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener implements ApplicationListener<ApplicationEvent>
{
	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent)
	{
		if (applicationEvent instanceof ContextClosedEvent)
		{
			System.out.println("***** ApplicationEventListener: ContextClosedEvent: " + applicationEvent);
		}
	}
}