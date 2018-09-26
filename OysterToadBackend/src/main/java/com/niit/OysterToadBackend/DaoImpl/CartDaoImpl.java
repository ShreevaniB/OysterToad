package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.CartDao;
import com.niit.OysterToadBackend.Model.Cart;


@Repository("cartDao")
@EnableTransactionManagement
@Transactional
public class CartDaoImpl implements CartDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Override
	public boolean delete(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Override
	public Cart getCart(String Cart_Id) {
		String s="from Cart where Cart_Id='"+Cart_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Cart> lCart= (List<Cart>)q.list();
		if(lCart==null||lCart.isEmpty())
		{
			System.out.println("Cart list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lCart.get(0);
		}
	}

	@Override
	public List<Cart> list() {
		List<Cart> cart=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cart;
	}
	
	

}
