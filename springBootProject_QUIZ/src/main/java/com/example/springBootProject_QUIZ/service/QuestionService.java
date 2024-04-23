package com.example.springBootProject_QUIZ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springBootProject_QUIZ.DAO.QuestionDAO;
import com.example.springBootProject_QUIZ.entity.Question;

@Service
public class QuestionService {
	
	@Autowired(required=false)
	QuestionDAO questionDAO;
	
	public List<Question> getAllQuestions() {
		
		return questionDAO.getAllQuestions();
	}

	public ResponseEntity<Question> saveQuestion(Question question) {
		
		return questionDAO.saveQuestion(question);
	}

}
