package com.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.app.model.Role;
import com.library.app.model.User;
import com.library.app.service.RoleService;
import com.library.app.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String users(Model model ){
		List<User> users = userService.findUserRole();
		model.addAttribute("users",users);
		return "users";
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="changeRoleToAdmin/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public Boolean changeRoleToAdmin(@PathVariable Long id ){
		User user = userService.getOne(id);
		if( null != id) {
			Role role = roleService.getRole(1L);
			if(null != role) {
				user.setRole(role);
				userService.saveUser(user);
			}
			return true;
		}
		return false;
		
	}
}
