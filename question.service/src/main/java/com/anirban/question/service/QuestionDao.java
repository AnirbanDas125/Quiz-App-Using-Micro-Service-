package com.anirban.question.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionDao extends JpaRepository<Question,Long>{

	
	public List<Question> findByCategory(String subject);
	
	@Query(value = "SELECT q.id FROM question q Where q.category= :category ORDER BY RANDOM() LIMIT :questionNum", nativeQuery=true)
	public List<Integer> findRandomQuestionByCategory(String category, int questionNum);
	
}
