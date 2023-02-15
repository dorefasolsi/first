package com.mira.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mira.first.repository.UserDao;
import com.mira.first.vo.User;

@Service
public class UserService {
	
	  @Autowired private UserDao userDao;
	  
	  public User loginUser(User user) { return userDao.loginUser(user); 
	  }
	  
	  public int insertUser(User user) { return userDao.insertUser(user); }
	 
}
