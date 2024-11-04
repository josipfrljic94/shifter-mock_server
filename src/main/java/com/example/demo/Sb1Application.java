package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb1Application {

	public static void main(String[] args) {

		var ctx=SpringApplication.run(Sb1Application.class, args);

		Score s= ctx.getBean(Score.class);
	}


}
