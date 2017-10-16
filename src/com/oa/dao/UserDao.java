package com.oa.dao;

import com.oa.entity.User;

import java.util.Collection;

/**
 * Created by Administrator on 2017-10-09.
 */
public interface UserDao<T> extends BaseDao<T>{
     public Collection<User> getUsers();
     public User getUserByUsername(String username);
}
