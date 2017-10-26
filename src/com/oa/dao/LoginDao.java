package com.oa.dao;


import com.oa.entity.User;

public interface LoginDao {
	public User getUserByUAndP(String username, String password);
}
