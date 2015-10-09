package com.twitterclient.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

@Configuration
public class AppConfig {

	@Autowired
	DataSourceProperties dataSourceProperties;

	DataSource dataSource;

	// @Bean
	DataSource realDataSource() {
		// 本の通りやったら、DataSourceが複数定義されててNGとはねられたので暫定対応。
		DataSourceBuilder builder = DataSourceBuilder.create(this.dataSourceProperties.getClassLoader())
				.url(this.dataSourceProperties.getUrl()).username(this.dataSourceProperties.getUsername())
				.password(this.dataSourceProperties.getPassword());
		this.dataSource = builder.build();
		return this.dataSource;
	}

	@Bean
	DataSource dataSource() {
		// Log4JDBCをでラップしてログを出すための対応。
		return new Log4jdbcProxyDataSource(this.realDataSource());
	}

}
