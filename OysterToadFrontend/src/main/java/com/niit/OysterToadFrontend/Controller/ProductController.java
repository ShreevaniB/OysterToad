package com.niit.OysterToadFrontend.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OysterToadBackend.Dao.CategoryDao;
import com.niit.OysterToadBackend.Dao.ProductDao;
import com.niit.OysterToadBackend.Dao.SupplierDao;
import com.niit.OysterToadBackend.Model.Category;
import com.niit.OysterToadBackend.Model.Product;
import com.niit.OysterToadBackend.Model.Supplier;
import com.niit.OysterToadFrontend.FileInput.FileInput;

@Controller
public class ProductController {

@Autowired
Product product;
@Autowired
ProductDao productDao;

@Autowired
Category category;
@Autowired
CategoryDao categoryDao;

@Autowired
Supplier supplier;
@Autowired
SupplierDao supplierDao;


String path="C:\\Users\\admin\\eclipse-workspace\\OysterToadFrontend\\src\\main\\webapp\\resourses\\images\\";
@RequestMapping("/Product")
public ModelAndView productform()
{
	List<Category> categories=categoryDao.list();
	List<Supplier> suppliers=supplierDao.list();
	List<Product> products=productDao.list();
	ModelAndView obj=new ModelAndView("Product");
	obj.addObject("product", new Product());
	obj.addObject("products", products);
	obj.addObject("categories", categories);
	obj.addObject("suppliers", suppliers);
	return obj;
}


@RequestMapping(value="/addproduct",method=RequestMethod.POST)
public ModelAndView addproduct(@ModelAttribute("product")Product product)
{
	ModelAndView obj=new ModelAndView("redirect:/Product");
	
//	String filepath=req.getSession().getServletContext().getRealPath("/");
//	String filename=file.getOriginalFilename();
//	product.setImagename(filename);
  FileInput.upload(path,product.getPimg(),product.getProId()+".jpg");
	if(productDao.saveorupdate(product))
{
	obj.addObject("msg","product is added successfully");
}
	else
{
	obj.addObject("msg","Sorry! Product is not added");
}
//try
//{
//	byte[] imagebyte=file.getBytes();
//	BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
//	fos.write(imagebyte);
//	fos.close();
//}
//catch(Exception e)
//{
//}
  return obj;
  }


@RequestMapping("/editproduct/{proId}")
public ModelAndView editproduct(@PathVariable("proId")String proId)
{
	System.out.println(123);
	List<Product> products=productDao.list();
	List<Category> categories=categoryDao.list();
	List<Supplier> suppliers=supplierDao.list();
	ModelAndView obj=new ModelAndView("Product");
	product=productDao.getProduct(proId);
	obj.addObject("product",product);
	obj.addObject("products", products);
	obj.addObject("categories", categories);
	obj.addObject("suppliers", suppliers);
	return obj;
}


 @RequestMapping("/deleteproduct/{proId}")
 public ModelAndView deleteproduct(@PathVariable("proId")String  proId)
 {
	 ModelAndView obj=new ModelAndView("redirect:/Product");
	 Product lists=productDao.getProduct(proId);
	 if(productDao.delete(lists)==true)
	 {
		 System.out.println("Product deleted successfully");
		 obj.addObject("msg","Product deleted successfully ");
	 }
	 else
	 {
		 obj.addObject("msg","Product not deleted successfully ");
	 }
	 return obj;
 }
		 
	

}
