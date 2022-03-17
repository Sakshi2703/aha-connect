package com.application.webhook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class WebhookService {
	
	List<Object> contents = new ArrayList();
	
	public Object saveContents(String requestData) {
		Gson gson = new Gson();
		Object element = gson.fromJson(requestData, Object.class);
		contents.add(element);
		return element;
	}
	
	public Object fetchContents() {
		return contents;
	}
	
	public Boolean clearContent() {
		contents.clear();
		return true;
	}
}
