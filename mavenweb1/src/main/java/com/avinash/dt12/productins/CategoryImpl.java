package com.avinash.dt12.productins;

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
		session.save(cat);
		Transaction t=session.beginTransaction();
		t.commit();
		return false;
		
	}

}
