package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.CartDao;
import com.niit.OysterToadBackend.Model.Cart;

public class CartTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartDao=(CartDao)ctx.getBean("cartDao");
		
		cart.setCart_Id("C111");
		cart.setTotal_items(2);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Cart is saved");
		}
		else
		{
			System.out.println("Cart is not saved");
		}
		
		cart.setCart_Id("C112");
		cart.setTotal_items(4);
		
		if(cartDao.saveorupdate(cart)==true)
		{
			System.out.println("Cart is saved");
		}
		else
		{
			System.out.println("Cart is not saved");
		}
		
		cart=cartDao.getCart("C111");
		if(cartDao.delete(cart)==true)
		{
			System.out.println(" deleted");
		}
		else
		{
			System.out.println("Cart not deleted");
		}
		cart=cartDao.getCart("C112");
		if(cart==null)
		{
			System.out.println("Cart not found");
		}
		else
		{
			System.out.println(cart.getCart_Id());
			System.out.println(cart.getTotal_items());
		}
		List<Cart> cartlist=cartDao.list();
		for(Cart c:cartlist)
		{
			System.out.println(c.getCart_Id());
			System.out.println(c.getTotal_items());
		}
	}

}
