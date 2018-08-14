package com.avinash.dt12.productins;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avinash.dt12.model.Product;

@Repository

public class ProductDaoimpl implements ProductDao {

	@Autowired
    SessionFactory sessionFactory;

	
	public boolean insert(Product pro) 
	{

		Session session=sessionFactory.openSession();
		session.save(pro);
		Transaction t=session.beginTransaction();
		t.commit();
		return false;
	}


	
	public List getAllProducts() {
		
		 Session session=sessionFactory.openSession();
	       //preparing query object
	       Query query=session.createQuery("from Product");
	       //executing query object
	       List productList=query.list();
	       
	       return productList;
		
	}
	
}
