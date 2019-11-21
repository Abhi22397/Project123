package com.iris.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.User;
import com.iris.service.UserService;

@Controller
public class HomeController {

@Autowired
UserService userService;

  @RequestMapping(value="/",method=RequestMethod.GET)
  public String validateUser(Model map)  { 
	return"Login";
  }

  @Autowired
HttpSession session;
@RequestMapping(value="/valid",method=RequestMethod.POST)
public String validateUser(@RequestParam int id,@RequestParam String password){
	User uObj=userService.validateUser(id,password);
	if(uObj!=null){
		
		session.setAttribute("userObj",uObj);
	
		if(uObj.getDesg().equals("Manager")) {
			return "Manager";
		}
		else if (uObj.getDesg().equals("Developer")) {
			return "Developer";
		}
		else if (uObj.getDesg().equals("Tester")) {
			return "Tester";
		}
	}			
	return "Login";
}
}

