package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.AuthenticationDao;
import com.niit.OysterToadBackend.Model.Authentication;

public class AuthenticationTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();  
		
		Authentication authen=(Authentication)ctx.getBean("authentication");
		AuthenticationDao authenDao=(AuthenticationDao)ctx.getBean("authenticationDao");
		
		authen.setRole_id("R111");
		authen.setRole_Name("Edible Fishes");
		
		if(authenDao.saveorupdate(authen)==true)
		{
			System.out.println("Authentication is saved");
		}
		else
		{
			System.out.println("Authentication is not saved");
		}
		
		authen.setRole_id("R112");
		authen.setRole_Name("NonEdible fishes");
		
		if(authenDao.saveorupdate(authen)==true)
		{
			System.out.println("Authentication is saved");
		}
		else
		{
			System.out.println("Authentication is not saved");
		}
		
		authen.setRole_id("R113");
		authen.setRole_Name("NonEdible fishes");
		
		if(authenDao.saveorupdate(authen)==true)
		{
			System.out.println("Authentication is saved");
		}
		else
		{
			System.out.println("Authentication is not saved");
		}
		
	    authen=authenDao.getAuthentication("R111");
		if(authenDao.delete(authen)==true)
		{
			System.out.println("Authentication deleted");
		}
		else
		{
			System.out.println("Authentication not deleted");
		}
		
		authen=authenDao.getAuthentication("R112");
		if(authen==null)
		{
			System.out.println("Authentication not found");
		}
		else
		{
			System.out.println(authen.getRole_id());
			System.out.println(authen.getRole_Name());
		}
		
		List<Authentication> authenlist=authenDao.list();
		for(Authentication a:authenlist)
		{
			System.out.println(a.getRole_id());
			System.out.println(a.getRole_Name());
		}
	}

}

