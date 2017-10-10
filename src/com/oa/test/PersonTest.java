package com.oa.test;

import com.oa.entity.Person;
import com.oa.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest{
	public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testSavePerson(){
		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setName("踏实哥1");
		personService.savePerson(person);
	}
}
