package edu.vn.todolist.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeletePayload {
  private Long id;
}
