package com.avinash.dt12.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.avinash.dt12.model.Product;
import com.avinash.dt12.productins.CategoryImpl;
import com.avinash.dt12.productins.ProductDao;
import com.avinash.dt12.productins.SupplierDaoImpl;

@Controller
public class ProductController 
{
	@Autowired
	ProductDao pdao;
	@Autowired
	CategoryImpl categoryImpl;
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	
	@RequestMapping("/Product")
	public ModelAndView sendProducts()
	{
		List cl=categoryImpl.getAllCategory();
		List supplierList=supplierDaoImpl.getallSuppliers();
		ModelAndView mv1=new ModelAndView("showproducts","pro",new Product());
		 List proList1 =pdao.getAllProducts();
		 mv1.addObject("productInfo",proList1);
		 mv1.addObject("catinfo",cl);
		 mv1.addObject("supinfo",supplierList);
		return mv1;
	}
	@RequestMapping(value="/addProduct" , method=RequestMethod.POST )
    public ModelAndView saveProduct(@ModelAttribute("pro") Product pro) throws IOException 
    {
		MultipartFile proimg=pro.getProductimg();
		pro.setProductId((int)(Math.random()*10000));
		int proid=pro.getProductId();
		File f=new File("F:\\mavenweb1\\src\\main\\webapp\\resources\\"+String.valueOf(proid)+".jpg");
        pdao.insert(pro);
        FileOutputStream fos=new FileOutputStream(f);
        BufferedOutputStream bos= new  BufferedOutputStream(fos);
        bos.write(proimg.getBytes());
     List proList1 =pdao.getAllProducts();
    ModelAndView mv=new ModelAndView("showproducts","productInfo",proList1);
    return mv;
    }
	@RequestMapping("/deletePro")
	public ModelAndView deleteProduct(@RequestParam("proId")int proId)
	{
	pdao.deleteProduct(proId);
	List proList1 =pdao.getAllProducts();
    ModelAndView mv1=new ModelAndView("showproducts","pro",new Product());
	mv1.addObject("productInfo",proList1);
    return mv1;
	}
	@RequestMapping("/editPro")
	public ModelAndView editProduct(@RequestParam("proId")int proId)
	{
	Product pro=pdao.editProduct(proId);
	List proList1 =pdao.getAllProducts();
    ModelAndView mv1=new ModelAndView("showproducts","pro",pro);
	mv1.addObject(proList1);
    return mv1;
	}
	
}
