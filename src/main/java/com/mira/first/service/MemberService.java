package com.mira.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mira.first.repository.MemberDao;
import com.mira.first.vo.Member;

@Service
public class MemberService {
	
	  @Autowired private MemberDao memberDao;
	  
	  public Member loginMember(Member member) { return memberDao.loginMember(member); 
	  }
	  
	  public int insertMember(Member member) { return memberDao.insertMember(member); }
	 
}
