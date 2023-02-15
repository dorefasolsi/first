package com.mira.first.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.mira.first.configuration.auth.PrincipalDetails;
import com.mira.first.vo.Board;
import com.mira.first.vo.User;


@Mapper
public interface UserMapper {
	public int insertUser(User user);

	public User loginUser(User user);

	public User getUserById(String userId);
	

}
