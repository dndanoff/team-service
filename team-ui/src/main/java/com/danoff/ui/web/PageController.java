package com.danoff.ui.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping(value= {"/","/employees","/employees/{id}"})
	public String index() {
		return "/index.html";
	}
}
