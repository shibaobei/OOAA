package com.oa.service;

import com.oa.entity.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-15.
 */
public interface UserService {
    public Collection<User> getAllUser();
    public User getUserById(Serializable id);
    public void saveUser(User user);
    public void updateUser(User user);
    public User getUserByName(String username);
}
