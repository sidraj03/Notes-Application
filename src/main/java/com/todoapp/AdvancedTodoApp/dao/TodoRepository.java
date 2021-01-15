package com.todoapp.AdvancedTodoApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todoapp.AdvancedTodoApp.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer>{
	
	@Modifying
	@Query("update Todo todo set todo.category='archive' where todo.id=:id")
	void updateNotesCategory(@Param("id") int id);
	 
//	@Query("select todo from Todo todo where todo.category not like 'archive'")
//	List<Todo> selectunarchived();
	
	
}
