package com.niit.OysterToadBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Authentication {

	@Id
	private String Role_id;
	private String Role_Name="ROLE_USER";
	private String User_Name;
	
	public Authentication()
	{
		this.Role_id="AUTHEN"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	public String getRole_id() {
		return Role_id;
	}
	public void setRole_id(String role_id) {
		Role_id = role_id;
	}
	public String getRole_Name() {
		return Role_Name;
	}
	public void setRole_Name(String role_Name) {
		Role_Name = role_Name;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	
	
	
}
