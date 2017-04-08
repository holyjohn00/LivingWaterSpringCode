package com.LivingWater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class IndexController {

	@RequestMapping(method=RequestMethod.GET, value="/index")
	public String loadIndex(ModelMap map) {
		System.out.println("NISULOD XA diri");
		return "index";
	}
}
