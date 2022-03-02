package edu.vn.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class TodoListApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
}
