package com.anirban.question.service;

public class Response {

	private long id;
	private String response;
	
	public Response(){
		
	}
	public Response(long id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
