package com.niit.OysterToadBackend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User {
	
	@Id
	private String useId;
	private String useName;
	private String useAddress;
	private String useCity;
	private String useEmail_id;
	private String usePassword;
	private String usePhone_num;
	
	public User()
	{
		this.useId="USE"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billId")
	private Billing billing;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Cart_Id")
	private Cart cart;
	
	
	
	
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
	}
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getUseAddress() {
		return useAddress;
	}
	public void setUseAddress(String useAddress) {
		this.useAddress = useAddress;
	}
	public String getUseCity() {
		return useCity;
	}
	public void setUseCity(String useCity) {
		this.useCity = useCity;
	}
	public String getUseEmail_id() {
		return useEmail_id;
	}
	public void setUseEmail_id(String useEmail_id) {
		this.useEmail_id = useEmail_id;
	}
	public String getUsePassword() {
		return usePassword;
	}
	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}
	public String getUsePhone_num() {
		return usePhone_num;
	}
	public void setUsePhone_num(String usePhone_num) {
		this.usePhone_num = usePhone_num;
	}
	public String getUmail() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
