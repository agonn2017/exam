package com.csdj.mapper;

import org.apache.ibatis.annotations.Param;

import com.csdj.pojo.User;

public interface TUserMapper {
	/**
	 * 登录验证
	 * @param userCode  用户编码
	 * @param pwd  密码
	 * @return
	 */
	User checkUser(@Param("userCode") String userCode, @Param("pwd") String pwd);
}
