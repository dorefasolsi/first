package com.mira.first.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mira.first.mapper.MemberMapper;
import com.mira.first.vo.Board;
import com.mira.first.vo.Member;

@Repository
public class CommonDao {

	@Autowired
	private MemberMapper memberMapper;
	
	public Member loginMember(Member member) {
		return memberMapper.loginMember(member);
	}

	public ArrayList<Board> boardList() {
		return memberMapper.boardList();
	}

	public int insertBoard(Board board) {
		return memberMapper.insertBoard(board);
		
	}

	public Board detailBoard(Board board) {
		
		return memberMapper.detailBoard(board);
	}

	public int deleteBoard(Board board) {
		return memberMapper.deleteBoard(board);
	}

	public int updateBoard(Board board) {
		return memberMapper.updateBoard(board);
	}

}
