package com.todoapp.AdvancedTodoApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.AdvancedTodoApp.dao.UserRepository;
import com.todoapp.AdvancedTodoApp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void save(User userObj) {
        userRepository.save(userObj);
	}


	@Override
	public User findByUsername(String username) {
		Optional<User> user=userRepository.findByUsername(username);
		return user.get();
	}
	
	

}
