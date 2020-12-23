package com.todoapp.AdvancedTodoApp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.todoapp.AdvancedTodoApp.dao.UserRepository;
import com.todoapp.AdvancedTodoApp.entity.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void save(User userObj) {
        userRepository.save(userObj);
	}

}
