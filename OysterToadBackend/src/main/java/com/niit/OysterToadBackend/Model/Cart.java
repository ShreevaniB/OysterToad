package com.niit.OysterToadBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	
	@Id
	private String Cart_Id;
	private double Grand_total=0.0;
	private int Total_items=0;
	
	public Cart()
	{
		this.Cart_Id="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToMany(mappedBy="cart")
	private List<Cart_Items> cart_Items;
	
		
	public List<Cart_Items> getCart_Items() {
		return cart_Items;
	}
	public void setCart_Items(List<Cart_Items> cart_Items) {
		this.cart_Items = cart_Items;
	}
	public String getCart_Id() {
		return Cart_Id;
	}
	public void setCart_Id(String cart_Id) {
		Cart_Id = cart_Id;
	}
	public double getGrand_total() {
		return Grand_total;
	}
	public void setGrand_total(double grand_total) {
		Grand_total = grand_total;
	}
	public int getTotal_items() {
		return Total_items;
	}
	public void setTotal_items(int total_items) {
		Total_items = total_items;
	}
		
	
	

}
