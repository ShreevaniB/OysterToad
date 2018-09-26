package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.Cart_ItemsDao;
import com.niit.OysterToadBackend.Model.Cart_Items;



public class Cart_ItemsTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();  
		
		Cart_Items cartItems=(Cart_Items)ctx.getBean("cartItems");
		Cart_ItemsDao cartItemsDao=(Cart_ItemsDao)ctx.getBean("cartItemsDao");
		
		cartItems.setCartItems_Id("C111");
		cartItems.setPrice(78.08);
		
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println("Cart_Items is saved");
		}
		else
		{
			System.out.println("Cart_Items is not saved");
		}
		
		cartItems.setCartItems_Id("C112");
		cartItems.setPrice(48789.897);
		
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println("cartItems is saved");
		}
		else
		{
			System.out.println("cartItems is not saved");
		}
		
		cartItems.setCartItems_Id("C113");
		cartItems.setPrice(5667.765);
		
		if(cartItemsDao.saveorupdate(cartItems)==true)
		{
			System.out.println("cartItems is saved");
		}
		else
		{
			System.out.println("cartItems is not saved");
		}
		
		cartItems=cartItemsDao.getCart_Items("C111");
		if(cartItemsDao.delete(cartItems)==true)
		{
			System.out.println("cartItems deleted");
		}
		else
		{
			System.out.println("cartItems not deleted");
		}
	}
}
		
		