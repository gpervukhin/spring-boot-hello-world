package com.gpervukhin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldCtrl
{
	@RequestMapping("/")
	public ModelAndView home(@RequestParam(required = false, defaultValue = "World") String name)
	{
		ModelAndView mav = new ModelAndView("home");
		mav.getModel().put("name", name);
		return mav;
	}
}
