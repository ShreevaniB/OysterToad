package com.niit.OysterToadBackend.Model;


import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table
@Component
public class Product {

	@Id
	private String proId;
	private String proName;
	
	@Transient
	private MultipartFile pimg;
	
	public Product()
	{
		this.proId="PRO"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="catId")
	private Category category;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CartItems_Id")
	private Cart_Items cart_Items;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="supId")
	private Supplier supplier;

	
	public Cart_Items getCart_Items() {
		return cart_Items;
	}

	public void setCart_Items(Cart_Items cart_Items) {
		this.cart_Items = cart_Items;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory()
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category=category;
	}
	
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public int getProQuantity() {
		return proQuantity;
	}
	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}
	public String getProDescription() {
		return proDescription;
	}
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	private Double proPrice;
	private int proQuantity;
	private String proDescription;
//	private String imagename;

	public MultipartFile getPimg() {
		return pimg;
	}

	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}

//	public String getImagename() {
//		return imagename;
//	}
//
//	public void setImagename(String imagename) {
//		this.imagename = imagename;
//	}
	
	
	
}
