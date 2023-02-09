package com.mira.first.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.mira.first.vo.Board;
import com.mira.first.vo.Member;


@Mapper
public interface MemberMapper {
	public void insertMember(Member member);

	public Member loginMember(Member member);
	
	public int insertBoard(Board board);

	public ArrayList<Board> boardList();

	public Board detailBoard(Board board);

	public int deleteBoard(Board board);

	public int updateBoard(Board board);
}
