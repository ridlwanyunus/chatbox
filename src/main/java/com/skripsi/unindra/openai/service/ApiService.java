package com.skripsi.unindra.openai.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skripsi.unindra.openai.request.QuestionRequest;

@Service
public class ApiService {
	
	private RestTemplate restTempate = new RestTemplate();
	
	@Value("${api.server}")
	private String apiUrl;
	
	public String refresh() {
		
		String url = apiUrl +"/refresh";
		
		String result = restTempate.getForObject(url, String.class);
		
		return result;
		
	}

	public String question(QuestionRequest question) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<QuestionRequest> requestBody = new HttpEntity<QuestionRequest>(question, headers);
		
		String url = apiUrl +"/question";
		
		String result = restTempate.postForObject(url, requestBody, String.class);
		String answer = result.replace("\\n", "<br/>").replaceAll("\"", "");
		return answer;
		
	}
	
}
