package com.mira.first.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mira.first.vo.Board;


@Mapper
public interface BoardMapper {
	public void insertBoard(Board board);
	
}
