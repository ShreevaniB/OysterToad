package com.niit.OysterToadBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OysterToadBackend.Dao.UserDao;
import com.niit.OysterToadBackend.Model.User;

public class UserTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		User use=(User)ctx.getBean("user");
		UserDao useDao=(UserDao)ctx.getBean("userDao");
		
		use.setUseId("U111");
		use.setUseName("Edible Fishes");
		
		if(useDao.saveorupdate(use)==true)
		{
			System.out.println("User is saved");
		}
		else
		{
			System.out.println("User is not saved");
		}
		
		use.setUseId("U112");
		use.setUseName("Edible Fishes");
		
		if(useDao.saveorupdate(use)==true)
		{
			System.out.println("User is saved");
		}
		else
		{
			System.out.println("User is not saved");
		}
		
		use=useDao.getUser("U111");
		if(useDao.delete(use)==true)
		{
			System.out.println("User deleted");
		}
		else
		{
			System.out.println("user not deleted");
		}
		use=useDao.getUser("C112");
		if(use==null)
		{
			System.out.println("User not found");
		}
		else
		{
			System.out.println(use.getUseId());
			System.out.println(use.getUseName());
		}
		List<User> uselist=useDao.list();
		for(User u:uselist)
		{
			System.out.println(u.getUseId());
			System.out.println(u.getUseName());
		}
	}

}
