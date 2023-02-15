package com.mira.first.configuration.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mira.first.repository.UserDao;
import com.mira.first.vo.User;

// 시큐리티 설정에서 loginProcessingUrl("/login");
//	/login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는
//	loadUserByUsername 함수가 실행
//	규칙!

@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		PrincipalDetails users = userDao.getUserById(username);
		
		if(users == null) {
			System.out.println("bb");
			throw new UsernameNotFoundException("userId : " + username + " not found");
		}
		System.out.println("------------------------ success ------------------------");
		return users;
	}
	
}
