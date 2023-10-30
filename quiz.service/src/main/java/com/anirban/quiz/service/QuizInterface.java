package com.anirban.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("QUESTION.SERVICE") //This annotation and the interface will let us get data through http request from other microservices
//This is how OpenFeign is used
public interface QuizInterface {
//Inside the interface we mention the methods(api end points) that we want this service to access from other service
//Since this is a interface we are only declaring the methods, and we already got the definition in the question.service controller   
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuizByCategory
	                              (@RequestParam String category, @RequestParam int questionNum);
	
	@PostMapping("question/getQuestions")//Have to mention the full URL in the question.service controller
	public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Long> questionsIds);
	
	@PostMapping("question/getScore")
	public ResponseEntity<String> getScore(@RequestBody List<Response> responses);

}
