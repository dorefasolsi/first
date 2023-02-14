package com.mira.first.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.mira.first.interceptor.LoginInterceptor;

@Configuration
public class SpringConfig {

	
//	Delete 매핑을 사용해보자
//	1단계
//	@DeleteMapping, @PutMapping을 사용하기 위한 빈 등록
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	
//	임포트 import org.springframework.boot.web.servlet.FilterRegistrationBean;
//	@Bean
//	public FilterRegistrationBean setFilterRegistration() {
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
//		// filterRegistrationBean.setUrlPatterns(Collections.singletonList("/filtered/*")); // list 를 받는 메소드
//		filterRegistrationBean.addUrlPatterns("/filtered/*"); // string 여러개를 가변인자로 받는 메소드
//		return filterRegistrationBean;
//	}
	
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.order(1)
				.addPathPatterns("/**");
	}
	
	
}
