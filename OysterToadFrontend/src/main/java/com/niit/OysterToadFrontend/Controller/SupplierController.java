package com.niit.OysterToadFrontend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OysterToadBackend.Dao.SupplierDao;
import com.niit.OysterToadBackend.Model.Product;
import com.niit.OysterToadBackend.Model.Supplier;

@Controller
public class SupplierController {
	
@Autowired
Supplier supplier;
@Autowired
SupplierDao supplierDao;

@RequestMapping("/Supplier") 
public ModelAndView supplierform()
{
	List<Supplier> suppliers= supplierDao.list();
	ModelAndView obj= new ModelAndView("Supplier");
	obj.addObject("supplier", new Supplier());
	obj.addObject("suppliers",suppliers);
	return obj;
}

@RequestMapping(value="/addsup", method=RequestMethod.POST)
public ModelAndView addsupplier(@ModelAttribute("supplier")Supplier supplier)
{
	ModelAndView obj=new ModelAndView("redirect:/Supplier");
	if(supplierDao.saveorupdate(supplier)==true)
	{
		obj.addObject("echo","Supplier is added successfully");
	}
	else
	{
		obj.addObject("echo","Supplier is not added successfully");
	}
	return obj;

	}

@RequestMapping("/editsupplier/{supId}")
public ModelAndView editproduct(@PathVariable("supId")String supId)
{
	System.out.println(123);
	List<Supplier> suppliers=supplierDao.list();
	ModelAndView obj=new ModelAndView("Supplier");
	supplier=supplierDao.getSupplier(supId);
	obj.addObject("supplier",supplier);
	obj.addObject("suppliers",suppliers);
	return obj;
}


 @RequestMapping("/deletesupplier/{supId}")
 public ModelAndView deletesupplier(@PathVariable("supId")String  supId)
 {
	 ModelAndView obj=new ModelAndView("redirect:/Supplier");
	 Supplier lists=supplierDao.getSupplier(supId);
	 if(supplierDao.delete(lists)==true)
	 {
		 System.out.println("Supplier deleted successfully");
		 obj.addObject("msg","Supplier deleted successfully ");
	 }
	 else
	 {
		 obj.addObject("msg","Supplier not deleted successfully ");
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

