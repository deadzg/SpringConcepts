package com.smalwe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smalwe.model.User;

@Controller
public class TestFormController{
	
	@RequestMapping(value="/users/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model){
		User user = new User();
		
		//Setting default value
		user.setName("Sunny");
		
		
		model.addAttribute("userForm", user);
		return "addUser";
	}
	
	@RequestMapping(value="/printUser", method = RequestMethod.POST)
	public String printUser(@ModelAttribute("userForm") User user, Model model,final RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		model.addAttribute("msg", user.getName());
		return "redirect:/users/add";
		//return "showAddedUser";
	}
}
