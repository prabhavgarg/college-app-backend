package com.college.college.service.impl;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.college.model.UserDetails;
import com.college.college.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private HashMap<String, String> users = new HashMap<>();

	@Override
	public boolean checkUserExists(String emailId) {
		return users.containsKey(emailId);
	}

	@Override
	public ResponseEntity<Object> newUser(UserDetails userLoginDetails) {
		users.put(userLoginDetails.getUserName(), userLoginDetails.getPassword());
		return new ResponseEntity<>("User Added", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getUsers() {
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> signIn(UserDetails userLoginDetails) {
		boolean passwordMatch = userLoginDetails.getPassword().equals(users.get(userLoginDetails.getUserName()));
		return passwordMatch ? new ResponseEntity<>("Successfully LoggedIn", HttpStatus.OK) : new ResponseEntity<>("Wrong Password", HttpStatus.OK);
	}

}
