package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.AuthenticationDao;
import com.niit.OysterToadBackend.Model.Authentication;

@Repository("authenticationDao")
@EnableTransactionManagement
@Transactional
public class AuthenticationDaoImpl implements AuthenticationDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public AuthenticationDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Override
	public boolean delete(Authentication authentication) {
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String Role_Id) {
		String s="from Authentication where Role_Id='"+Role_Id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Authentication> lcat= (List<Authentication>)q.list();
		if(lcat==null||lcat.isEmpty())
		{
			System.out.println("Authentication list is not found");
			return null;
		}
		else
		{
			System.out.println(" list1:");
			return lcat.get(0);
		}
	}

	@Override
	public List<Authentication> list() {
		List<Authentication> authentication=(List<Authentication>)sessionFactory.getCurrentSession().createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authentication;
	}
	
	

}
