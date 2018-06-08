package com.library.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.library.app.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
}
