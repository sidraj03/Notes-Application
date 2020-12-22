package com.todoapp.AdvancedTodoApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.AdvancedTodoApp.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer>{

	
}
