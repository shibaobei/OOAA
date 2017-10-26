package com.oa.service;


import com.oa.entity.User;

public interface LoginService {
	public User checkUAndP(String username, String password);
}
