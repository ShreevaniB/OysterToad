package com.niit.OysterToadBackend.Dao;

import java.util.List;

import com.niit.OysterToadBackend.Model.Cart_Items;
import com.niit.OysterToadBackend.Model.Category;
import com.niit.OysterToadBackend.Model.Product;
import com.niit.OysterToadBackend.Model.Supplier;

public interface ProductDao {
	
	public boolean saveorupdate(Product product);
	public boolean delete(Product product);
	public Product getProduct(String proId);
	public List<Product> list();
	public Supplier getSupplier(String supId);
	public Category getCategory(String catId);
	public Cart_Items getCart_Items(String cartItems_Id);

}
