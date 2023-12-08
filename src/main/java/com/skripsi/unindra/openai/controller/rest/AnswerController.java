package com.skripsi.unindra.openai.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skripsi.unindra.openai.request.QuestionRequest;
import com.skripsi.unindra.openai.service.ApiService;

@RestController
@RequestMapping("answer")
public class AnswerController {
	
	@Autowired
	private ApiService apiService;

	@GetMapping("hello")
	public String hello() {
		return "<ul><li>Hello juga</li><li>Hello\njuga</li></ul>";
	}
	
	@GetMapping("refresh")
	public String refresh() {
		
		return apiService.refresh();
		
	}
	
	@PostMapping("question")
	public String question(@RequestBody QuestionRequest request) {
		
		return apiService.question(request);
		
	}
	
	
}
