package ru.sso_server_real;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SsoServerRealApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoServerRealApplication.class, args);
	}
	
	//@Bean
	//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
	//}
}