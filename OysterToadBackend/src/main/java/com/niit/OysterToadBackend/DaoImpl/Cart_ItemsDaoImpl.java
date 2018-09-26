package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.Cart_ItemsDao;
import com.niit.OysterToadBackend.Model.Cart;
import com.niit.OysterToadBackend.Model.Cart_Items;

@Repository("cart_ItemsDao")
@EnableTransactionManagement
@Transactional
public class Cart_ItemsDaoImpl implements Cart_ItemsDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public Cart_ItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Cart_Items cart_Items) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart_Items);
		return true;
	}

	@Override
	public boolean delete(Cart_Items cart_Items) {
		sessionFactory.getCurrentSession().delete(cart_Items);
		return true;
	}

	@Override
	public Cart_Items getCart_Items(String CartItems_Id) {
		String s="From Cart_Items where CartItems_Id='"+CartItems_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Cart_Items> lCartItems= (List<Cart_Items>)q.list();
		if(lCartItems==null||lCartItems.isEmpty())
		{
			System.out.println("Cart_Items list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lCartItems.get(0);
		}
	}

	@Override
	public List<Cart_Items> list() {
		List<Cart_Items> cart_Items=(List<Cart_Items>)sessionFactory.getCurrentSession().createCriteria(Cart_Items.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cart_Items;
	}

	@Override
	public List<Cart_Items> getlist(String cart_Id) {
		String s="From Cart_Items where Cart_Id='"+cart_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Cart_Items> lCartItems= (List<Cart_Items>)q.list();
		if(lCartItems==null||lCartItems.isEmpty())
		{
			System.out.println("Cart_Items list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lCartItems;
		}
	}

	@Override
	public Cart_Items getlistall(String ctId, String proId) {
		String s="From Cart_Items where Cart_Id='"+ctId+"' and proId ='"+proId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Cart_Items> lCartItems= (List<Cart_Items>)q.list();
		if(lCartItems==null||lCartItems.isEmpty())
		{
			System.out.println("Cart_Items list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lCartItems.get(0);
		}
	}

	@Override
	public List<Cart_Items> getlistbyproId(String proId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart_Items get(String cart_Id) {
		String s="From Cart_Items where Cart_Id='"+cart_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Cart_Items> lCartItems= (List<Cart_Items>)q.list();
		if(lCartItems==null||lCartItems.isEmpty())
		{
			System.out.println("Cart_Items list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lCartItems.get(0);
		}
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Cart_Items get(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean deleteCt(String cartItems_Id) {
		Cart_Items c= new Cart_Items();
		c.setCartItems_Id(cartItems_Id);
		sessionFactory.getCurrentSession().delete(c);
		return true;
	}
	
	

}
