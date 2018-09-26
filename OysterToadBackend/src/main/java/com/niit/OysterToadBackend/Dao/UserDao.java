package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.User;

public interface UserDao {
	
	public boolean saveorupdate(User user);
	public boolean delete(User user);
	public User getUser(String useId);
	public List<User> list();
	public User isValid(String email, String pwd);
	public User getEmail(String currusername);
}
