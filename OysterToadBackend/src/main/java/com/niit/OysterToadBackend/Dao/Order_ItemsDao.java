package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Order_Items;

public interface Order_ItemsDao {
	
	public boolean saveorupdate(Order_Items order_Items);
	public boolean delete(Order_Items order_Items);
	public Order_Items getOrder_Items(String OrderItems_Id);
	public List<Order_Items> list();
}