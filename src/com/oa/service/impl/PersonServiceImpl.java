package com.oa.service.impl;

import com.oa.dao.PersonDao;
import com.oa.entity.Person;
import com.oa.service.PersonService;

/**
 * Created by Administrator on 2017-10-08.
 */
public class PersonServiceImpl implements PersonService{

    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void savePerson(Person person) {
        this.personDao.savePerson(person);
    }
}
