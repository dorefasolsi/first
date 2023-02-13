package com.mira.first.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.mira.first.vo.Board;
import com.mira.first.vo.Member;


@Mapper
public interface MemberMapper {
	public int insertMember(Member member);

	public Member loginMember(Member member);
	

}
