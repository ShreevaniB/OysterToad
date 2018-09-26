package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.UserDao;
import com.niit.OysterToadBackend.Model.Authentication;
import com.niit.OysterToadBackend.Model.Billing;
import com.niit.OysterToadBackend.Model.User;


@Repository("userDao")
@EnableTransactionManagement
@Transactional

public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveorupdate(User u) {
		
		Authentication auth=new Authentication();
		auth.setUser_Name(u.getUseEmail_id());
		Billing bill=new Billing();
		bill.setAddress(u.getUseAddress());
		bill.setPhoneNum(u.getUsePhone_num());
		bill.setBillname(u.getUseName());
		bill.setCity(u.getUseCity());
		u.setBilling(bill);
		bill.setUser(u);
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
		sessionFactory.getCurrentSession().saveOrUpdate(u.getCart());
		sessionFactory.getCurrentSession().saveOrUpdate(u.getBilling());
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().saveOrUpdate(u);
		
		return true;
	}
	
	public boolean delete(User u) {
		sessionFactory.getCurrentSession().delete(u);;
		return true;
	}
	
	public User getUser(String uId) {
		String u1="from User where uId='"+uId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(u1);
		List<User> list=(List<User>) q1.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	public List<User> list() {
		List<User> user=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return user;
	}
	
	public User isValid(String email, String pwd) {
		String u1="from User where useEmail_id='"+email+"'and usePassword='"+pwd+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(u1);
		List<User> list=(List<User>) q1.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public User getEmail(String currusername) {
		String u1="from User where useEmail_id='"+currusername+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(u1);
		List<User> list=(List<User>) q1.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
}
