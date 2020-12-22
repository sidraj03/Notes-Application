package com.todoapp.AdvancedTodoApp.service;

import java.util.List;

import com.todoapp.AdvancedTodoApp.entity.Todo;

public interface TodoService {

    public List<Todo> findAll();
	
	public Todo findById(int theId);
	 
	public void save(Todo todoObj);
	
	public void deleteById(int theId);
	
}
