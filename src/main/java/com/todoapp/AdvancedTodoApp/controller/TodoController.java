package com.todoapp.AdvancedTodoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.todoapp.AdvancedTodoApp.entity.Todo;
import com.todoapp.AdvancedTodoApp.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/list")
	
	public String listTodo(ModelMap map) {
		
		List<Todo> list=todoService.findAll();	
		
		Todo todo=new Todo();
		map.addAttribute("formTodo",todo);

		map.addAttribute("newTodo",list);
		
		return "todo";
	}
	
	@GetMapping("/register")
	
	public String takeInput() {
		return "registration";
	}
	
	@PostMapping("/save")
	
	public String saveTodo(@ModelAttribute("formTodo") Todo todo) {
		  todo.setUser(1);
		  todoService.save(todo);
		  return "redirect:/list";
	}
	
//	@GetMapping("/display")
//	
//	public String displayTodo(@ModelAttribute("model") Todo todo, Model dispModel){
//		dispModel.addAttribute("newTodo",todo);
//		return "todo";
//	}
	
}