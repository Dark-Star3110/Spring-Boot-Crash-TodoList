package edu.vn.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.vn.todolist.model.Todo;
import edu.vn.todolist.model.TodoValidator;
import edu.vn.todolist.repository.TodoRepository;

@Service
public class TodoService {
  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private TodoValidator validator;

  public Todo getTodo(Long id) {
    return todoRepository.findById(id).isPresent() ? todoRepository.findById(id).get() : null;
  }

  public List<Todo> getAllTodos(Integer limit) {
    // Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả
    // findAll()
    return Optional.ofNullable(limit).map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
        .orElseGet(() -> todoRepository.findAll());
  }

  public Todo addTodo(Todo todo) {
    // Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành công
    if (validator.isValid(todo)) {
      return todoRepository.save(todo);
    }
    return null;
  }

  public Todo updateTodo(Todo todo) {
    // Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành công
    if (validator.isValid(todo)) {
      return todoRepository.save(todo);
    }
    return null;
  }

  public boolean deleteTodo(Long id) {
    try {
      todoRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
