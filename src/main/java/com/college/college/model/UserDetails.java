package com.college.college.model;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetails {
		
	@NotNull(message = "Please provide Username")
	private String userName;
	
	@NotNull(message = "Please provide Password")
	private String password;

}
