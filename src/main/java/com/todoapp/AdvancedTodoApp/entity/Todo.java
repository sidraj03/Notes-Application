package com.todoapp.AdvancedTodoApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	

	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="user_con")
	private User targetUser;

	public Todo() {
		
	}

	public Todo(String title, String text, String category,User targetUser) {
		this.title = title;
		this.text = text;
		this.category = category;
		this.targetUser = targetUser;
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

//	public User getUsercon() {
//		return usercon;
//	}
//
//	public void setUsercon(User usercon) {
//		this.usercon = usercon;
//	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", text=" + text + ", category=" + category + ", targetUser="
				+ targetUser + "]";
	}

	
	
	



	
	
	
}
