package com.avinash.dt12.productins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.avinash.dt12.model.Supplier;

@Component
@Repository
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
    SessionFactory sessionFactory;
	
	public boolean insert(Supplier supply) 
	{
		Session session=sessionFactory.openSession();
		session.save(supply);
		Transaction t=session.beginTransaction();
		t.commit();
		return false;
		
	}
	
}
