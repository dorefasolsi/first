package com.mira.first.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {


	/*
	 * @Bean public PasswordEncoder passwordEncoder(){ PasswordEncoder encoder = new
	 * BCryptPasswordEncoder(); return encoder; }
	 */
	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/index")
				.successForwardUrl("/index")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

 


}
