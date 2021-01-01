package com.todoapp.AdvancedTodoApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todoapp.AdvancedTodoApp.dao.UserRepository;
import com.todoapp.AdvancedTodoApp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void save(User userObj) {
		String password=passwordEncoder.encode(userObj.getPassword());
		userObj.setPassword(password);
        userRepository.save(userObj);
	}


	@Override
	public User findByUsername(String username) {
		Optional<User> user=userRepository.findByUsername(username);
		return user.get();
	}
	
	

}
