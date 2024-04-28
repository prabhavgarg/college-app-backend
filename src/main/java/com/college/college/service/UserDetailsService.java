package com.college.college.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.college.model.UserDetails;

public interface UserDetailsService {
	
	boolean checkUserExists(String emailId);
	
	ResponseEntity<Object> newUser(UserDetails userLoginDetails);
	
	ResponseEntity<Object> signIn(UserDetails userLoginDetails);
	
	ResponseEntity<Object> getUsers();

}
