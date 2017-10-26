package com.oa.dao.impl;



import javax.annotation.Resource;

import com.oa.dao.LoginDao;
import com.oa.entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("loginDao")
public class LoginDaoImpl  implements LoginDao {
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public User getUserByUAndP(String username, String password) {
		List<User> userList =  this.hibernateTemplate.find("from User where username=? and password=?",new Object[]{username,password});
		if(userList.size()!=0){
			return userList.get(0);
		}else{
			return null;
		}
	}
}
