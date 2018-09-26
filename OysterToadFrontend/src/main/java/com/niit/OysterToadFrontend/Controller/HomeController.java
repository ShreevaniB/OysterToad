package com.niit.OysterToadFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.niit.OysterToadBackend.Dao.ProductDao;
import com.niit.OysterToadBackend.Model.Product;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String home()
    {
		return "vid";
    }
	
//	@RequestMapping("/Category")
//	public String category()
//	{
//		return "Category";
//	}
//	
//	@RequestMapping("/Supplier")
//	public String supplier()
//	{
//		return "Supplier";
//	}
	
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;

	
	
	@RequestMapping("/Products")
	public ModelAndView productform()
	{
		List<Product> products =productDao.list();
	ModelAndView obj=new ModelAndView("Products");
	
	obj.addObject("products",products);
	return obj;
	}
	
		
	@RequestMapping("/Login")
	public String login()
	{
		return "Login";
	}
	
	@RequestMapping("/Signup")
	public String signup()
	{
		return "Signup";
	}


	@RequestMapping("/Payment")
	public String payment()
	{
		return "Payment";
	}	
	
	@RequestMapping("/Header")
	public String header()
	{
		return "Header";
		
	}
	
	@RequestMapping("/Aboutus")
	public String about()
	{
		return "Aboutus";
		
	}
	
	@RequestMapping("/Contact")
	public String contact()
	{
		return "Contact";
		
	}
}
