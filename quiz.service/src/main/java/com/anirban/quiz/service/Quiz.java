package com.anirban.quiz.service;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {
 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String quiz_title;
/*The @ElementCollection annotation in Spring Boot is used when you need to map a collection of simple values 
 * (such as basic data types or embeddable classes) that are not entities themselves and are associated with an owning entity. 
 * You would use @ElementCollection*/	
	@ElementCollection
	private List<Integer> questionsIds;

	public Quiz() {
		//Empty constructor is needed  
	}

	public Quiz(int id, String quiz_title, List<Integer> questionsIds) {
		super();
		this.id = id;
		this.quiz_title = quiz_title;
		this.questionsIds = questionsIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuiz_title() {
		return quiz_title;
	}

	public void setQuiz_title(String quiz_title) {
		this.quiz_title = quiz_title;
	}

	public List<Integer> getQuestionsIds() {
		return questionsIds;
	}

	public void setQuestionsIds(List<Integer> questionsIds) {
		this.questionsIds = questionsIds;
	}
	
	
	
	
}
