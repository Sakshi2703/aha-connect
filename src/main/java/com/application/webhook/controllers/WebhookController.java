package com.application.webhook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.webhook.services.WebhookService;

@RestController
public class WebhookController {
	
	@Autowired
	private WebhookService webhookService;
	
	@GetMapping("/contents")
	public Object getDataFromAha() {
		Object data = webhookService.fetchContents();
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	}
	
	@PostMapping("/webhook")
	public Object fetchDataFromAha(@RequestBody String requestPayload) {
		Object data = webhookService.saveContents(requestPayload);
		return new ResponseEntity<Object>(data,HttpStatus.CREATED);
	}
	
	@GetMapping("/clear")
	public Object clearDataFromContents() {
		Object data = webhookService.clearContent();
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	}
}
