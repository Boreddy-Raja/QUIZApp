package com.example.springBootProject_QUIZ.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springBootProject_QUIZ.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {
	
	List<Question> findBydifficultyLevel(String difficultyLevel);
	
	
	@Query(value="Select * from question q where q.difficulty_level=:difficultyLevel ORDER BY Rand() LIMIT :noQue", nativeQuery = true)
	List<Question> findRandomByDifficultyLevel(String difficultyLevel, Long noQue);
}
