package com.todoapp.AdvancedTodoApp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.todoapp.AdvancedTodoApp.entity.Todo;
import com.todoapp.AdvancedTodoApp.entity.User;
import com.todoapp.AdvancedTodoApp.service.TodoService;
import com.todoapp.AdvancedTodoApp.service.UserService;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;

	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	
	public String listTodo(Principal principal,ModelMap map) {
		
		//get the user by username
		String currentUser=principal.getName();
		User user=userService.findByUsername(currentUser);

		//retrieve all the notes of a particular user 
		List<Todo> list=user.getTodos();
		
		//an empty todo object to add to the formtodo to get values
		Todo todo=new Todo();
		
		//add the value to this form
		map.addAttribute("formTodo",todo);

		//add the list to the newtodo model to get the list of todos
		map.addAttribute("newTodo",list);
		
		return "todo";
	}
	
//	@GetMapping("/register")
//	
//	public String takeInput() {
//		return "registration";
//	}
//	
	@PostMapping("/save")
	
	public String saveTodo(Principal principal,@ModelAttribute("formTodo") Todo todo) {		  

		  //get the user by username
		  String currentUser=principal.getName();
		  User user=userService.findByUsername(currentUser);
		  
		  todo.setUser(user);
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