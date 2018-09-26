package com.niit.OysterToadBackend.Config;

	import java.util.Properties;

	import javax.sql.DataSource;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.hibernate5.HibernateTransactionManager;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
	import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.OysterToadBackend.Dao.AuthenticationDao;
import com.niit.OysterToadBackend.Dao.BillingDao;
import com.niit.OysterToadBackend.Dao.CartDao;
import com.niit.OysterToadBackend.Dao.Cart_ItemsDao;
import com.niit.OysterToadBackend.Dao.CategoryDao;
import com.niit.OysterToadBackend.Dao.OrderDao;
import com.niit.OysterToadBackend.Dao.Order_ItemsDao;
import com.niit.OysterToadBackend.Dao.PayDao;
import com.niit.OysterToadBackend.Dao.ProductDao;
import com.niit.OysterToadBackend.Dao.ShippingDao;
import com.niit.OysterToadBackend.Dao.SupplierDao;
import com.niit.OysterToadBackend.Dao.UserDao;
import com.niit.OysterToadBackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.BillingDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.CartDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.Cart_ItemsDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.CategoryDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.OrderDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.Order_ItemsDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.PayDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.ProductDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.ShippingDaoImppl;
import com.niit.OysterToadBackend.DaoImpl.SupplierDaoImpl;
import com.niit.OysterToadBackend.DaoImpl.UserDaoImpl;
import com.niit.OysterToadBackend.Model.Authentication;
import com.niit.OysterToadBackend.Model.Billing;
import com.niit.OysterToadBackend.Model.Cart;
import com.niit.OysterToadBackend.Model.Cart_Items;
import com.niit.OysterToadBackend.Model.Category;
import com.niit.OysterToadBackend.Model.Order;
import com.niit.OysterToadBackend.Model.Order_Items;
import com.niit.OysterToadBackend.Model.Pay;
import com.niit.OysterToadBackend.Model.Product;
import com.niit.OysterToadBackend.Model.Shipping;
import com.niit.OysterToadBackend.Model.Supplier;
import com.niit.OysterToadBackend.Model.User;



	@Configuration
	@ComponentScan("com.niit.*")
	@EnableTransactionManagement 
	public class ApplicationContext 
	{
		@Bean("dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/OysterToad1");
			dataSource.setUsername("shreevani");
			dataSource.setPassword("shreevani");
			return dataSource;
	}
		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.connection.pool_size", "10");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			return properties;
		}
		
		@Autowired
		@Bean("sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.addAnnotatedClass(Product.class);
			sessionBuilder.addAnnotatedClass(User.class);			
			sessionBuilder.addAnnotatedClass(Authentication.class);			
			sessionBuilder.addAnnotatedClass(Billing.class);			
			sessionBuilder.addAnnotatedClass(Cart_Items.class);			
			sessionBuilder.addAnnotatedClass(Cart.class);
			sessionBuilder.addAnnotatedClass(Order_Items.class);	
			sessionBuilder.addAnnotatedClass(Order.class);
			sessionBuilder.addAnnotatedClass(Pay.class);	
			sessionBuilder.addAnnotatedClass(Shipping.class);			
			return sessionBuilder.buildSessionFactory();
		}
		
		@Autowired
		@Bean("transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

		@Autowired
		@Bean("categoryDao")
		public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
			return new CategoryDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("supplierDao")
		public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("userDao")
		public UserDao getUserDao(SessionFactory sessionFactory) {
			return new UserDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("productDao")
		public ProductDao getProductDao(SessionFactory sessionFactory) {
			return new ProductDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("AuthenticationDao")
		public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
			return new AuthenticationDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("billingDao")
		public BillingDao getBillingDao(SessionFactory sessionFactory) {
			return new BillingDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("cart_ItemsDao")
		public Cart_ItemsDao getCart_ItemsDao(SessionFactory sessionFactory) {
			return new Cart_ItemsDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("cartDao")
		public CartDao getCartDao(SessionFactory sessionFactory) {
			return new CartDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("order_ItemsDao")
		public Order_ItemsDao getOrder_ItemsDao(SessionFactory sessionFactory) {
			return new Order_ItemsDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("orderDao")
		public OrderDao getOrderDao(SessionFactory sessionFactory) {
			return new OrderDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("payDao")
		public PayDao getPayDao(SessionFactory sessionFactory) {
			return new PayDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("shippingDao")
		public ShippingDao getShippingDao(SessionFactory sessionFactory) {
			return  new ShippingDaoImppl(sessionFactory);
		}

		

	}


