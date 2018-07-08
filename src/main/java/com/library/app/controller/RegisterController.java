package com.library.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.library.app.model.Role;
import com.library.app.model.User;
import com.library.app.service.CustomUserDetailsService;
import com.library.app.service.RoleService;
import com.library.app.service.UserService;

@Controller
public class RegisterController {

	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@ModelAttribute("user")
	public User prepare() {
		return new User();
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(Model model) {
		
		return "registration";
	}

	@RequestMapping(value="register",method=RequestMethod.POST)
	public String registerPost(@ModelAttribute("user") User user ,BindingResult result) {
		if(!result.hasErrors()) {
			Role role = roleService.listRoles().get(1);
			user.setRole(role);
			userDetailsService.saveUser(user);
		}
		return "redirect:login";
	}
	
	
}
