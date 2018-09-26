package com.niit.OysterToadBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Order_Items {
	
	@Id
	private String OrderItems_Id;
	private String Product_Id;
	
	public Order_Items()
	{
		this.OrderItems_Id="ORDERITEMS"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billing;
	
	@OneToOne
	@JoinColumn(name="Ship_Id")
	private Shipping shipping;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="useId")
	private User user;
	
	@OneToOne
	@JoinColumn(name="Pay_Id")
	private Pay pay;
	
	
	@ManyToOne
	@JoinColumn(name="Order_Id")
	private Order order;
	
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderItems_Id() {
		return OrderItems_Id;
	}
	public void setOrderItems_Id(String orderItems_Id) {
		OrderItems_Id = orderItems_Id;
	}
	public String getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(String product_Id) {
		Product_Id = product_Id;
	}
	
	

}
