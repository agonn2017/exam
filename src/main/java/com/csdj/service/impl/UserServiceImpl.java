package com.csdj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csdj.mapper.TUserMapper;
import com.csdj.pojo.User;
import com.csdj.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TUserMapper mapper;
	
	@Override
	public User login(String userCode, String pwd) {
		return mapper.checkUser(userCode, pwd);
	}

}
