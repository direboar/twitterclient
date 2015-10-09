package com.twitterclient.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.twitterclient.model.User;
import com.twitterclient.repository.UserRepository;

//フォーム認証の実装。
@Service
public class LoginUserDetailService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger("app");

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		logger.debug(userName);
		User user = userRepository.getOne(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		} else {
			logger.debug(user.getUserId());
			return new LoginUserDetails(user);
		}
	}

	@Configuration
	static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

		@Autowired
		UserDetailsService userDetailsService;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
			// TODO パスワード秘匿化
		}

	}

}
