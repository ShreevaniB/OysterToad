package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.Order_ItemsDao;
import com.niit.OysterToadBackend.Model.Order_Items;

public class Order_ItemsTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Order_Items order=(Order_Items)ctx.getBean("order_Items");
		Order_ItemsDao orderDao=(Order_ItemsDao)ctx.getBean("order_ItemsDao");
		
		order.setOrderItems_Id("O111");
		order.setProduct_Id("123");
		
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Order_Items is saved");
		}
		else
		{
			System.out.println("Order_Items is not saved");
		}
		
		order.setOrderItems_Id("O112");
		order.setProduct_Id("456");
		
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Order_Items is saved");
		}
		else
		{
			System.out.println("Order_Items is not saved");
		}
		
		order=orderDao.getOrder_Items("O111");
		if(orderDao.delete(order)==true)
		{
			System.out.println(" deleted");
		}
		else
		{
			System.out.println("Order_Items not deleted");
		}
		order=orderDao.getOrder_Items("O112");
		if(order==null)
		{
			System.out.println("Order_Items not found");
		}
		else
		{
			System.out.println(order.getOrderItems_Id());
			System.out.println(order.getProduct_Id());
		}
		List<Order_Items> order_Itemslist=orderDao.list();
		for(Order_Items o:order_Itemslist)
		{
			System.out.println(o.getOrderItems_Id());
			System.out.println(o.getProduct_Id());
		}
	}

}
