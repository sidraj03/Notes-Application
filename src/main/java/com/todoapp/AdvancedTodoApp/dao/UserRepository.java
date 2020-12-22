package com.todoapp.AdvancedTodoApp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.AdvancedTodoApp.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User>findByUsername(String username);
}
