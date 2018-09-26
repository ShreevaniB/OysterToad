package com.niit.OysterToadBackend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart_Items {
	
	@Id
	private String CartItems_Id;
	private double Price;
	
	public Cart_Items()
	{
		this.CartItems_Id="CARTITEMS"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@ManyToOne
	@JoinColumn(name="Cart_Id")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="proId")
	private Product product;
	
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getCartItems_Id() {
		return CartItems_Id;
	}
	public void setCartItems_Id(String cartItems_Id) {
		CartItems_Id = cartItems_Id;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	

}
