package com.mira.first.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mira.first.repository.BoardDao;
import com.mira.first.vo.Board;

@Service
public class BoardService {
	
	  @Autowired 
	  private BoardDao boardDao;
	  
	  
	  public ArrayList<Board> boardList() {	return boardDao.boardList(); }
	  
	  public int insertBoard(Board board) { return boardDao.insertBoard(board); }
	  
	  public Board detailBoard(Board board) { return boardDao.detailBoard(board); }
	  
	  public int deleteBoard(Board board) { return boardDao.deleteBoard(board); }
	  
	  public int updateBoard(Board board) { return boardDao.updateBoard(board); }
	 
}
