package edu.vn.todolist.testdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vn.todolist.model.Todo;

@Controller
public class WebController {

  // @GetMapping("/")
  // public String index() {
  // return "index";
  // }

  // Sử dụng tạm List để chứa danh sách công việc
  // Thay cho Database.
  // Chỉ dùng cách này khi DEMO ^^
  List<Todo> todoList = new ArrayList<>();

  /*
   * @RequestParam dùng để đánh dấu một biến là request param trong request gửi
   * lên server.
   * Nó sẽ gán dữ liệu của param-name tương ứng vào biến
   */
  @GetMapping("/listTodo")
  public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
    // Trả về đối tượng todoList.
    // Nếu người dùng gửi lên param limit thì trả về sublist của todoList
    model.addAttribute("todoList", limit != null ? todoList.subList(0, limit) : todoList);
    // Trả về template "listTodo.html"
    return "listTodo";
  }

  @GetMapping("/addTodo")
  public String addTodo(Model model) {
    // Thêm mới một đối tượng Todo vào model
    model.addAttribute("todo", new Todo());
    // Trả về template addTodo.html
    return "addTodo";
  }

  /*
   * @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
   */
  @PostMapping("/addTodo")
  public String addTodo(@ModelAttribute Todo todo) {
    System.out.println("Todo: " + todo);
    // Thêm đối tượng todo vào list
    todoList.add(todo);
    // Trả về trang thành công success.html
    return "success";
  }
}
