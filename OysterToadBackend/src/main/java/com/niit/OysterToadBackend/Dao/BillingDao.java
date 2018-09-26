package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Billing;

public interface BillingDao {
	
	public boolean saveorupdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBilling(String billId);
	public List<Billing> list();
	public Billing get(String useId);
}