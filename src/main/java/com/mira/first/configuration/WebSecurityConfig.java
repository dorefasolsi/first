package com.mira.first.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //스프링시큐리티 필터가 스프링필터체인에 등록됨
public class WebSecurityConfig {
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
		auth.userDetailsService(userDetailsService);
		authenticationManager = auth.build();

		http
				.csrf().disable().cors().disable()
				.authorizeHttpRequests((requests) -> requests
								//아래는 제약조건 설명하는 부분이라고 생각
								.requestMatchers("/**").permitAll()
								//얘네는 조건 없이 ok
//								.requestMatchers("/boardList").hasAnyRole("USER", "ADMIN")
//								.requestMatchers("/**").hasAnyRole("USER", "ADMIN")
								//얘네는 사용자, 어드민 중 하나의 권한 있을 떄 ok
//								.anyRequest().authenticated()
						// 첫째줄  && 둘째줄 -> 걸린 애들이 허옹됨
						
//						.requestMatchers("/", "/login", "/enroll", "/enrollPage").permitAll()
//						.requestMatchers("/board/**").authenticated()
						
				);
		http
			.formLogin()
			.loginPage("/") // 로그인 페이지 설정
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/login") // 로그인이 성공 시 리다이렉션
			.failureUrl("/loginFail") //로그인 실패 시 리다이렉션 (해당 form으로 error=true를 전송함.)
			.permitAll()
			.and()
			.authenticationManager(authenticationManager)
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}
}
