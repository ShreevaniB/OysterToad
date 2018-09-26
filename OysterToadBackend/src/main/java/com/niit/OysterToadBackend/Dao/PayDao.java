package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Pay;

public interface PayDao {
	
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay(String pay_Id);
	public List<Pay> list();
}