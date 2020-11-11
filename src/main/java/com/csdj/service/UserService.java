package com.csdj.service;


import com.csdj.pojo.User;

public interface UserService {
	User login(String userCode, String pwd);

}
