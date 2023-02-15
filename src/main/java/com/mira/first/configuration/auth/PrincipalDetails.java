package com.mira.first.configuration.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mira.first.vo.User;

public class PrincipalDetails implements UserDetails {
	
	
	private User user; 
	
	
	public PrincipalDetails(User user) {
		this.user = user;
	}

//	해당 유저의 권한을 리턴하는 곳
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				return user.getRole();
			}
			
		});
		return collect;
	}
	
	
//	패스워드 리턴
	@Override
	public String getPassword() {
		return user.getUserPw();
	}

//	유저네임
	@Override
	public String getUsername() {
		return user.getUserId();
	}

//	 계정 만료안됨?
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

//	계정안잠김?
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

//	계정비번1년안넘음?
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

//	활성화?
	@Override
	public boolean isEnabled() {
		
//		우리 사이트에서 1년 동안 회원이 로그인을 안하면 휴면계정으로 하기로했음
//		user에 timeStamp loginDate;
//		로그인 데이트 받아와서 
//		현재시간 - 로그인시간 => 1년 초과 시 return false;
		return true;
	}

}
