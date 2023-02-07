package com.gethrtables.gethrtables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableSwagger2
public class GethrtablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GethrtablesApplication.class, args);
	}

}
