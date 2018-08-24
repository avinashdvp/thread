package com.avinash.dt12.productins;

import java.util.List;

import org.hibernate.Query;
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
		supply.setSupplierId((int)(Math.random()*10000));
		session.save(supply);
		Transaction t=session.beginTransaction();
		t.commit();
		return false;
		
	}
	
	public List getallSuppliers()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List supplierList=query.list();
		return supplierList;
		
	}

	
	public boolean deleteSupplier(int supplierId)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		 
	      session.delete(supplier);
	      Query query=session.createQuery("from Supplier");
	     Transaction t=session.beginTransaction();
			t.commit();	
		return false;
	}
}
