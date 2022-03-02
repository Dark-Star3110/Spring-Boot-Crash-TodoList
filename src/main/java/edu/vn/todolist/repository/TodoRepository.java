package edu.vn.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.vn.todolist.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
