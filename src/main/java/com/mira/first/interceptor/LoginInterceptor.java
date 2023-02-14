 package com.mira.first.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
	
	
//	스프링 시큐리티의 필터와 겹치는 기능 사용하지 않을 것 -> 추후 삭제하기
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		System.out.println("dd");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			System.out.println("dd");
			return true;
		} else {
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스입니다");
			System.out.println(request.getContextPath().toString());
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
	}
	
}
