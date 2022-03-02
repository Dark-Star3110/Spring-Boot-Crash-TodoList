package edu.vn.todolist.model;

import java.util.Optional;

import org.thymeleaf.util.StringUtils;

//Đối tượng này dùng để kiểm tra xem một Object Todo có hợp lệ không

public class TodoValidator {

  // Kiểm tra một object Todo có hợp lệ không
  public boolean isValid(Todo todo) {
    return Optional.ofNullable(todo)
        .filter(t -> !StringUtils.isEmpty(t.getTitle())) // Kiểm tra title khác rỗng
        .filter(t -> !StringUtils.isEmpty(t.getDetail())) // Kiểm tra detail khác rỗng
        .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
  }
}
