package com.avinash.dt12.productins;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avinash.dt12.model.Register;
import com.avinash.dt12.model.User;

@Component
@Repository
public class LoginDaoimpl implements LoginDao
{
	@Autowired
    SessionFactory sessionFactory;
	@Autowired
	Register reg;
	
	public String logincheck(String email, String password)
	{
		
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("From Register where email=:em and password =:pwd");
		 query.setParameter("em",email).setParameter("pwd",password);
		reg=(Register)query.uniqueResult();
		
		 
		 if(reg==null)
		 {
			
		     return"fail";
		     
		 }
		 else
		 {
			 return "success";
		 }
	}

}
