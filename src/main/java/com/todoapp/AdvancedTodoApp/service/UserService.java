package com.todoapp.AdvancedTodoApp.service;

import com.todoapp.AdvancedTodoApp.entity.User;

public interface UserService  {
	public void save(User userObj);
	public User findByUsername(String username);
}
