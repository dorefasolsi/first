package com.mira.first.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mira.first.vo.Board;
import com.mira.first.vo.Member;

@Service
public class CommonService {
	@Autowired
	private CommonDao commonDao;
	

	
	
	public Member loginMember(Member member) {
		
		return commonDao.loginMember(member); 
	}

	public ArrayList<Board> boardList() {
		
		
		return commonDao.boardList();
	}

	public int insertBoard(Board board) {
		return commonDao.insertBoard(board);
		
	}

	public Board detailBoard(Board board) {
		return commonDao.detailBoard(board);
	}

	public int deleteBoard(Board board) {
		return commonDao.deleteBoard(board);
	}

	public int updateBoard(Board board) {
		return commonDao.updateBoard(board);
	}

	public int insertMember(Member member) {
		return commonDao.insertMember(member);
	}
}
