package com.anirban.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
//		Optional<Quiz> quiz = quizDao.findById(quiz_id);
//		
//		if(quiz.isEmpty()) {
//			throw new RuntimeException("Quiz could not be found by ID "+quiz_id);
//		}
//		List<Question> questionFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
//		
//		for(Question q : questionFromDB) {
//			QuestionWrapper qw = new 
//					QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestion_title());
//			
//			
//			questionForUser.add(qw);
//			
//		}
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getQuizScore(int id, List<Response> response) {
		
		Optional<Quiz> q = quizDao.findById(id);
		if(q.isEmpty()) {
			throw new RuntimeException("Could not find a quiz by ID "+id);
		}
		Quiz quiz = q.get();
//		List<Question> questions = quiz.getQuestions();
//		
		int score =0;
//		int i=0;
//		for(Question q1 : questions) {
//		  if(q1.getCorrect_answer().equals(response.get(i).getResponse())) {
//			 score++; 
//		  }
//		  i++;
//		}
		
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
}
