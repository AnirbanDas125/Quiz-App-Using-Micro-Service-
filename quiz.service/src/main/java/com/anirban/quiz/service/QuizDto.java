package com.anirban.quiz.service;

public class QuizDto {

	private String category;
	private int questionNum;
	private String title;
	
	public QuizDto() {
		
	}

	public QuizDto(String category, int questionNum, String title) {
		super();
		this.category = category;
		this.questionNum = questionNum;
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
