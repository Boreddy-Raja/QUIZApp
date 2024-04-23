package com.example.springBootProject_QUIZ.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quizId;
	private String qtitle;
	@ManyToMany
	private List<Question> questions;
	
	
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", qtitle=" + qtitle + ", questions=" + questions + "]";
	}
	public Quiz(Long quizId, String qtitle, List<Question> questions) {
		super();
		this.quizId = quizId;
		this.qtitle = qtitle;
		this.questions = questions;
	}
	public Quiz() {
		super();
	}
	
	
}
