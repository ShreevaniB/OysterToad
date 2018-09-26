package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Cart;
import com.niit.OysterToadBackend.Model.Cart_Items;

public interface Cart_ItemsDao {
	
	public boolean saveorupdate(Cart_Items cart_Items);
	public boolean delete(Cart_Items cart_Items);
	public Cart_Items getCart_Items(String cartItems_Id);
	public List<Cart_Items> list();
	public List<Cart_Items> getlist(String CartItems_id);
	public Cart_Items getlistall(String ctId,String proId);
	public List<Cart_Items> getlistbyproId(String proId);
//	public Cart_Items get(String id);
	public boolean deleteCt(String cartItems_Id);
	public Cart_Items get(String cart_Id);
	public void delete(Cart cart);
}
