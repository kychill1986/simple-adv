package com.yang.simple.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yang.simple.dao.UserDao;
import com.yang.simple.entity.Users;

@Component("userService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<Users> getAllUser() {
		return userDao.getAllUser();
	}
}
