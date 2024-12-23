package com.todo.todoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoList.model.Todo;
import com.todo.todoList.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public List<Todo> getAllTodos(){
		return todoService.getAllTodos();
	}
	
	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable Long id)
	{
		return todoService.getTodoById(id);
	}
	
	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);
	}
	
	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
		todo.setId(id);
		if(id == null) {
			System.out.println("Id not found...");
		}
		return todoService.saveOrUpdate(todo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodoById(@PathVariable Long id) {
		todoService.deleteTodoById(id);
	}
}
