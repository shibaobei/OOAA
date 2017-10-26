package com.oa.service.impl;

import javax.annotation.Resource;

import com.oa.dao.LoginDao;
import com.oa.entity.User;
import com.oa.service.LoginService;
import org.springframework.stereotype.Service;



@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name="loginDao")
	private LoginDao loginDao;

	public User checkUAndP(String username, String password) {
		return this.loginDao.getUserByUAndP(username, password);
	}
}
