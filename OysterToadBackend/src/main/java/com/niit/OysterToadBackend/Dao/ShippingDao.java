package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Shipping;

public interface ShippingDao {
	
	public boolean saveorupdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getShipping(String ship_Id);
	public List<Shipping> list();
	public List<Shipping> getaddbyuser(String useId);
}