package com.todoapp.AdvancedTodoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.todoapp.AdvancedTodoApp.entity.User;
import com.todoapp.AdvancedTodoApp.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	//mapping to get to the page
	
	@GetMapping("/register")
	public String openRegisterForm(Model model){

	//create empty user object 
	   User user=new User();
	 //pass this to the model
	   model.addAttribute("registerModel",user);
	   return "registration";
	}
	
	//add mapping for POST /register - add new users
	
	@PostMapping("/saveUser")
   public String addUser(@ModelAttribute("registerModel") User user) {
		 //save the user
		 userService.save(user);
		 return "redirect:/login";
	}
	
	
	
}
