package com.example.springBootProject_QUIZ.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springBootProject_QUIZ.entity.Question;
import com.example.springBootProject_QUIZ.repo.QuestionRepo;

public class QuestionDAO {
	
	@Autowired
	QuestionRepo questionRepo;

	public List<Question> getAllQuestions() {
		
		return questionRepo.findAll();
		
	}

	public ResponseEntity<Question> saveQuestion(Question question) {
		System.out.println(question);
		return new ResponseEntity<>(questionRepo.save(question),HttpStatus.CREATED);
	}

}
