package com.example.demo;

import com.example.demo.entity.PageRequest;
import com.example.demo.entity.PageResult;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootHelloApplicationTests {


	@Autowired
	private PersonService personService;

	@Test
	public void personTest(){
		PageResult page = personService.findPage(new PageRequest(2, 2));

		List<Person> content = (List<Person>) page.getContent();
		for (Person person:content) {
			System.out.println(person.getName());
		}
		//System.out.println(content.size());
	}

}
