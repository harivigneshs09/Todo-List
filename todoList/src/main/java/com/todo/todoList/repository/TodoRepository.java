package com.todo.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todo.todoList.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{

}
