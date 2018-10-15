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
	CategoryDao categoryDao;
	@RequestMapping("/Category")

	public ModelAndView m2()
	{
		ModelAndView modelAndView=new ModelAndView("showCategory","cat",new Category());
		List catList =categoryDao.getAllCategory();
		modelAndView.addObject("categoryInfo",catList);
		return modelAndView;
	}
	@RequestMapping(value="/addCategory" , method=RequestMethod.POST)
	 public ModelAndView saveCategory(@ModelAttribute("cat") Category cat)
	    {
		categoryDao.insert(cat);
	        List catList =categoryDao.getAllCategory();
	    ModelAndView modelAndView=new ModelAndView("showCategory","categoryInfo",catList);
	    return modelAndView;
	    }
	@RequestMapping("/deleteCat")
	public ModelAndView deleteCategory(@RequestParam("catId")int CategoryId)
	{
		categoryDao.deleteCategory(CategoryId);
	List catList =categoryDao.getAllCategory();
    ModelAndView modelAndView=new ModelAndView("showCategory","cat",new Category());
    modelAndView.addObject("categoryInfo",catList);
    return modelAndView;
	}
}
