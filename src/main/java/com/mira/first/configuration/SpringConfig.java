package com.mira.first.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

public class SpringConfig {

	
//	Delete 매핑을 사용해보자
//	1단계
//	@DeleteMapping, @PutMapping을 사용하기 위한 빈 등록
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	
	
	
}