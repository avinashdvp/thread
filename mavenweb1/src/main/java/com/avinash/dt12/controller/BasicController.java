package com.avinash.dt12.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avinash.dt12.model.Cart;
import com.avinash.dt12.model.Product;
import com.avinash.dt12.productins.CartDao;
import com.avinash.dt12.productins.ProductDao;

@Controller
public class BasicController 
{
	@Autowired
	ProductDao productDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	HttpSession session;
	
@RequestMapping("/home")

public ModelAndView m1()
{
	Product p=new Product();
	p.setName("mobile");
	p.setPrice(100);
	ModelAndView modelAndView=new ModelAndView("home");
	return modelAndView;
}
@RequestMapping("/user")
public ModelAndView user()
{   
	List prolist=productDao.getAllProducts();
ModelAndView modelAndView=new ModelAndView("user","productInfo",prolist);
return modelAndView;
	
}
@RequestMapping("/index")
public String admin()
{
	
	return "index";
}
@RequestMapping("/cartPro")
public ModelAndView editProduct(@RequestParam("proId")int proId)
{
Product pro=productDao.cart(proId);

ModelAndView modelAndView=new ModelAndView("productdetails","productInfo",pro);

return modelAndView;
}
@RequestMapping("/cart")
public ModelAndView cart(@RequestParam("quantity")int prot,@RequestParam("id")int id)
{
	String un= (String) session.getAttribute("username");
	cartDao.saveCart(prot,id,un);
Product pro=productDao.cart(id);
List prolist=productDao.getAllProducts();
ModelAndView modelAndView=new ModelAndView("user","productInfo",prolist);
return modelAndView;
}
@RequestMapping("/cartdetails")
public ModelAndView cartdetails()
{
	

String un= (String) session.getAttribute("username");
List cartList=cartDao.getCartdetails(un);
ModelAndView modelAndView =new ModelAndView("Cart","cartInfo",cartList);
return modelAndView;
}
@RequestMapping("/deletecart")
public ModelAndView deletecart()
{
String un= (String) session.getAttribute("username");
cartDao.deleteCart(un);
System.out.println("hello");
List cartList=cartDao.getCartdetails(un);
ModelAndView modelAndView =new ModelAndView("Cart","cartInfo",cartList);
return modelAndView;
}
}
