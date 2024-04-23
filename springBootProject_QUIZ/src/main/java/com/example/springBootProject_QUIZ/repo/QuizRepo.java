package com.example.springBootProject_QUIZ.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootProject_QUIZ.entity.Question;
import com.example.springBootProject_QUIZ.entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{

	public Quiz getByQtitle(String qtitle);

}
