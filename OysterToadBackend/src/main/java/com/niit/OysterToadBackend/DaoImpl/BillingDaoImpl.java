package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.BillingDao;
import com.niit.OysterToadBackend.Model.Billing;

@Repository("billingDao")
@EnableTransactionManagement
@Transactional
public class BillingDaoImpl implements BillingDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public BillingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Billing billing) {
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	@Override
	public boolean delete(Billing billing) {
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	}

	@Override
	public Billing getBilling(String billId) {
		String s="from Billing where billId='"+billId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Billing> lbill= (List<Billing>)q.list();
		if(lbill==null||lbill.isEmpty())
		{
			System.out.println("Billing list is not found");
			return null;
		}
		else
		{
			System.out.println("Billing list1:");
			return lbill.get(0);
		}
	}

	@Override
	public List<Billing> list() {
		List<Billing> billing=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return billing;
	}

	@Override
	public Billing get(String useId) {
		String s="from Billing where useId='"+useId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Billing> lbill= (List<Billing>)q.list();
		if(lbill==null||lbill.isEmpty())
		{
			System.out.println("Billing list is not found");
			return null;
		}
		else
		{
			System.out.println("Billing list1:");
			return lbill.get(0);
		}
	}
}
	
	


