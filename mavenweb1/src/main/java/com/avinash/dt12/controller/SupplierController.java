package com.avinash.dt12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avinash.dt12.model.Supplier;
import com.avinash.dt12.productins.SupplierDao;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDao sdao;
	@RequestMapping("/Supplier")

	public ModelAndView m3()
	{
		ModelAndView mv3=new ModelAndView("showSupplier","supply",new Supplier());
		List supplyList=sdao.getallSuppliers();
		mv3.addObject("supplierInfo",supplyList);
		return mv3;
	}
	@RequestMapping(value="/addSupplier" , method=RequestMethod.POST)
	 public ModelAndView saveSupplier(@ModelAttribute("supply") Supplier supply)
	    {
		sdao.insert(supply);
		List supplyList= sdao.getallSuppliers();
	    ModelAndView mv=new ModelAndView("showSupplier","supplierInfo",supplyList);
	    return mv;
	    }
	@RequestMapping("/deleteSupply")
	public ModelAndView deleteSupplier(@RequestParam("supplyId")int supplierId)
	{
	sdao.deleteSupplier(supplierId);
	List supplyList =sdao.getallSuppliers();
    ModelAndView mv=new ModelAndView("showSupplier","supply",new Supplier());
	mv.addObject(supplyList);
    return mv;
	}
}
