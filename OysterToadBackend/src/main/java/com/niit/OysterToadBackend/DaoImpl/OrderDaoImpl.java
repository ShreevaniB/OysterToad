package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.OrderDao;
import com.niit.OysterToadBackend.Model.Order;


@Repository("orderDao")
@EnableTransactionManagement
@Transactional
public class OrderDaoImpl implements OrderDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Override
	public boolean delete(Order order) {
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	@Override
	public Order getOrder(String Order_Id) {
		String s="from Order where Order_Id='"+Order_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Order> lOrder= (List<Order>)q.list();
		if(lOrder==null||lOrder.isEmpty())
		{
			System.out.println("Order list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lOrder.get(0);
		}
	}

	@Override
	public List<Order> list() {
		List<Order> order=(List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return order;
	}
	
	

}
