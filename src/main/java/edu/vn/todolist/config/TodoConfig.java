package edu.vn.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.vn.todolist.model.TodoValidator;

@Configuration
public class TodoConfig {
  // Tạo ra Bean TodoValidator để sử dụng sau này
  @Bean
  public TodoValidator validator() {
    return new TodoValidator();
  }
}
