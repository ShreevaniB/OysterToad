package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.ProductDao;
import com.niit.OysterToadBackend.Model.Product;

public class ProductTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Product pro=(Product)ctx.getBean("product");
		ProductDao proDao=(ProductDao)ctx.getBean("productDao");
		
		pro.setProId("P111");
		pro.setProName("Edible Fishes");
		
		if(proDao.saveorupdate(pro)==true)
		{
			System.out.println("Product is saved");
		}
		else
		{
			System.out.println("Product is not saved");
		}
		
		pro.setProId("P112");
		pro.setProName("Non Edible Fishes");
		
		
		if(proDao.saveorupdate(pro)==true)
		{
			System.out.println("Product is saved");
		}
		else
		{
			System.out.println("Product is not saved");
		}
		
		pro=proDao.getProduct("P111");
		if(proDao.delete(pro)==true)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product is not deleted");
		}
		pro=proDao.getProduct("P112");
		if(pro==null)
		{
			System.out.println(pro.getProId());
			System.out.println(pro.getProName());
		}
		
		List<Product> prolist=proDao.list();
		for(Product p:prolist)
		{
			System.out.println(p.getProId());
			System.out.println(p.getProName());
		}
		
		
		
	}

}
