package com.niit.OysterToadBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OysterToadBackend.Dao.CategoryDao;
import com.niit.OysterToadBackend.Model.Category;

@Repository("categoryDao")
@EnableTransactionManagement
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	@Override
	public boolean delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	@Override
	public Category getCategory(String catId) {
		String s="from Category where catId='"+catId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Category> lcat= (List<Category>)q.list();
		if(lcat==null||lcat.isEmpty())
		{
			System.out.println("Category list is not found");
			return null;
		}
		else
		{
			System.out.println("Category list1:");
			return lcat.get(0);
		}
	}

	@Override
	public List<Category> list() {
		List<Category> category=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return category;
	}
	
	

}
