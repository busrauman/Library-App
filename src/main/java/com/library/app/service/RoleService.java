package com.library.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.model.Role;
import com.library.app.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRole(Long id) {
		return roleRepository.getOne(id);
	}
	
	public List<Role> listRoles(){
		return roleRepository.findAll();
		
	}

	public void save(Role role) {
		// TODO Auto-generated method stub
		roleRepository.saveAndFlush(role);
	}
}
