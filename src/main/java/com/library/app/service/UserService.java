package com.library.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.model.Role;
import com.library.app.model.User;
import com.library.app.repository.RoleRepository;
import com.library.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public void saveUser(User user) {
		userRepository.saveAndFlush(user);
	}
	
	public User getOne(Long id) {
		return userRepository.getOne(id);
	}
	
	public List<User> findUserRole(Role role) {
//		return userRepository.findAll();
		return userRepository.findByRole(role);
		
	}
}
