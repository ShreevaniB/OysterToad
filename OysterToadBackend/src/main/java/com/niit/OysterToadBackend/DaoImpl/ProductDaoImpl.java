package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.ProductDao;
import com.niit.OysterToadBackend.Model.Cart_Items;
import com.niit.OysterToadBackend.Model.Category;
import com.niit.OysterToadBackend.Model.Product;
import com.niit.OysterToadBackend.Model.Supplier;

@Repository("productDao")
@EnableTransactionManagement
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Override
	public boolean delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Override
	public Product getProduct(String proId) {
		String s="from Product where proId='"+proId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Product> lcat=(List<Product>)q.list();
		if(lcat==null||lcat.isEmpty())
		{
			System.out.println("Product list is not found");
			return null;
		}
		else
		{
			System.out.println("Product list1:");
			return lcat.get(0);
		}
	}

	@Override
	public List<Product> list() {
		List<Product> product=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return product;
	}

	@Override
	public Supplier getSupplier(String supId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(String catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart_Items getCart_Items(String cartItems_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
