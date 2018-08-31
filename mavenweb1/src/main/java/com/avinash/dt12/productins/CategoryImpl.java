package com.avinash.dt12.productins;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avinash.dt12.model.Category;

@Component
@Repository

public class CategoryImpl implements CategoryDao
{

	@Autowired
    SessionFactory sessionFactory;
	public boolean insert(Category cat) 
	{
		Session session=sessionFactory.openSession();
		cat.setCategoryId((int)(Math.random()*10000));
		session.save(cat);
		Transaction t=session.beginTransaction();
		t.commit();
		return false;
		
	}
	public List getAllCategory() {
		
		 Session session=sessionFactory.openSession();
	       //preparing query object
	       Query query=session.createQuery("from Category");
	       //executing query object
	       List categoryList=query.list();
	       
	       return categoryList;
		
	}
	
	public boolean deleteCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		 Category category=(Category)session.get(Category.class,categoryId);
		 
	      session.delete(category);
	      Query query=session.createQuery("from Category");
	     Transaction t=session.beginTransaction();
			t.commit();
	     return false;
	}
	
}
