package ru.sso_server_real.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration{
	    @SuppressWarnings("removal")
		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	    	http.csrf().disable();
	    	http.authorizeRequests()
	    	.requestMatchers("/post-login/**", "/registration/**").permitAll()
			.requestMatchers("/**").authenticated();
	    	
	    	http.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/", true).permitAll());
	    	
	    			return http.build();
		}

}