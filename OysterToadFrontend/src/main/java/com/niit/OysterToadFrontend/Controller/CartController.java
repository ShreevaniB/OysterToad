package com.niit.OysterToadFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.OysterToadBackend.Dao.CartDao;
import com.niit.OysterToadBackend.Dao.Cart_ItemsDao;
import com.niit.OysterToadBackend.Dao.CategoryDao;
import com.niit.OysterToadBackend.Dao.ProductDao;
import com.niit.OysterToadBackend.Dao.UserDao;
import com.niit.OysterToadBackend.Model.Cart;
import com.niit.OysterToadBackend.Model.Cart_Items;
import com.niit.OysterToadBackend.Model.Category;
import com.niit.OysterToadBackend.Model.Product;
import com.niit.OysterToadBackend.Model.User;

@Controller
public class CartController {

	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	Cart cart;
	
	@Autowired
	Cart_Items cartItems;
	
	@Autowired
	Cart_ItemsDao cartItemsDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/addtocart/{proId}")
	public ModelAndView cart(@PathVariable("proId") String id,HttpSession session) 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
	User u = userDao.getEmail(currusername);
	if (user == null)
	{
		return new ModelAndView("redirect:/");
	} 
	else
	{
		cart = u.getCart();
		Product product = productDao.getProduct(id);
		Cart_Items cartItem = new Cart_Items();
		cartItem.setCart(cart);
		cartItem.setPrice(product.getProPrice());
		cartItem.setProduct(product);
		
		cartItemsDao.saveorupdate(cartItem);
		cart.setGrand_total(cart.getGrand_total() + product.getProPrice());
		cart.setTotal_items(cart.getTotal_items() + 1);
		cartDao.saveorupdate(cart);
		session.setAttribute("items", cart.getTotal_items());
		session.setAttribute("gd", cart.getGrand_total());
		return new ModelAndView("redirect:/");
		}
		}
		else {
			return new ModelAndView("redirect:/");
		}
	}
		
		
	
		
	
	           @RequestMapping(value="/checkout")
	           public String viewcart(Model model,HttpSession session)
	           {
	        	   Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	        	   if(!(authentication instanceof AnonymousAuthenticationToken))
                     {
                    	 String currusername=authentication.getName();
                    	 User user=userDao.getEmail(currusername);
                    	 Cart cart=user.getCart();
                    	 List<Cart_Items> cartItem=cartItemsDao.getlist(user.getCart().getCart_Id());
                    	 if(cartItem==null||cartItem.isEmpty())
                    	 {
                    		 System.out.println(67567);
                    		 session.setAttribute("items",0);
                    		 model.addAttribute("gtotal",0.0);
                    		 model.addAttribute("msg", "no items is added to cart");
                    		 return "Cart";
                    	 }
                    	 System.out.println(54354);
                    	 model.addAttribute("cartItem", cartItem);
            			 model.addAttribute("grandtotal", cart.getGrand_total());
            			 session.setAttribute("items", cart.getTotal_items());
            			 session.setAttribute("cartid", cart.getCart_Id());
            			 List<Category> categories=categoryDao.list();
            			 model.addAttribute("lcat", categories);
            			 return "Cart";
                     }
                    	 else
                    	 {
                    	 return "redirect:/checkout";
                     }
	           }
                     @RequestMapping(value="/Remove/{CartItems_Id}")
                     public ModelAndView RemoveFromCart(@PathVariable("CartItems_Id")String id)
                     {
                    	 ModelAndView mv=new ModelAndView("redirect:/checkout");
                    	 cartItems= cartItemsDao.getCart_Items(id);
                    	 cart=cartItems.getCart();
                    	 cart.setGrand_total(cart.getGrand_total()-cartItems.getPrice());
                    	 cart.setTotal_items(cart.getTotal_items()-1);
                    	 cartDao.saveorupdate(cart);
                    	 cartItemsDao.delete(cartItems);
                    	 return mv;
                     }
                     
                     
                     @RequestMapping(value="/RemoveAll")
                     public String RemoveAllFromCart(Model model, HttpSession session)
                     {
                    	 Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
                    	 if(!(authentication instanceof AnonymousAuthenticationToken))
                    	 {
                    		 String currusername=authentication.getName();
                        	 User u=userDao.getEmail(currusername);
                        	 Cart c=cartDao.getCart(u.getCart().getCart_Id());
                        	 List<Cart_Items> cartItem=cartItemsDao.getlist(u.getCart().getCart_Id()); 
                        	 for(Cart_Items c1:cartItem)
                        	 {
                        		 cartItemsDao.getCart_Items(c1.getCartItems_Id());
                        	 }
                        	 c.setGrand_total(0.0);
                        	 c.setTotal_items(0);
                        	 cartDao.saveorupdate(c);
                        	 session.setAttribute("items",c.getTotal_items());
                        	 return "redirect:/checkout";                    	 
                     }
                     
                     else
                     {
                    	 return ("redirect:/");
                     }
                     }
	}
	

