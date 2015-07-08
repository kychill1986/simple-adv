package com.yang.simple.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yang.framework.dal.BaseMapper;
import com.yang.simple.entity.Users;

@Component("userDao")
public interface UserDao extends BaseMapper<Users, Integer> {

	public List<Users> getAllUser();
}
