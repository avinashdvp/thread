package com.avinash.dt12.productins;

import java.util.List;

import javax.servlet.http.HttpSession;

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

public void saveCart(int quantity,int id,String un)
{
	Session session=sessionFactory.openSession();
	Product product=(Product)session.get(Product.class, id);
	Cart c=new Cart();
	 c.setCartUser(un);
	c.setCategoryId((int)(Math.random()*10000));
	c.setProductPrice(product.getPrice());
	c.setTotalPrice(quantity*product.getPrice());
	c.setProductName(product.getName());
	c.setQuantity(quantity);
	session.save(c);
	Transaction t=session.beginTransaction();
	t.commit();
	 
	 
}
public List getCartdetails(String un)
{
	Session sess=sessionFactory.openSession();
	
	Session session=sessionFactory.openSession();
	Query query = session.createQuery("From Cart where  cartUser=:un");
	 query.setParameter("un",un);
	 List cartList=query.list();
	 return cartList;
}
public void deleteCart(String un) 
{
	System.out.println(un);
	Session session=sessionFactory.openSession();
	Query query = session.createQuery("delete Cart where cartuser=:un");
    query.setParameter("un", un);
    query.executeUpdate();
    org.hibernate.Transaction t=session.beginTransaction();
    t.commit();
    session.close();
    
	
}

}
