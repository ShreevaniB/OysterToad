package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Authentication;


public interface AuthenticationDao {
	
	public boolean saveorupdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication getAuthentication(String Role_Id);
	public List<Authentication> list();
}