package com.demoapp.application;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@org.springframework.context.annotation.Configuration
public class Configuration {
	

	@Value("${spring.datasource.url}")
	private String h2url;
	
	@Bean
	@Primary
    public DataSource dataSource() {
		
		//final String h2url = System.getenv("H2DATASOURCE");
		
		System.out.println("hey i am H2 Config, You Called me!!!");
		System.out.print(System.getenv("H2DATASOURCE"));
		//System.out.print(System.getenv("h2-secrets"));
		
		
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(h2url);
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
 
        return dataSource;
    }	

}
