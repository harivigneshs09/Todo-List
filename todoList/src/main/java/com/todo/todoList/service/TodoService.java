package com.todo.todoList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todoList.model.Todo;
import com.todo.todoList.repository.TodoRepository;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	
	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository=todoRepository;
	}
	
	
	public Todo addTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public List<Todo> getAllTodos(){
		return todoRepository.findAll();		
	}
	
	public Todo getTodoById(Long id) {
		return todoRepository.findById(id).orElse(null);
	}
	
	public Todo saveOrUpdate(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public void deleteTodoById(Long id) {
		todoRepository.deleteById(id);
	}

}
