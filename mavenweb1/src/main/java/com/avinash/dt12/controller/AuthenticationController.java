package com.avinash.dt12.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.avinash.dt12.model.Login;
import com.avinash.dt12.model.Product;
import com.avinash.dt12.model.Register;
import com.avinash.dt12.productins.LoginDaoimpl;
import com.avinash.dt12.productins.ProductDao;
import com.avinash.dt12.productins.RegistrationDaoimpl;

@Controller
public class AuthenticationController 
{	@Autowired
	ProductDao pdao;
	@Autowired
	RegistrationDaoimpl rdao;
	@Autowired
	LoginDaoimpl ldao;
	@RequestMapping("/registeration")
	public ModelAndView regiater()
	{
  ModelAndView mv =new ModelAndView("Register","reg",new Register());
  return mv;
	}
	@RequestMapping("/addregister")
    public ModelAndView saveregistration (@ModelAttribute("reg") Register reg) throws IOException 
    {
		  
		 ModelAndView mv=new ModelAndView("home");
	     return mv;
		
    }
	@RequestMapping("/login")
	public  String login()
	{
	
		return "Login";
	}
	@RequestMapping("/checklogin")
	public ModelAndView login(@RequestParam("email")String email,@RequestParam("password")String password)
	{
    String result= ldao.logincheck(email,password);
    if(result=="success")
    {
    List prolist=pdao.getAllProducts();
    ModelAndView mv=new ModelAndView("user","productInfo",prolist);
     return mv;
    }
    else
    {
    	ModelAndView mv=new ModelAndView("Login");
        return mv;
    }
    }
}
