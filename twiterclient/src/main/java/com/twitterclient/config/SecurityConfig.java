package com.twitterclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	// FORM認証用の設定。
	protected void configure(HttpSecurity http) throws Exception {
		// 認証対象のURLを設定
		http.authorizeRequests().antMatchers("/loginForm", "/login", "/registration/**", "/css/**", "/js/**", "/img/**")
				.permitAll().anyRequest().authenticated();

		// 認証フォームの設定
		http.formLogin().loginProcessingUrl("/login").loginPage("/loginForm").failureUrl("/loginForm?error=true")
				.defaultSuccessUrl("/twitter", true).usernameParameter("userid").passwordParameter("password").and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**")).logoutSuccessUrl("/loginForm");

	}
}
