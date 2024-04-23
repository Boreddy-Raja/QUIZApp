package com.example.springBootProject_QUIZ.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootProject_QUIZ.entity.Question;
import com.example.springBootProject_QUIZ.repo.QuestionRepo;
import com.example.springBootProject_QUIZ.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionRepo questionRepo;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>>  getAllQuestions() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/saveQuestion")
	public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
		
		return new ResponseEntity<>(questionRepo.save(question),HttpStatus.CREATED);
	}
	
	@GetMapping("/difficulty/{difficultyLevel}")
	public ResponseEntity<List<Question>> getQuestion(@PathVariable String difficultyLevel) {
		
		List<Question> question = questionRepo.findBydifficultyLevel(difficultyLevel);
		System.out.println(question);
		if(question.isEmpty()){
			return new ResponseEntity<>(question,HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(question,HttpStatus.OK);
		}	
	}
	
	@PutMapping("/updateQuestion/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable Long id,@RequestBody Question questionInput) {
		
		Optional<Question> question = questionRepo.findById(id);
		
		if(question.isPresent()) {
			 
			if(questionInput.getDifficultyLevel()!=null) {
				question.get().setDifficultyLevel(questionInput.getDifficultyLevel());
			}
			else {
				question.get().setDifficultyLevel(question.get().getDifficultyLevel());
			}
			if(questionInput.getQuestionTitle()!=null) {
				question.get().setQuestionTitle(questionInput.getQuestionTitle());
			}
			else {
				question.get().setQuestionTitle(question.get().getQuestionTitle());
			}
			if(questionInput.getOption1()!=null) {
				question.get().setOption1(questionInput.getOption1());
			}
			else {
				question.get().setOption1(question.get().getOption1());
			}
			if(questionInput.getOption2()!=null) {
				question.get().setOption2(questionInput.getOption2());
			}
			else {
				question.get().setOption2(question.get().getOption2());
			}
			if(questionInput.getOption3()!=null) {
				question.get().setOption3(questionInput.getOption3());
			}
			else {
				question.get().setOption3(question.get().getOption3());
			}
			if(questionInput.getOption4()!=null) {
				question.get().setOption4(questionInput.getOption4());
			}
			else {
				question.get().setOption4(question.get().getOption4());
			}
			if(questionInput.getRightAnswer()!=null) {
				question.get().setRightAnswer(questionInput.getRightAnswer());
			}
			else {
				question.get().setRightAnswer(question.get().getRightAnswer());
			}
			
			
			return new ResponseEntity<>(questionRepo.save(question.get()), HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}
	}
}
