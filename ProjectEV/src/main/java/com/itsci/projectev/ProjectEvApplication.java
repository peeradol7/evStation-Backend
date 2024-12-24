package com.itsci.projectev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectEvApplication {

	public static void main(String[] args) {

		System.setProperty("server.servlet.context-path", "/evhome");
		SpringApplication.run(ProjectEvApplication.class, args);

	}


}
