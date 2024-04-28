package com.college.college.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.college.model.UserDetails;
import com.college.college.service.UserDetailsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService;

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ResponseEntity<Object> newUser(@Valid @RequestBody UserDetails userLoginDetails)  {

		//user exists with same email
		if(userDetailsService.checkUserExists(userLoginDetails.getUserName())) {
			return new ResponseEntity<>("user is already present", HttpStatus.OK);
		}
		//save details
		return userDetailsService.newUser(userLoginDetails);
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ResponseEntity<Object> signIn(@Valid @RequestBody UserDetails userLoginDetails)  {

		//user exists with same email
		if(!userDetailsService.checkUserExists(userLoginDetails.getUserName())) {
			return new ResponseEntity<>("user is not present", HttpStatus.OK);
		}
		//save details
		return userDetailsService.signIn(userLoginDetails);
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<Object> getUsers()  {
		return userDetailsService.getUsers();
	}

}
