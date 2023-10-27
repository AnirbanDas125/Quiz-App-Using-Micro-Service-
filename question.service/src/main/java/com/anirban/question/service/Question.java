package com.anirban.question.service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Question {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String category;
	private String difficulty_level;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String question_title;
	private String correct_answer;
	
	public Question() {
		
	}
	
	public Question(long id, String category, String difficulty_level, String option1, String option2, String option3,
			String option4, String question_title, String correct_answer) {
		super();
		this.id = id;
		this.category = category;
		this.difficulty_level = difficulty_level;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.question_title = question_title;
		this.correct_answer = correct_answer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficulty_level() {
		return difficulty_level;
	}

	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	
	
	
	
}
