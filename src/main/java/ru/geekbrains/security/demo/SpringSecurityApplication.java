package ru.geekbrains.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	// GET .../app/score/get/current - показывает балл вошедшего пользователя

	// GET .../app/score/inc - увеличивает балл текущего пользователя
	// GET .../app/score/dec - уменьшает балл текущего пользователя

	// GET .../app/score/get/{id} - показывает балл пользователя с указанным id (доступно
	// только для залогиненных пользователей)
}
