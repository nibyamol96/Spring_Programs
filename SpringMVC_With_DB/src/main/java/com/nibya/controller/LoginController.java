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
public class LoginController {
	@Autowired
	userService userService;
	@RequestMapping(value="home" ,method=RequestMethod.GET)

	public ModelAndView showing() {
		System.out.println("logincontroller");
	ModelAndView mav=new ModelAndView("home");
	return mav;

	}
	@RequestMapping(value="login")

	public ModelAndView showLogin() {
	ModelAndView mav=new ModelAndView("login");
	return mav;

	}

	@RequestMapping(value="/loginprocess",method=RequestMethod.POST)

	public ModelAndView loginprocess(HttpServletRequest request, HttpServletResponse response,Login loginn)
	{ModelAndView mav=null;
	User user=userService.validateUser(loginn);
	if(null != user) {
	mav=new ModelAndView("welcome");
	mav.addObject("firstname",user.getUsername());
	}else
	{
		mav=new ModelAndView("login");
	mav.addObject("message","Username or password is wrong!!");
	}
	return mav;

	}
}