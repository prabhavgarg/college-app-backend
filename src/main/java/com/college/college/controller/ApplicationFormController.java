package com.college.college.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.college.model.ApplicationFormRequestModel;
import com.college.college.model.UserDetails;
import com.college.college.service.ApplicationFormService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ApplicationFormController {

	@Autowired
	ApplicationFormService applicationService;

	@RequestMapping(value = "/newApplication", method = RequestMethod.POST)
	public ResponseEntity<Object> newApplication(@Valid @RequestBody ApplicationFormRequestModel applicationFormRequestModel)  {

		//save details
		return applicationService.save(applicationFormRequestModel);
	}

	@RequestMapping(value = "/updateApplication", method = RequestMethod.POST)
	public ResponseEntity<Object> updateApplication(@Valid @RequestBody ApplicationFormRequestModel applicationFormRequestModel)  {

		//update details
		return applicationService.update(applicationFormRequestModel);
	}

	@RequestMapping(value = "/getApplication", method = RequestMethod.POST)
	public ResponseEntity<Object> getApplication(@Valid @RequestBody UserDetails userDetials)  {

		//get details
		return applicationService.fetch(userDetials.getUserName());
	}

}
