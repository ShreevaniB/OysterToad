package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.PayDao;
import com.niit.OysterToadBackend.Model.Pay;



@Repository("payDao")
@EnableTransactionManagement
@Transactional
public class PayDaoImpl implements PayDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public  PayDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate( Pay  pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}

	@Override
	public boolean delete( Pay  pay) {
		sessionFactory.getCurrentSession().delete( pay);
		return true;
	}

	@Override
	public  Pay getPay(String Pay_Id) {
		String s="from pay where Pay_Id='"+ Pay_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Pay> lPay= (List<Pay>)q.list();
		if(lPay==null||lPay.isEmpty())
		{
			System.out.println(" Pay list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lPay.get(0);
		}
	}

	@Override
	public List<Pay> list() {
		List<Pay>  pay=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return  pay;
	}
	
	

}
