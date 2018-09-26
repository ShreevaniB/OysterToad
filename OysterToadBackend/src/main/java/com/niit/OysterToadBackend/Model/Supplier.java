package com.niit.OysterToadBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {

	@Id
	private String supId;
	private String supName;
	private String supAddress;
	private String supEmail_Id;
	private String supPhoneNum;
	
	public Supplier()
	{
		this.supId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	

	
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	

	public String getSupAddress() {
		return supAddress;
	}
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}
	public String getSupEmail_Id() {
		return supEmail_Id;
	}
	public void setSupEmail_Id(String supEmail_Id) {
		this.supEmail_Id = supEmail_Id;
	}
	public String getSupPhoneNum() {
		return supPhoneNum;
	}
	public void setSupPhoneNum(String supPhoneNum) {
		this.supPhoneNum = supPhoneNum;
	}
	
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	
	
}
