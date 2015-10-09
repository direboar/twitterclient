package com.twitterclient.config;

import org.springframework.context.annotation.Configuration;

@Configuration
// とりあえずいらない模様。twitter apiをぶっこんだら解決されるのかな？
public class SocialConfig {
	// @Inject
	// private Environment environment;

	// @Bean
	// public ConnectionFactoryLocator connectionFactoryLocator() {
	// ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
	// registry.addConnectionFactory(
	// new
	// TwitterConnectionFactory(environment.getProperty("spring.social.twitter.appId"),
	// environment.getProperty("spring.social.twitter.appSecret")));
	// return registry;
	// }
}
