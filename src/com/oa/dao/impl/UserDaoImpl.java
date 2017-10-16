package com.oa.dao.impl;

import com.oa.dao.UserDao;
import com.oa.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2017-10-15.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{
    @Override
    public Collection<User> getUsers() {
        Collection<User> userList =   this.hibernateTemplate.find("from com.oa.entity.User u left join fetch  u.department d left join fetch  u.posts p ");
        return new HashSet<User>(userList);
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> userList = this.hibernateTemplate.find("from com.oa.entity.User where username=?",username);
        if(userList.size()==0){
            return null;
        }else{
            return userList.get(0);
        }

    }

}
