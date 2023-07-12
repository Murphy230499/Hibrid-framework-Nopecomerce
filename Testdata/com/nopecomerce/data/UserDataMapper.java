package com.nopecomerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + ""), UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAdress")
	private String emailAdress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("login")
	private String login;
	
	static class Login{
		@JsonProperty("userName")
		private static String userName;
		
		@JsonProperty("password")
		private static String password;
		
		
	}
	
	public String getUserName() {
		return Login.userName;
	}
	
	public String getLoginPassword() {
		return Login.password;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public String getPassword() {
		return password;
	}
}
