package com.avinash.dt12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avinash.dt12.model.Product;

@Controller
public class BasicController 
{
@RequestMapping("/home")

public ModelAndView m1()
{
	Product p=new Product();
	p.setName("mobile");
	p.setPrice(100);
	ModelAndView mv1=new ModelAndView("index","v1",p);
	return mv1;
}

}
