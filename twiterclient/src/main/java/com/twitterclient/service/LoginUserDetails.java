package com.twitterclient.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class LoginUserDetails extends User{

	private com.twitterclient.model.User user;

	public LoginUserDetails(com.twitterclient.model.User user) {
		super(user.getUserId(),user.getPassword(),AuthorityUtils.createAuthorityList("role"));
		this.user = user;
	}
	
}
