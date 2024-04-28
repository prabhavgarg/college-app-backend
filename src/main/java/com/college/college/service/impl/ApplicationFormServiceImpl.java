package com.college.college.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.college.model.ApplicationFormRequestModel;
import com.college.college.service.ApplicationFormService;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	private List<ApplicationFormRequestModel> applicationForm = new ArrayList<>();

	@Override
	public ResponseEntity<Object> save(ApplicationFormRequestModel applicationFormRequestModel) {
		
		if(!userDetailsServiceImpl.checkUserExists(applicationFormRequestModel.getEmailId())){
			return new ResponseEntity<>("User Not Present", HttpStatus.OK);
		}
		
		for(ApplicationFormRequestModel model : applicationForm) {
			if(applicationFormRequestModel.getEmailId().equals(model.getEmailId())){
				update(applicationFormRequestModel);
				return new ResponseEntity<>("Application Form Saved!!", HttpStatus.OK);
//				return new ResponseEntity<>("Application Already Present!!", HttpStatus.OK);
			}
		}
		applicationForm.add(applicationFormRequestModel);
		return new ResponseEntity<>("Application Form Saved!!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> update(ApplicationFormRequestModel applicationFormRequestModel) {
		for(ApplicationFormRequestModel model : applicationForm) {
			if(applicationFormRequestModel.getEmailId().equals(model.getEmailId())){
				model.setFirstName(applicationFormRequestModel.getFirstName());
				model.setLastName(applicationFormRequestModel.getLastName());
				model.setEmailId(applicationFormRequestModel.getEmailId());
				model.setPhoneNumber(applicationFormRequestModel.getPhoneNumber());
				model.setAddress(applicationFormRequestModel.getAddress());
				model.setCity(applicationFormRequestModel.getCity());
				model.setState(applicationFormRequestModel.getState());
				model.setZip(applicationFormRequestModel.getZip());
				model.setCourse(applicationFormRequestModel.getCourse());
				model.setTwelthmarks(applicationFormRequestModel.getTwelthmarks());
				return new ResponseEntity<>(applicationFormRequestModel, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("No Data Available..!!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> fetch(String emailId) {
		for(ApplicationFormRequestModel model : applicationForm) {
			if(emailId.equals(model.getEmailId())){
				return new ResponseEntity<>(model, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("No Data Available!!", HttpStatus.OK);
	}

}
