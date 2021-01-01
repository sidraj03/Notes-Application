package com.todoapp.AdvancedTodoApp.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todoapp.AdvancedTodoApp.dao.UserRepository;
import com.todoapp.AdvancedTodoApp.entity.User;

@Service

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user=userRepository.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("Not found"+username));
		return user.map(MyUserDetails::new).get();
	}
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();} 

}
