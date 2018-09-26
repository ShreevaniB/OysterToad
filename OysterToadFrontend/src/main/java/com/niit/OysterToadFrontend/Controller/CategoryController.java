package com.niit.OysterToadFrontend.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OysterToadBackend.Dao.CategoryDao;
import com.niit.OysterToadBackend.Model.Category;

@Controller
public class CategoryController {

@Autowired
Category category;
@Autowired
CategoryDao categoryDao;

@RequestMapping("/Category")
public ModelAndView categoryform()
{
	List<Category> categories=categoryDao.list();
ModelAndView obj=new ModelAndView("Category");
obj.addObject("category",new Category());
obj.addObject("categories",categories);
return obj;
}

@RequestMapping(value="/addcat",method=RequestMethod.POST)
public ModelAndView addcategory(@ModelAttribute("category")Category category)
{
	ModelAndView obj= new ModelAndView("redirect:/Category");
	if(categoryDao.saveorupdate(category)==true)
	{
		obj.addObject("echo","Category is added successfully");
	}
	else
	{
		obj.addObject("echo","Category is not added successfully");
	}
	return obj;

}

@RequestMapping("/editcategory/{catId}")
public ModelAndView editcategory(@PathVariable("catId")String catId)
{
	System.out.println(123);
	List<Category> categories=categoryDao.list();
	ModelAndView obj=new ModelAndView("Category");
	category=categoryDao.getCategory(catId);
	obj.addObject("category",category);
	obj.addObject("categories", categories);
	return obj;
}


 @RequestMapping("/deletecategory/{catId}")
 public ModelAndView deletecategory(@PathVariable("catId")String  catId)
 {
	 ModelAndView obj=new ModelAndView("redirect:/Category");
	 Category lists=categoryDao.getCategory(catId);
	 if(categoryDao.delete(lists)==true)
	 {
		 System.out.println("Category deleted successfully");
		 obj.addObject("msg","Category deleted successfully ");
	 }
	 else
	 {
		 obj.addObject("msg","Category not deleted successfully ");
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
//           }
	 
	
//		 }
	
 



