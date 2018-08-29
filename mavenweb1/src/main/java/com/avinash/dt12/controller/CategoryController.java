package com.avinash.dt12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avinash.dt12.model.Category;
import com.avinash.dt12.productins.CategoryDao;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDao cdao;
	@RequestMapping("/Category")

	public ModelAndView m2()
	{
		ModelAndView mv2=new ModelAndView("showCategory","cat",new Category());
		List catList =cdao.getAllCategory();
		mv2.addObject("categoryInfo",catList);
		return mv2;
	}
	@RequestMapping(value="/addCategory" , method=RequestMethod.POST)
	 public ModelAndView saveCategory(@ModelAttribute("cat") Category cat)
	    {
	        cdao.insert(cat);
	        List catList =cdao.getAllCategory();
	    ModelAndView mv=new ModelAndView("showCategory","categoryInfo",catList);
	    return mv;
	    }
	@RequestMapping("/deleteCat")
	public ModelAndView deleteCategory(@RequestParam("catId")int CategoryId)
	{
	cdao.deleteCategory(CategoryId);
	List catList =cdao.getAllCategory();
    ModelAndView mv=new ModelAndView("showCategory","cat",new Category());
	mv.addObject("categoryInfo",catList);
    return mv;
	}
}
