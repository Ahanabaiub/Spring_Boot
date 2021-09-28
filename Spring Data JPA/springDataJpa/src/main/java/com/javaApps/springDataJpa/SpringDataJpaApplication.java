package com.javaApps.springDataJpa;

import com.javaApps.springDataJpa.domain.Book;
import com.javaApps.springDataJpa.domain.Student;
import com.javaApps.springDataJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication {



	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaApplication.class, args);




	}

}
