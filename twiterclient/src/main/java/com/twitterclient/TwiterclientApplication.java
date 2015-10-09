package com.twitterclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAutoConfiguration // 自動設定ON
@ComponentScan // Componentオートスキャン
@EnableAspectJAutoProxy // enable aspectj proxy.
public class TwiterclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwiterclientApplication.class, args);
	}
}
