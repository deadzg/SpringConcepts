package com.smalwe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smalwe.model.User;

@Controller
public class TestFormController{
	
	Logger logger = LoggerFactory.getLogger(TestFormController.class);
	
	@RequestMapping(value="/users/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model){
		
		User user = new User();
		
		//Setting default value
		user.setName("Sunny");
		
		
		model.addAttribute("userForm", user);
		logger.info("Setting attribute in model");
		return "addUser";
	}
	
	@RequestMapping(value="/printUser", method = RequestMethod.POST)
	public String printUser(@ModelAttribute("userForm") User user, Model model,
			final RedirectAttributes redirectAttributes, HttpServletRequest req){
		HttpSession session = req.getSession();
		session.setAttribute("user", user.getName());
		redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		model.addAttribute("msg", user.getName());
		return "redirect:/users/add";
		//return "showAddedUser";
	}
	
	@RequestMapping(value="/setSessionTest", method = RequestMethod.GET)
	public String setSessionTest(HttpServletRequest req, Model model ){
		HttpSession session = req.getSession();
		String userName = (String)session.getAttribute("user");
		model.addAttribute("msg", userName);
		session.invalidate(); //This removes all the binded variable and resets the session
		return "showSessionVar";
	}
}
