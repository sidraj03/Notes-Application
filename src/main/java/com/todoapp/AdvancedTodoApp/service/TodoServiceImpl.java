package com.todoapp.AdvancedTodoApp.service;

import java.util.List;
import java.util.Optional;

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
		
       Optional<Todo> todo=todoRepository.findById(theId);
		
		Todo theTodo=null;
		
		if(todo.isPresent()) {
			theTodo=todo.get();
		}
		else {
			//we didn't find the employee at the given id
			throw new RuntimeException("Did not find the requested todo"); 
		}
		
		return theTodo;
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

	@Override
	@Transactional
	public void updateNotesCategory(int notesId) {
		todoRepository.updateNotesCategory(notesId);
	}

//	@Override
//	@Transactional
//	public List<> selectUnarchived() {
//		return todoRepository.selectunarchived();
//	}

}
