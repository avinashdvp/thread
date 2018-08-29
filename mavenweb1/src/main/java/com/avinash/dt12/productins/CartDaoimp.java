package com.avinash.dt12.productins;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avinash.dt12.model.Cart;
import com.avinash.dt12.model.Product;

@Component
@Repository

public class CartDaoimp implements CartDao
{
	@Autowired
    SessionFactory sessionFactory;

public void getCart(int quantity,int id)
{
	Session session=sessionFactory.openSession();
	Product product=(Product)session.get(Product.class, id);
	Cart c=new Cart();
	c.setCategoryId((int)(Math.random()*10000));
	c.setProductPrice(product.getPrice());
	c.setTotalPrice(quantity*product.getPrice());
	c.setProductName(product.getName());
	c.setQuantity(quantity);
	session.save(c);
	Transaction t=session.beginTransaction();
	t.commit();
	
	
	
}
}
