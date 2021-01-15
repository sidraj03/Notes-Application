package com.todoapp.AdvancedTodoApp.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		for (Iterator<Todo> iterator = list.iterator(); iterator.hasNext(); ) {
		    Todo todo = iterator.next();
		   if(todo.getCategory()==null)
			   continue;
		   else if(todo.getCategory().equals("archive")) {
		        iterator.remove();
		     }
		    
		}
		
		//an empty todo object to add to the formtodo to get values
		Todo todo=new Todo();
		
		//add the value to this form
		map.addAttribute("formTodo",todo);

		//add the list to the newtodo model to get the list of todos
		map.addAttribute("newTodo",list);
		
		//add the value to display the contents of the fo
		map.addAttribute("editTodo",todo);
		
		return "todo";
	}
		
	@PostMapping("/save")
	public String saveTodo(Principal principal,@ModelAttribute("formTodo") Todo todo) {		  

		  //get the user by username
		  String currentUser=principal.getName();
		  User currUser=userService.findByUsername(currentUser);
		  
		  todo.setTargetUser(currUser);
		  todoService.save(todo);
		  return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String displayTodo(@RequestParam("id") int theId){
		todoService.deleteById(theId);
		return "redirect:/list";
	}
	
	
	@PostMapping("/update")
    public String updateTodo(Principal principal,@ModelAttribute("formTodo") Todo todo) {		  

		  //get the user by username
	      Todo currTodo=todoService.findById(todo.getId());
	      
	      currTodo.setTitle(todo.getTitle());
	      currTodo.setText(todo.getText());
		 
		  todoService.save(currTodo);
		  return "redirect:/list";
	}
	
	@GetMapping("/category")
	
	public String updateTodoCategory(@RequestParam("id") int noteId){
		//archive todo
		todoService.updateNotesCategory(noteId);
		return "redirect:/list";
	}

	
}