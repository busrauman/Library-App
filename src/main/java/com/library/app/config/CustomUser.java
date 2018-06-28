package com.library.app.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User{
private com.library.app.model.User user;
	
	
	public com.library.app.model.User getUser() {
		return user;
	}
	public void setUser(com.library.app.model.User user) {
		this.user = user;
	}

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,com.library.app.model.User user) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, !accountNonLocked, authorities);
		this.user=user;
	}

}