package com.niit.OysterToadFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.OysterToadBackend.Dao.BillingDao;
import com.niit.OysterToadBackend.Dao.CartDao;
import com.niit.OysterToadBackend.Dao.Cart_ItemsDao;
import com.niit.OysterToadBackend.Dao.OrderDao;
import com.niit.OysterToadBackend.Dao.Order_ItemsDao;
import com.niit.OysterToadBackend.Dao.PayDao;
import com.niit.OysterToadBackend.Dao.ProductDao;
import com.niit.OysterToadBackend.Dao.ShippingDao;
import com.niit.OysterToadBackend.Dao.UserDao;
import com.niit.OysterToadBackend.Model.Billing;
import com.niit.OysterToadBackend.Model.Cart;
import com.niit.OysterToadBackend.Model.Cart_Items;
import com.niit.OysterToadBackend.Model.Order;
import com.niit.OysterToadBackend.Model.Order_Items;
import com.niit.OysterToadBackend.Model.Pay;
import com.niit.OysterToadBackend.Model.Product;
import com.niit.OysterToadBackend.Model.Shipping;
import com.niit.OysterToadBackend.Model.User;
import com.niit.OysterToadFrontend.OtpGenerator.Otpgenerator;


@Controller
public class OrderController {


	@Autowired
	Cart cart;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	Cart_Items cartItems;
	
	@Autowired
	Cart_ItemsDao cartItemsDao;
	
	@Autowired
	Billing billing;
	
	@Autowired
	BillingDao billingDao;
	
	@Autowired
	Shipping shipping;
	
	@Autowired
	ShippingDao shippingDao;
	
	@Autowired
	Pay pay;
	
	@Autowired
	PayDao payDao;
	
	@Autowired
	Order order;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	Order_Items orderItems;
	
	@Autowired
	Order_ItemsDao orderItemsDao
	;
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	List<Cart_Items> cartItems1;
	
	@Autowired
    private JavaMailSender mailSender;
	
	String o;
	
	
	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getEmail(currusername);
			cart = user.getCart();
			
			
//			session.setAttribute("products", product1);			
			cartItems1= cartItemsDao.getlist(cart.getCart_Id());
		
				
				billing = billingDao.get(user.getUseId());
				List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUseId());
				
				model.addAttribute("billing", billing);
				model.addAttribute("user", user);
				model.addAttribute("shippingAddresies", shippingAddresies);
				model.addAttribute("shippingAddress", new Shipping());
				session.setAttribute("p", product);
			}
			return "addressorder";
		} 
	
	

	@RequestMapping("/Buy/{p_id}/{ci_id}")
	public String order(@PathVariable("p_id") String id, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getEmail(currusername);
			cart = user.getCart();
			cartItems1=null;
			product = productDao.getProduct(id);
			billing = billingDao.get(user.getUseId());
			
			System.out.println(billing.getCity());
//			for(Billing b: billing)
//			{
//				System.out.println(b.getBillId());
//				System.out.println(b.getCountry());
//			}
			List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUseId());
			user.setBilling(billing);
			model.addAttribute("billing", billing);
			model.addAttribute("user", user);
			model.addAttribute("shippingAddresies", shippingAddresies);
			model.addAttribute("shippingAddress", new Shipping());
			session.setAttribute("p", product);
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shippingAddress") Shipping sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shipping = sh;
		shippingDao.saveorupdate(sh);
		model.addAttribute("billing", billing); 
		model.addAttribute("shippingAddress", shipping);
		model.addAttribute("prot", product);
		model.addAttribute("cartItems",cartItems1);
		model.addAttribute("cart",cart);
		return "orderconfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
		List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUseId());
		model.addAttribute("shippingAddresies", shippingAddresies);
		model.addAttribute("billing", billing);
		model.addAttribute("shippingAddress", shipping);
		model.addAttribute("product", product);
		
		return "addressorder";
	}
	
	@RequestMapping("/payment")
	public String payment(@RequestParam("payb2") String str, Model model) {
				
 		System.out.println(1324);
		int a;
		System.out.println(str);
		if(str.equals(o))
		{
			return "redirect:/orderconfirmation" ;	
		}
				
return "redirect:/orderconfirmation";
	}

	@RequestMapping("/orderconfirmation")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBilling(billing);
		order.setShipping(shipping);
		order.setPay(pay);
		order.setUser(user);
		System.out.println(524);
//		cartItems1= cartItemsDao.getlist(cart.getCart_Id());
		if (cartItems1 == null) 
		{
			order.setGrand_total(product.getProPrice());
			orderDao.saveorupdate(order);
			orderItems.setOrder(order);
			orderItems.setProduct_Id(product.getProId());
			orderItemsDao.saveorupdate(orderItems);
			cart.setGrand_total(cart.getGrand_total() - cartItems.getPrice());
			cart.setTotal_items(cart.getTotal_items() - 1);
			session.setAttribute("items", cart.getTotal_items());
			cartDao.saveorupdate(cart);
			cartItemsDao.deleteCt(cartItemsDao.getlistall(cart.getCart_Id(),product.getProId()).getCartItems_Id());
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setGrand_total(cart.getGrand_total());
			orderDao.saveorupdate(order);
			for(Cart_Items c:cartItems1)
			{
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setProduct_Id(c.getProduct().getProId());
				System.out.println(3443);
				orderItemsDao.saveorupdate(orderItems);
				session.setAttribute("cit", c);
				cartItemsDao.delete(c);
			}
			cart.setGrand_total(0.0);
			cart.setTotal_items(0);
			System.out.println(346);
			
			session.setAttribute("items", cart.getTotal_items());
			cartDao.saveorupdate(cart);
		}
//		cartItems=null;
//		cartItems1=null;
//		product=null;
		order=new Order();
		orderItems=new Order_Items();
		System.out.println(565);
		return "thankyou";
	}
	

@RequestMapping(value="/SendMail")
public void SendMail() {
	System.out.println(21312);
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
	String currusername = authentication.getName();
	user = userDao.getEmail(currusername);      
	Otpgenerator otp=new Otpgenerator();
	String o=otp.Otpga();
	o=otp.Otpga();
	String recipientAddress = user.getUseEmail_id();
	String subject="OTP";
//String subject = request.getParameter("subject");
String message = "your one time password is "+o+" ";

//prints debug info
System.out.println("To:" + recipientAddress);
System.out.println("Subject: " + subject);
System.out.println("Message: " + message);

    
System.out.println("OTP:"+ otp);
//creates a simple e-mail object
SimpleMailMessage email = new SimpleMailMessage();
email.setTo(recipientAddress);
email.setSubject(subject);
email.setText(message);
//email.setSubject(otp);
 //sends the e-mail
mailSender.send(email);

 
// forwards to the view named "Result"
//return "Result";
}
}
}


