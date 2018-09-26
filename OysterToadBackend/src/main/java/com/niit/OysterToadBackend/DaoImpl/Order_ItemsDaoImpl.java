package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.Order_ItemsDao;
import com.niit.OysterToadBackend.Model.Order_Items;




@Repository("order_ItemsDao")
@EnableTransactionManagement
@Transactional
public class Order_ItemsDaoImpl implements Order_ItemsDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public Order_ItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Order_Items order_Items) {
		sessionFactory.getCurrentSession().saveOrUpdate(order_Items);
		return true;
	}

	@Override
	public boolean delete(Order_Items order_Items) {
		sessionFactory.getCurrentSession().delete(order_Items);
		return true;
	}

	@Override
	public Order_Items getOrder_Items(String OrderItems_Id) {
		String s="from Order_Items where OrderItems_Id='"+OrderItems_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Order_Items> lOrderItems= (List<Order_Items>)q.list();
		if(lOrderItems==null||lOrderItems.isEmpty())
		{
			System.out.println("Order_Items list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lOrderItems.get(0);
		}
	}

	@Override
	public List<Order_Items> list() {
		List<Order_Items> order_Items=(List<Order_Items>)sessionFactory.getCurrentSession().createCriteria(Order_Items.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return order_Items;
	}
	
	

}
