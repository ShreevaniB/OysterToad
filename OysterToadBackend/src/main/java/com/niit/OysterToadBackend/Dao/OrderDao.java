package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Order;

public interface OrderDao {
	
	public boolean saveorupdate(Order order);
	public boolean delete(Order order);
	public Order getOrder(String Order_Id);
	public List<Order> list();
}