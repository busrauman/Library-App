package com.library.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.app.config.CustomUser;
import com.library.app.model.User;
import com.library.app.repository.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
    
	@Autowired
	private UserRepository userRepository;
     
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Username not found"); 
		}
		
		
		return new CustomUser(user.getEmail() , user.getPassword(), 
				true, true, true, false, getAuthorities(user), user);
    }
	
	private  List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(null != user) {
			authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
		}
        return authorities;
    }

	
}