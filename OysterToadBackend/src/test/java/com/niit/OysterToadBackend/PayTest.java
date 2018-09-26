package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.PayDao;
import com.niit.OysterToadBackend.Model.Pay;

public class PayTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Pay pay=(Pay)ctx.getBean("pay");
		PayDao payDao=(PayDao)ctx.getBean("payDao");
		
		pay.setPay_Id("P111");
		pay.setPay_Method("COD");
		if(payDao.saveorupdate(pay)==true)
		{
			System.out.println("Pay is saved");
		}
		else
		{
			System.out.println("Pay is not saved");
		}
		
		pay.setPay_Id("P112");
		pay.setPay_Method("Credit Card");
		
		if(payDao.saveorupdate(pay)==true)
		{
			System.out.println("Pay is saved");
		}
		else
		{
			System.out.println("Pay is not saved");
		}
		
		pay=payDao.getPay("P111");
		if(payDao.delete(pay)==true)
		{
			System.out.println(" deleted");
		}
		else
		{
			System.out.println("Pay not deleted");
		}
		pay=payDao.getPay("P112");
		if(pay==null)
		{
			System.out.println("Pay not found");
		}
		else
		{
			System.out.println(pay.getPay_Id());
			System.out.println(pay.getPay_Method());
		}
		List<Pay> paylist=payDao.list();
		for(Pay p:paylist)
		{
			System.out.println(p.getPay_Id());
			System.out.println(p.getPay_Method());
		}
	}

}
