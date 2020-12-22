package com.todoapp.AdvancedTodoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todoapp.AdvancedTodoApp.dao.TodoRepository;
import com.todoapp.AdvancedTodoApp.entity.Todo;


@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	@Transactional
	public Todo findById(int theId) {
		return null;
	}

	@Override
	@Transactional
	public void save(Todo todoObj) {
	   todoRepository.save(todoObj);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		 todoRepository.deleteById(theId);
	}



}
