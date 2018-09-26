package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.ShippingDao;
import com.niit.OysterToadBackend.Model.Shipping;

public class ShippingTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
		
		ship.setShip_Id("S111");
		ship.setAddress("abc");
		if(shipDao.saveorupdate(ship)==true)
		{
			System.out.println("Shipping is saved");
		}
		else
		{
			System.out.println("Shipping is not saved");
		}
		
		ship.setShip_Id("S112");
		ship.setAddress("xyz");
		
		if(shipDao.saveorupdate(ship)==true)
		{
			System.out.println("Shipping is saved");
		}
		else
		{
			System.out.println("Shipping is not saved");
		}
		
		ship=shipDao.getShipping("S111");
		if(shipDao.delete(ship)==true)
		{
			System.out.println(" deleted");
		}
		else
		{
			System.out.println("Shipping not deleted");
		}
		ship=shipDao.getShipping("S112");
		if(ship==null)
		{
			System.out.println("Shipping not found");
		}
		else
		{
			System.out.println(ship.getShip_Id());
			System.out.println(ship.getAddress());
		}
		List<Shipping> shiplist=shipDao.list();
		for(Shipping s:shiplist)
		{
			System.out.println(s.getShip_Id());
			System.out.println(s.getAddress());
		}
	}

}
