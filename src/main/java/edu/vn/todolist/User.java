package edu.vn.todolist;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "users", catalog = "postgres")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;
}
