package com.avinash.dt12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avinash.dt12.model.Category;
import com.avinash.dt12.model.Product;
import com.avinash.dt12.model.Supplier;
import com.avinash.dt12.productins.CategoryDao;
import com.avinash.dt12.productins.ProductDao;
import com.avinash.dt12.productins.SupplierDao;


	@Controller
	public class Controllers 
	{
	@Autowired
	ProductDao pdao;
	@Autowired
	CategoryDao cdao;
	@Autowired
	SupplierDao sdao;
	@RequestMapping("/Product")


	public ModelAndView m1()
	{
		ModelAndView mv1=new ModelAndView("showproducts","pro",new Product());
		return mv1;
	}
	@RequestMapping(value="/addProduct" , method=RequestMethod.POST )
    public ModelAndView saveProduct(@ModelAttribute("pro") Product pro)
    {
        pdao.insert(pro);
     List proList1 =pdao.getAllProducts();
    ModelAndView mv=new ModelAndView("showproducts","productInfo",proList1);
    return mv;
    }
	@RequestMapping("/Category")

	public ModelAndView m2()
	{
		ModelAndView mv2=new ModelAndView("showCategory","command",new Category());
		return mv2;
	}
	@RequestMapping("/addCategory")
	 public ModelAndView saveCategory(@ModelAttribute("cat") Category cat)
	    {
	        cdao.insert(cat);
	    ModelAndView mv=new ModelAndView("pro","categoryInfo",cat);
	    return mv;
	    }
	
	@RequestMapping("/Supplier")

	public ModelAndView m3()
	{
		ModelAndView mv3=new ModelAndView("showSupplier","command",new Supplier());
		return mv3;
	}
	@RequestMapping("/addSupplier")
	 public ModelAndView saveSupplier(@ModelAttribute("supply") Supplier supply)
	    {
		sdao.insert(supply);
	    ModelAndView mv=new ModelAndView("pro","supplierInfo",supply);
	    return mv;
	    }
	}

