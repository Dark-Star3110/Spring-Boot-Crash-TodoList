package edu.vn.todolist.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "todo", catalog = "postgres")
@Data
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "detail")
  private String detail;
}
