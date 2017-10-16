package com.oa.service;

import com.oa.entity.User;

import java.util.Collection;

/**
 * Created by Administrator on 2017-10-15.
 */
public interface UserService {
    public Collection<User> getAllUser();
    public void saveUser(User user);
    public void update(User user);
    public User getUserByName(String username);
}
