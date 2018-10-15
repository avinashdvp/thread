package com.avinash.dt12.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.avinash.dt12.productins.RegistrationDao;
import com.avinash.dt12.productins.RegistrationDaoimpl;

@Controller
public class AuthenticationController 
{	@Autowired
	ProductDao productDao;
	@Autowired
	RegistrationDaoimpl registrationDaoimpl;
	@Autowired
	LoginDaoimpl loginDaoimpl;
	@RequestMapping("/registeration")
	public ModelAndView regiater()
	{
  ModelAndView modelAndView =new ModelAndView("Register","reg",new Register());
  return modelAndView;
	}
	@RequestMapping("/addregister")
    public ModelAndView saveregistration (@ModelAttribute("reg") Register reg) throws IOException 
    {
		registrationDaoimpl.insertRegistration(reg);
		  
		 ModelAndView modelAndView =new ModelAndView("home");
	     return modelAndView;
		
    }
	@RequestMapping("/login")
	public  String login()
	{
	
		return "Login";
	}
	//@RequestMapping("/checklogin")
	public ModelAndView login(@RequestParam("email")String email,@RequestParam("password")String password)
	{
    String result= loginDaoimpl.logincheck(email,password);
    if(result=="success")
    {
    List prolist=productDao.getAllProducts();
    ModelAndView mv=new ModelAndView("user","productInfo",prolist);
     return mv;
    }
    else
    {
    	ModelAndView mv=new ModelAndView("Login");
        return mv;
    }
    }
	@RequestMapping("/LoginError")
			public ModelAndView gologinError()
			{
				
				return new ModelAndView("LoginError");
			}
	@SuppressWarnings("unchecked")
    @RequestMapping(value = "/login_session_attributes")
    public String login_session_attributes(HttpSession session,Model model) {
     System.out.println("email ========");
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
       System.out.println("email ========"+email);
        Register  user = registrationDaoimpl.getUser(email);
        System.out.println("username ========"+user.getRole());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("name", user.getPassword());
        
        session.setAttribute("LoggedIn", "true");
        
        
         //session.setAttribute("cartcnt",count);
        Collection<GrantedAuthority> authorities;
        authorities= (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String page="";
        String role="ROLE_USER";
        for (GrantedAuthority authority : authorities)
        {
          
             if (authority.getAuthority().equals(role))
             {
                 session.setAttribute("UserLoggedIn", true);
                 session.setAttribute("UserName", user.getUsername());
             page="/home";
                 session.setAttribute("test",1);
                
             }
             else
             {
                 session.setAttribute("Administrator",true);
                 //session.setAttribute("UserName", user.getUsername());
                 page="/index";
            
            }
        }
        return page;
    }

	
	
}
