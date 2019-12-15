package com.gao.springboot;

import com.gao.springboot.configurationProperties.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Person people;

	@RequestMapping("/")
	public String index() {
		return "高书电，你好 !!!";
	}

	@RequestMapping("/getName")
	public String getName() {
		return people.getName();
	}

}
