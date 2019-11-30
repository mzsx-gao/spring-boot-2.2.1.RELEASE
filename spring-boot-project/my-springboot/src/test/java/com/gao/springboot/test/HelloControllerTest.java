package com.gao.springboot.test;

import com.gao.springboot.HelloController;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes= HelloController.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTest {
	
	@Autowired
	private HelloController controller;

	@Test
	public void testIndex(){
		String result = controller.index();
		System.out.println(result);
		TestCase.assertEquals("高书电，你好 !!!", result);
	}
}
