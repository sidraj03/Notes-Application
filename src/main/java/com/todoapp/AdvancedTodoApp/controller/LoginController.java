package com.todoapp.AdvancedTodoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
//	@GetMapping("/logout")
//	public String showlogout() {
//		return "login";
//	}
	
}
