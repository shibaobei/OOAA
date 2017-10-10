package com.oa.action;

import com.oa.entity.Person;
import com.oa.service.PersonService;

/**
 * Created by Administrator on 2017-10-08.
 */
public class PersonAction {
    private PersonService personService;

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public String savePerson(){
        Person person = new Person();
        person.setName("王麻子");
        this.personService.savePerson(person);
        return null;
    }
}
