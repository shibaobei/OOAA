package com.oa.dao.impl;

import com.oa.dao.PersonDao;
import com.oa.entity.Person;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by Administrator on 2017-10-08.
 */
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

    @Override
    public void savePerson(Person person) {
        this.getHibernateTemplate().save(person);
    }
}
