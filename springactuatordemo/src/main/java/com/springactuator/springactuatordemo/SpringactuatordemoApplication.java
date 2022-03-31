package com.springactuator.springactuatordemo;

import java.util.Arrays;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringactuatordemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringactuatordemoApplication.class, args);
	}
}
