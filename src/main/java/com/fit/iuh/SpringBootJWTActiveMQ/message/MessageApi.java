package com.fit.iuh.SpringBootJWTActiveMQ.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fit.iuh.SpringBootJWTActiveMQ.service.ProducerService;

@RestController
@RequestMapping("/producer")
public class MessageApi {
	@Autowired private ProducerService pService;
	
	@PostMapping("/")
	public String producer(@RequestBody String text) throws JsonProcessingException {
		pService.sendToTopic(text);
		
		return text;
	}
}
