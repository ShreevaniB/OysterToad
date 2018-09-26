package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.OrderDao;
import com.niit.OysterToadBackend.Model.Order;

public class OrderTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Order order=(Order)ctx.getBean("order");
		OrderDao orderDao=(OrderDao)ctx.getBean("orderDao");
		
		order.setOrder_Id("O111");
		order.setOrder_date("1/1/2018");
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Order is saved");
		}
		else
		{
			System.out.println("Order is not saved");
		}
		
		order.setOrder_Id("O112");
		order.setOrder_date("2/2/2018");
		
		if(orderDao.saveorupdate(order)==true)
		{
			System.out.println("Order is saved");
		}
		else
		{
			System.out.println("Order is not saved");
		}
		
		order=orderDao.getOrder("O111");
		if(orderDao.delete(order)==true)
		{
			System.out.println(" deleted");
		}
		else
		{
			System.out.println("Order not deleted");
		}
		order=orderDao.getOrder("O112");
		if(order==null)
		{
			System.out.println("Order not found");
		}
		else
		{
			System.out.println(order.getOrder_Id());
			System.out.println(order.getOrder_date());
		}
		List<Order> orderlist=orderDao.list();
		for(Order o:orderlist)
		{
			System.out.println(o.getOrder_Id());
			System.out.println(o.getOrder_date());
		}
	}

}
