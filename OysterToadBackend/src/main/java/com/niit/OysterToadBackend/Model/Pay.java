package com.niit.OysterToadBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Pay {
	
	@Id
	private String Pay_Id;
	private String Pay_Method;
	private String Pay_Status;
	
	public Pay()
	{
		this.Pay_Id="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToOne
	@JoinColumn(name="Order_Id")
	private Order order;
	
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getPay_Id() {
		return Pay_Id;
	}
	public void setPay_Id(String pay_Id) {
		Pay_Id = pay_Id;
	}
	public String getPay_Method() {
		return Pay_Method;
	}
	public void setPay_Method(String pay_Method) {
		Pay_Method = pay_Method;
	}
	public String getPay_Status() {
		return Pay_Status;
	}
	public void setPay_Status(String pay_Status) {
		Pay_Status = pay_Status;
	}
	
	

}
