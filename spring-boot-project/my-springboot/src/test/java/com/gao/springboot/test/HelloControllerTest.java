package com.gao.springboot.test;

import com.gao.springboot.HelloController;
import com.gao.springboot.SpringbootDemoApplication;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 注意这里可以直接测试controller
 */
@SpringBootTest(classes = SpringbootDemoApplication.class)
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class HelloControllerTest {

	@Autowired
	private HelloController controller;

	@Test
	public void baseTest() {
		TestCase.assertEquals("高书电，你好 !!!", controller.index());

		TestCase.assertEquals("gsd",controller.getName());
	}

}
