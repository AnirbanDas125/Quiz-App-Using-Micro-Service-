package com.anirban.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int questionNum, String title) {
      
	      List<Integer> questions = quizInterface.getQuizByCategory(category, questionNum).getBody();
	      
	      Quiz quiz = new Quiz();
	      quiz.setQuiz_title(title);
	      quiz.setQuestionsIds(questions);
	      quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int quiz_id) {
		
		Optional<Quiz> quizById = quizDao.findById(quiz_id);
		if(quizById.isEmpty()) {
			throw new RuntimeException("Could not find a quiz by ID "+quiz_id);
		}
			List<Integer> questionIdsByQuizId = quizById.get().getQuestionsIds();
			List<QuestionWrapper> questionForUser = quizInterface.getQuestionById(questionIdsByQuizId.stream()
	                .map(Long::valueOf) 
	                .collect(Collectors.toList())).getBody();
		
		

		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<String> getQuizScore(int id, List<Response> response) {
		
		String score = quizInterface.getScore(response).getBody();
		
		
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
}
