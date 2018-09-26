package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.BillingDao;
import com.niit.OysterToadBackend.Model.Billing;


public class BillingTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();  
		
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
		
		bill.setBillId("B111");
		bill.setBillname("Edible Fishes");
		
		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Billing is saved");
		}
		else
		{
			System.out.println("Billing is not saved");
		}
		
		bill.setBillId("B112");
		bill.setBillname("NonEdible fishes");
		
		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Billing is saved");
		}
		else
		{
			System.out.println("Billing is not saved");
		}
		
		bill.setBillId("B113");
		bill.setBillname("NonEdible fishes");
		
		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Billing is saved");
		}
		else
		{
			System.out.println("Billing is not saved");
		}
		
		bill=billDao.getBilling("B111");
		if(billDao.delete(bill)==true)
		{
			System.out.println("Billing deleted");
		}
		else
		{
			System.out.println("Billing not deleted");
		}
	}
}
		
		