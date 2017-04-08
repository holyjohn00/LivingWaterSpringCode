package com.LivingWater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/errors")
public class ErrorsController {

	@RequestMapping(method=RequestMethod.GET, value="/404")
	public String load404(ModelMap map) {
		System.out.println("NISULOD XA diri + 404");
		return "errors/404";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/500")
	public String load500(ModelMap map) {
		System.out.println("NISULOD XA diri + 500");
		return "errors/500";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/505")
	public String load505(ModelMap map) {
		System.out.println("NISULOD XA diri + 505");
		return "errors/505";
	}
}
