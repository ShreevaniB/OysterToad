package com.niit.OysterToadFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OysterToadBackend.Dao.UserDao;
import com.niit.OysterToadBackend.Model.Cart;
import com.niit.OysterToadBackend.Model.Supplier;
import com.niit.OysterToadBackend.Model.User;

@Controller
public class UserController {

	
@Autowired
User user;
@Autowired
UserDao userDao;

@RequestMapping("/User")
public ModelAndView userform()
{ 	 
	List<User>users=userDao.list();
	ModelAndView obj=new ModelAndView ("Signup");
	obj.addObject("user",new User());
	obj.addObject("users",users);
	return obj;
}

@RequestMapping(value="/adduse", method=RequestMethod.POST)
public ModelAndView adduser(@ModelAttribute("user")User user)
{
	Cart c=new Cart();
	user.setCart(c);
	ModelAndView obj=new ModelAndView("redirect:/User");
	
	if(userDao.saveorupdate(user)==true)
	{
		obj.addObject("echo","User is added successfully");
	}
	else
	{
		obj.addObject("echo","User is not added successfully");
	}
	return obj;
	}

}

//	 if(lists==null)
//	 {
//		 supplierDao.delete(supplier);
//		 obj.addObject("msg","Supplier is deleted successfully");
//	 }
//	 else
//	 {
//		 for(Product p:lists)
//		 {
//			 ProductDao.delete(p);
//		 }
//		 supplierDao.delete(supplier);
//		 obj.addObject("msg","Supplier and Product is deleted successfully");
//		 supplierDao.delete(supplier);
//		 obj.addObject("msg","supplier"is deleted successfully");
//          }

