package com.oa.service.impl;

import com.oa.dao.UserDao;
import com.oa.entity.User;
import com.oa.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-15.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource(name="userDao")
    private UserDao userDao;
    public Collection<User> getAllUser(){
         return this.userDao.getUsers();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        this.userDao.saveEntity(user);
    }

    @Override
    public void update(User user) {
        this.userDao.updateEntity(user);
    }

    @Override
    public User getUserByName(String username) {
        return this.userDao.getUserByUsername(username);
    }
}
