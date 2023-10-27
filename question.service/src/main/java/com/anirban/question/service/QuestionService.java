package com.anirban.question.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	
	
		public ResponseEntity<List<Question>> getAllQuestions(){
			try {
				return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
			}		
		}
	

		public ResponseEntity<List<Question>> getQuestionsByCategory(String subject) {
			try {
				return new ResponseEntity<>(questionDao.findByCategory(subject),HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
			}
			
			
		}

		public ResponseEntity<String> addNewQuestion(Question question) {
			try {
				questionDao.save(question);
				return new ResponseEntity<>("New Iteam Created",HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				return ResponseEntity.badRequest().body("Body could not be added");
			}	
		}

		public String updateQuestion(Question question) {
			try {
			 questionDao.save(question);
			 return "Successfully Updated";	
			}catch(Exception e) {
				e.printStackTrace();
				return e.getMessage();
			}
		}

		public ResponseEntity<String> deleteQuestion(long id) {
			
			try {
				if(questionDao.existsById(id)) {
					questionDao.deleteById(id);
					return new ResponseEntity<>("Question deleted of ID "+id,HttpStatus.OK);	
				}else {
					return ResponseEntity.badRequest().body("Question does not exist by ID "+id);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.badRequest().body("Could not delete, Didn't found the ID "+id);
			}
			
		}


		public ResponseEntity<List<Integer>> getQuizByCategory(String category, int questionNum) {
			List<Integer> question = questionDao.findRandomQuestionByCategory(category, questionNum);
			
			return new ResponseEntity<>(question,HttpStatus.OK);
		}


		public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Long> questionsIds) {
			List<QuestionWrapper> wrappers = new ArrayList<>();
			List<Question> questions = new ArrayList<>();
			
			for(Long eachId : questionsIds) {
				Optional<Question> opQues = questionDao.findById(eachId);
				if(opQues.isEmpty()) {
					throw new RuntimeException("Question not found by ID "+eachId);
				}else {
					questions.add(opQues.get());
				}	
			}
			
			for(Question question : questions) {
				QuestionWrapper qw = new 
				                         QuestionWrapper(question.getId(),question.getOption1(),question.getOption2(),
						                    question.getOption3(),question.getOption4(),question.getQuestion_title());
				wrappers.add(qw);
			}
			
			return new ResponseEntity<>(wrappers,HttpStatus.OK);
		}


		public ResponseEntity<String> getScore(List<Response> responses) {
			int score=0;
			for(Response response: responses) {
				Optional<Question> question = questionDao.findById(response.getId());
				if(question.isEmpty()) {
					throw new RuntimeException("Question nor found by ID "+response.getId());
				}else {
				  if(question.get().getCorrect_answer().equals(response.getResponse())) {
					  score++;
				  }	
				}
			}
			return new ResponseEntity<>("You got "+score+"/"+responses.size(),HttpStatus.OK);
		}
}
