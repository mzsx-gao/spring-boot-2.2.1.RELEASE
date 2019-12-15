package com.gao.springboot;

import com.gao.springboot.config.SwaggerProperties;
import com.gao.springboot.configurationProperties.Person;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by gao on 2018/9/13.
 */
@SpringBootApplication
@EnableConfigurationProperties({ Person.class, SwaggerProperties.class })
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringbootDemoApplication.class, args);
		SpringApplication application = new SpringApplication(SpringbootDemoApplication.class);
		// application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
