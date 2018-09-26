package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.SupplierDao;
import com.niit.OysterToadBackend.Model.Supplier;

public class SupplierTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Supplier sup=(Supplier)ctx.getBean("supplier");
		SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
		
		sup.setSupId("S111");
		sup.setSupName("Edible Fishes");
		
		if(supDao.saveorupdate(sup)==true)
		{
			System.out.println("Supplier is saved");
		}
		else
		{
			System.out.println("Supplier is not saved");
		}
		
		
		sup.setSupId("S112");
		sup.setSupName("Non Edible Fishes");
		
		if(supDao.saveorupdate(sup)==true)
		{
			System.out.println("Supplier is saved");
		}
		else
		{
		    System.out.println("Supplier is not saved");	
		}
		
		sup=supDao.getSupplier("S111");
		if(supDao.delete(sup)==false)
		{
			System.out.println("Supplier deleted");
		}
		else
		{
			System.out.println("Supplier not deleted");
		}
		
		sup=supDao.getSupplier("S112");
		if(sup==null)
		{
			System.out.println("Supplier not found");
		}
		else
		{
			System.out.println(sup.getSupId());
			System.out.println(sup.getSupName());
		}
		
		List<Supplier> suplist=supDao.list();
		for(Supplier s:suplist)
		{
			System.out.println(s.getSupId());
			System.out.println(s.getSupName());
		}
		
	}

}
