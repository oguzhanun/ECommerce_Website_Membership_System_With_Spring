package com.oguzhanun.al_solucan_gubresi.entity;


import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;


public class User extends org.springframework.security.core.userdetails.User {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="enabled")
	private boolean enabled;

	
	public User(String username, String password, boolean enabled, boolean accountNonExpired,
				boolean credentialsNonExpired, boolean accountNonLocked,
				Collection<? extends GrantedAuthority> authorities) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);	
	}
	
	public User(String username, String password, boolean enabled, List<GrantedAuthority> authorities) {
		super(username,password,enabled,true,true,true, authorities);
		
	}
}
