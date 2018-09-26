 package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.CategoryDao;
import com.niit.OysterToadBackend.Model.Category;

public class CategoryTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();  
		
		Category cat=(Category)ctx.getBean("category");
		CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
		
		cat.setCatId("C111");
		cat.setCatName("Edible Fishes");
		
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category is not saved");
		}
		
		cat.setCatId("C112");
		cat.setCatName("NonEdible fishes");
		
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category is not saved");
		}
		
		cat.setCatId("C113");
		cat.setCatName("NonEdible fishes");
		
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category is not saved");
		}
		
		cat=catDao.getCategory("C111");
		if(catDao.delete(cat)==true)
		{
			System.out.println("Category deleted");
		}
		else
		{
			System.out.println("Category not deleted");
		}
		
		cat=catDao.getCategory("C112");
		if(cat==null)
		{
			System.out.println("Category not found");
		}
		else
		{
			System.out.println(cat.getCatId());
			System.out.println(cat.getCatName());
		}
		
		List<Category> catlist=catDao.list();
		for(Category c:catlist)
		{
			System.out.println(c.getCatId());
			System.out.println(c.getCatName());
		}
	}

}
