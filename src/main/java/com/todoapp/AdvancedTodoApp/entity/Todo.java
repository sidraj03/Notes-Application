package com.todoapp.AdvancedTodoApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Todo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="notes_id")
	private int id;
	
	@Column(name="notes_title")
	private String title;
	
	@Column(name="notes_text")
	private String text;
	
	@Column(name="notes_category")
	private String category;
	
//	
//	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
//            CascadeType.DETACH,CascadeType.REFRESH})
//    @JoinColumn(name="instructor_id")
	private int user;
//	
	public Todo() {
		
	}

	public Todo(String title, String text, String category) {
		this.title = title;
		this.text = text;
		this.category = category;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", text=" + text + ", category=" + category + "]";
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}



	
	
	
}
