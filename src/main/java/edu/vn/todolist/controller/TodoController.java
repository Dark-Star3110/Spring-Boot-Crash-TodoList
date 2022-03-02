package edu.vn.todolist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vn.todolist.model.Todo;
import edu.vn.todolist.payload.DeletePayload;
import edu.vn.todolist.service.TodoService;

@Controller
public class TodoController {
  @Autowired
  private TodoService todoService;

  // @RequestParam dùng để đánh dấu một biến là request param trong request gửi
  // lên server.Nó sẽ gán dữ liệu của param-name tương ứng vào biến

  @GetMapping("/listTodo")
  public String listTodo(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
    model.addAttribute("todoList", todoService.getAllTodos(limit));
    return "listTodo";
  }

  @GetMapping("/addTodo")
  public String addTodo(Model model) {
    model.addAttribute("todo", new Todo());
    return "addTodo";
  }

  @GetMapping("/updateTodo")
  public String updateTodo(Model model, @RequestParam(value = "id", required = false) Long id) {
    Todo existingTodo = todoService.getTodo(id);
    if (existingTodo == null) {
      return "notFound";
    }
    model.addAttribute("todo", existingTodo);
    return "updateTodo";
  }

  // @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
  @PostMapping("/addTodo")
  public String addTodo(@ModelAttribute Todo todo) {
    return Optional.ofNullable(todoService.addTodo(todo))
        .map(t -> "success") // Trả về success nếu save thành công
        .orElse("failed"); // Trả về failed nếu không thành công
  }

  @PostMapping("/updateTodo")
  public String updateTodo(@ModelAttribute Todo todo) {
    // System.out.println(todo);
    // Trả về failed nếu không thành công
    return Optional.ofNullable(todoService.updateTodo(todo))
        .map(t -> "success") // Trả về success nếu save thành công
        .orElse("failed"); // Trả về failed nếu không thành công
  }

  @PostMapping("/deleteTodo")
  public String deleteTodo(DeletePayload deletePayload) {
    // System.out.println(deletePayload.getId());
    return todoService.deleteTodo(deletePayload.getId()) ? "success" : "failed";
  }

}
