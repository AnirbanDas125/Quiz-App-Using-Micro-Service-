package com.anirban.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;

//@RequestParam this annotation is used to extract query parameter from the URI
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		return quizService.createQuiz(quizDto.getCategory(),quizDto.getQuestionNum(),quizDto.getTitle());
	}
	
	@GetMapping("/get/{quiz_id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int quiz_id){
		
		return quizService.getQuizQuestions(quiz_id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<String> submitQuizCalculateScore(@PathVariable int id, @RequestBody List<Response> response){
		
		return  quizService.getQuizScore(id,response);
	}
		
	

}
