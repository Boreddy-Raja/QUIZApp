package com.example.springBootProject_QUIZ.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootProject_QUIZ.entity.Question;
import com.example.springBootProject_QUIZ.entity.QuestionWrapper;
import com.example.springBootProject_QUIZ.entity.Quiz;
import com.example.springBootProject_QUIZ.entity.Response;
import com.example.springBootProject_QUIZ.repo.QuestionRepo;
import com.example.springBootProject_QUIZ.repo.QuizRepo;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuestionRepo questionRepo;
	
	@PostMapping("/create")
	public ResponseEntity<Quiz> createQuiz(@RequestParam String difficultyLevel, @RequestParam Long noQue, @RequestParam String qtitle) {
		
		List<Question> questions = questionRepo.findRandomByDifficultyLevel(difficultyLevel,noQue);
		
		Quiz quiz = new Quiz();
		
		quiz.setQtitle(qtitle);
		quiz.setQuestions(questions);
		
		return new ResponseEntity<Quiz>(quizRepo.save(quiz), HttpStatus.CREATED);
	}
	
	@GetMapping("/getQuiz/{qtitle}")
	public ResponseEntity<List<QuestionWrapper>> getQuizByQtitle(@PathVariable String qtitle) {
		
		Quiz quiz=quizRepo.getByQtitle(qtitle);
		
		List<Question> questionsFromDb = quiz.getQuestions();
		
		List<QuestionWrapper> questionForUser = new ArrayList();
		
		for(Question q:questionsFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
			questionForUser.add(qw);
		}
		 
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
		
	}
	
	@PostMapping("/submit/{type}")
	public Integer submitScore(@PathVariable String type, @RequestBody List<Response> response) {
		
		Quiz quiz=quizRepo.getByQtitle(type);
		
		List<Question> questionsFromDb = quiz.getQuestions();
		
		int count=0;
		
		for(Response r : response) {
			Long idFromResponse = r.getId();
			String resFromResponse = r.getResponse();
			for(Question q : questionsFromDb ) {
				if(q.getId()==idFromResponse && q.getRightAnswer().equalsIgnoreCase(resFromResponse)) {
					 count = count+1;
					 break;
				}
			}
		}
		return count;	
	}
	
	
}
