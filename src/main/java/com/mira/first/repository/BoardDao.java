package com.mira.first.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mira.first.mapper.BoardMapper;
import com.mira.first.vo.Board;

@Repository
public class BoardDao {
		
	
	 @Autowired private BoardMapper boardMapper;
	 
	 public ArrayList<Board> boardList() { return boardMapper.boardList(); }
	 
	 public int insertBoard(Board board) { return boardMapper.insertBoard(board);
	 
	 }
	 
	 public Board detailBoard(Board board) {
	 
	 return boardMapper.detailBoard(board); }
	 
	 public int deleteBoard(Board board) { return boardMapper.deleteBoard(board);
	 }
	 
	 public int updateBoard(Board board) { return boardMapper.updateBoard(board);
	 }
	
}
