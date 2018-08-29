package com.avinash.dt12.productins;

import javax.servlet.Registration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avinash.dt12.model.Register;
import com.avinash.dt12.model.User;

@Component
@Repository
public class RegistrationDaoimpl implements RegistrationDao
{
	@Autowired
    SessionFactory sessionFactory;
	@Autowired
	Register reg;
	public boolean insertRegistration(Register reg) 
	{
		reg.setUserId((int)(Math.random()*10000));
Session session=sessionFactory.openSession();
User us=new User();
us.setEmail(reg.getEmail());
us.setPassword(reg.getPassword());
session.saveOrUpdate(us);

          session.saveOrUpdate(reg);
		Transaction t=session.beginTransaction();
		t.commit();
		 session.close();
		return false;
	}

}
