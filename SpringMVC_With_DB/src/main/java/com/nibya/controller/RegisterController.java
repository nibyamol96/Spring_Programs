package com.nibya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nibya.model.Login;
import com.nibya.model.User;
import com.nibya.service.userService;

@Controller
public class RegisterController {

	@Autowired
	userService userService;
	
	@RequestMapping(value="/")
	public ModelAndView home() {System.out.println("Registration controller");
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		ModelAndView mv=new ModelAndView("register");
		return mv;
	}
	@RequestMapping(value="/registerProcess", method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response,User user) {
		userService.register(user);
		return new ModelAndView("welcome", "firstname" , user.getFirstname());
	}
	
}