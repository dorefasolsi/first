package com.mira.first.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mira.first.mapper.MemberMapper;
import com.mira.first.vo.Member;

@Repository
public class MemberDao {

	 @Autowired private MemberMapper memberMapper;
	 
	 
	 public Member loginMember(Member member) { return memberMapper.loginMember(member); }
	 
	 public int insertMember(Member member) { return memberMapper.insertMember(member); }
	 
}
