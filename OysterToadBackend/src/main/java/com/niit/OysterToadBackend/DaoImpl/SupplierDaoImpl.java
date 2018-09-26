package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.niit.OysterToadBackend.Dao.SupplierDao;
import com.niit.OysterToadBackend.Model.Supplier;

@Repository("supplierDao")
@EnableTransactionManagement
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	
	@Autowired 
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean saveorupdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Override
	public boolean delete(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Override
	public Supplier getSupplier(String supId) {
		String s="from Supplier where supId='"+supId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Supplier> lcat=(List<Supplier>)q.list();
		if(lcat==null||lcat.isEmpty())
		{
			System.out.println("Category list is not found");
		return null;
		}
		else
		{
			System.out.println("Supplier list1:");
			return lcat.get(0);
		}
	}

	@Override
	public List<Supplier> list() {
		List<Supplier> supplier=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplier;
	}

}
