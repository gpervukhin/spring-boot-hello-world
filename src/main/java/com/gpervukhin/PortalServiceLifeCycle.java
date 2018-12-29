package com.gpervukhin;

import javax.annotation.PreDestroy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PortalServiceLifeCycle implements CommandLineRunner
{
	@Override
	public void run(String... arg0) throws Exception
	{
		System.out.println("***** START FROM THE LIFECYCLE###");
	}

	@PreDestroy
	public void onExit()
	{
		System.out.println("***** STOP FROM THE LIFECYCLE###");
	}
}