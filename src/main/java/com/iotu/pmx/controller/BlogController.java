package com.iotu.pmx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@RequestMapping("/")
	public String mainPage(){
		return "index";
	}
	
}


