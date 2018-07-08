package com.library.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.app.model.Role;
import com.library.app.model.User;
import com.library.app.service.RoleService;
import com.library.app.service.UserService;

@RestController
public class InitAppController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	@Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="init",method=RequestMethod.GET)
	public String initApp() {
		List<Role> roles = roleService.listRoles();
		if(roles.isEmpty()) {
			Role admin = new Role();
			admin.setRole("ROLE_ADMIN");
			admin.setRoleName("Admin");
			roleService.save(admin);
			Role user = new Role();
			user.setRole("ROLE_USER");
			user.setRoleName("Kullanıcı");
			roleService.save(user);
			
			User users = new User();
			users.setEmail("admin@email.com");
			users.setFirstname("Admin");
			users.setLastname("Admin");
			
			users.setPassword(bCryptPasswordEncoder.encode("1"));
			users.setUsername("admin");
			admin =  roleService.listRoles().get(0);
			users.setRole(admin);
			userService.saveUser(users);
		}
		return "";
	}
	
}
