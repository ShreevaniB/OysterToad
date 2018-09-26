package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.ShippingDao;
import com.niit.OysterToadBackend.Model.Shipping;



@Repository("shippingDao")
@EnableTransactionManagement
@Transactional
public class ShippingDaoImppl implements ShippingDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public  ShippingDaoImppl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Shipping shipping) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	@Override
	public boolean delete(Shipping shipping) {
		sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}

	@Override
	public  Shipping getShipping(String Ship_Id) {
		String s="from Shipping where ship_Id='"+ Ship_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> lShip= (List<Shipping>)q.list();
		if(lShip==null||lShip.isEmpty())
		{
			System.out.println("Shipping list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lShip.get(0);
		}
	}

	@Override
	public List<Shipping> list() {
		List<Shipping>  shipping=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return  shipping;
	}

	@Override
	public List<Shipping> getaddbyuser(String useId) {
		String s="from Shipping where useId='"+ useId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> lShip= (List<Shipping>)q.list();
		if(lShip==null||lShip.isEmpty())
		{
			System.out.println("Shipping list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lShip;
		}
	}
	
	

}
