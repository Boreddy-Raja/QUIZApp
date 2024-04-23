package com.example.springBootProject_QUIZ.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Response {
	
	@Id
	private Long id;
	private String response;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "Response [id=" + id + ", response=" + response + "]";
	}
	public Response(Long id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
