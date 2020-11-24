package com.csdj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csdj.pojo.User;
import com.csdj.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	/**
	 * 登录页面跳转
	 * @return    http://localhost:8080/exam/user/toLogin
     * http://192.168.20.113:8080/exam-1.0-SNAPSHOT/user/toLogin
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	/**
	 * 登录
	 * @param userCode
	 * @param userPassword
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin(String userCode,String userPassword,
				HttpSession session) {
		User user=service.login(userCode, userPassword);
		if (user==null) {
			return "login";
		}
		//模拟代码错误
		int i = 100/0;
		//模拟冗余代码
		int a = 100;
		a=200;
		int c=0;
		session.setAttribute("user", user);
		return "redirect:/paper/home";
	}
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
