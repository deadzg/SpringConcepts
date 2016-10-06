package com.smalwe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String testDispatcher(ModelMap model){
		model.addAttribute("msg", "Test Success!!");
		return "test-dispatcher";
	}
	
	@RequestMapping(value = "/bye", method=RequestMethod.GET)
	public String sayBye(ModelMap model){
		model.addAttribute("msg", "Bye");
		return "test-dispatcher";
	}

}
