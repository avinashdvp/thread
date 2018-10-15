package com.avinash.dt12.productins;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface CartDao 
{
	public void saveCart(int quantity,int id,String un);
	public List getCartdetails(String un);
	public void deleteCart(String un);
	
}
