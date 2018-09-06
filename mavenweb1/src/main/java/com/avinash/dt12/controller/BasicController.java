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
	ProductDao pdao;
	@Autowired
	CartDao cdao;
	@Autowired
	HttpSession session;
	
@RequestMapping("/home")

public ModelAndView m1()
{
	Product p=new Product();
	p.setName("mobile");
	p.setPrice(100);
	ModelAndView mv1=new ModelAndView("home");
	return mv1;
}
@RequestMapping("/user")
public ModelAndView user()
{   
	List prolist=pdao.getAllProducts();
ModelAndView mv1=new ModelAndView("user","productInfo",prolist);
return mv1;
	
}
@RequestMapping("/index")
public String admin()
{
	
	return "index";
}
@RequestMapping("/cartPro")
public ModelAndView editProduct(@RequestParam("proId")int proId)
{
Product pro=pdao.cart(proId);

ModelAndView mv1=new ModelAndView("productdetails","productInfo",pro);

return mv1;
}
@RequestMapping("/cart")
public ModelAndView cart(@RequestParam("quantity")int prot,@RequestParam("id")int id)
{
	String un= (String) session.getAttribute("username");
cdao.saveCart(prot,id,un);
Product pro=pdao.cart(id);
List prolist=pdao.getAllProducts();
ModelAndView mv1=new ModelAndView("user","productInfo",prolist);
return mv1;
}
@RequestMapping("/cartdetails")
public ModelAndView cartdetails()
{
	

String un= (String) session.getAttribute("username");
List cartList=cdao.getCartdetails(un);
ModelAndView mv1=new ModelAndView("Cart","cartInfo",cartList);
return mv1;
}

}
