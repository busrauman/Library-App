package com.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.app.model.User;
import com.library.app.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String users(Model model ){
		List<User> users = userService.findUserRole();
		model.addAttribute("users",users);
		return "users";
	}
}
