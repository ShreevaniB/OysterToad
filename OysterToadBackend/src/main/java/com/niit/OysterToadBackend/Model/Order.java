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
@Table(name="Orders")
@Component
public class Order {
	
	@Id
	private String Order_Id;
	private double Grand_total;
	private String Order_date;
	private String Order_Time;
	
	public Order()
	{
		this.Order_Id="ORDER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Ship_Id")
	private Shipping shipping;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="useId")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Pay_Id")
	private Pay pay;
	
	@OneToMany(mappedBy="order")
	private List<Order_Items> order_Items;
	
	
	
	public List<Order_Items> getOrder_Items() {
		return order_Items;
	}
	public void setOrder_Items(List<Order_Items> order_Items) {
		this.order_Items = order_Items;
	}
	public String getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}
	public double getGrand_total() {
		return Grand_total;
	}
	public void setGrand_total(double grand_total) {
		Grand_total = grand_total;
	}
	public String getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(String order_date) {
		Order_date = order_date;
	}
	public String getOrder_Time() {
		return Order_Time;
	}
	public void setOrder_Time(String order_Time) {
		Order_Time = order_Time;
	}
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
	
	
	

}
