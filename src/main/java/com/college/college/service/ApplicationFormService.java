package com.college.college.service;

import org.springframework.http.ResponseEntity;

import com.college.college.model.ApplicationFormRequestModel;

public interface ApplicationFormService {
	
	ResponseEntity<Object> save(ApplicationFormRequestModel applicationFormRequestModel);
	
	ResponseEntity<Object> update(ApplicationFormRequestModel applicationFormRequestModel);
	
	ResponseEntity<Object> fetch(String emailId);
	
}
