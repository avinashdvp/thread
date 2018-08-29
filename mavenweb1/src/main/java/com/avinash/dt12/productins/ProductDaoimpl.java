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
import com.avinash.dt12.model.Product;
@Component
@Repository

public class ProductDaoimpl implements ProductDao {

	@Autowired
    SessionFactory sessionFactory;

	
	public boolean insert(Product pro) 
	{

		Session session=sessionFactory.openSession();
		
		session.saveOrUpdate(pro);
		Transaction t=session.beginTransaction();
		t.commit();
		 session.close();
		return false;
	}


	
	public List getAllProducts() {
		
		 Session session=sessionFactory.openSession();
	       //preparing query object
	       Query query=session.createQuery("from Product");
	       //executing query object
	       List productList=query.list();
	       session.close();
	       return productList;
		
	}


	public boolean deleteProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		 
	      session.delete(product);
	      Query query=session.createQuery("from Product");
	     Transaction t=session.beginTransaction();
			t.commit();
			 session.close();
		return false;
	}



	
	public Product editProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		return product;
	}
	
	public Product cart(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		 session.close();
		return product;
	}
	
	
	
}
