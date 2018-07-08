package com.library.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.library.app.config.CustomUser;
import com.library.app.model.User;
import com.library.app.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired private RestTemplate restTemplate;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		String string =restTemplate.getForObject("http://localhost:8080/library/init", String.class);
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String loginControl() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return "publisher";
	}
	@RequestMapping(value = {"loginOk" }, method = RequestMethod.GET)
	public String loginOk(ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		CustomUser customUser =  (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(null != customUser ) {
			return "redirect:books";
		}
		return "redirect:login.htm";
	}
	
}
