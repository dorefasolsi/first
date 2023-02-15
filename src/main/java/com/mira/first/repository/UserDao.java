package com.mira.first.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.mira.first.configuration.auth.PrincipalDetails;
import com.mira.first.mapper.UserMapper;
import com.mira.first.vo.User;

@Repository
public class UserDao {

	 @Autowired 
	 private UserMapper userMapper;
	 
	 public User getUserById(String userId) {
		 User users = userMapper.getUserById(userId);
		 
		 return users;
	 }
	 
	 public User loginUser(User user) { return userMapper.loginUser(user); }
	 
	 public int insertUser(User user) { return userMapper.insertUser(user); }
	 
}
