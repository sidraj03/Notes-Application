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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todoapp.AdvancedTodoApp.entity.Todo;
import com.todoapp.AdvancedTodoApp.entity.User;
import com.todoapp.AdvancedTodoApp.service.TodoService;
import com.todoapp.AdvancedTodoApp.service.UserService;


@Controller
@RequestMapping(value={"/archive"})
public class ArchiveController {

	@Autowired
	UserService userService;
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/list")
	public String showArchivePage(Principal principal,ModelMap map) {	
			
		    //get the user by username
			String currentUser=principal.getName();
			User user=userService.findByUsername(currentUser);

			//retrieve all the notes of a particular user 
			List<Todo> list=user.getTodos();
			
			for (Iterator<Todo> iterator = list.iterator(); iterator.hasNext(); ) {
			    Todo todo = iterator.next();
			   if(todo.getCategory()==null)
				   iterator.remove();   
			}
			
			//an empty todo object to add to the formtodo to get values
			Todo todo=new Todo();
			
			//add the value to this form
			map.addAttribute("formTodo",todo);

			//add the list to the newtodo model to get the list of todos
			map.addAttribute("newTodo",list);
		
		return "archive";
	}
	
	
	@GetMapping("/delete")
	public String displayTodo(@RequestParam("id") int theId){
		todoService.deleteById(theId);
		return "redirect:/archive/list";
	}
	
	@PostMapping("/update")
    public String updateArchiveTodo(Principal principal,@ModelAttribute("formTodo") Todo todo) {		  

		  //get the user by username
	      Todo currTodo=todoService.findById(todo.getId());
	      
	      currTodo.setTitle(todo.getTitle());
	      currTodo.setText(todo.getText());
		 
		  todoService.save(currTodo);
		  return "redirect:/archive/list";
	}
	
}
