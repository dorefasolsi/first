package com.mira.first.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.mira.first.vo.Board;


@Mapper
public interface BoardMapper {
	
	public int insertBoard(Board board);

	public ArrayList<Board> boardList();

	public Board detailBoard(Board board);

	public int deleteBoard(Board board);

	public int updateBoard(Board board);
}
