package cn.ahyd.shop.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import cn.ahyd.shop.service.ProductService;
import cn.ahyd.shop.service.UsersService;

@Controller
public class BaseContorller {
	
	@Resource
	protected ProductService productService = null;
	
	@Resource
	protected UsersService usersServiceImpl = null;
	
	
	@Resource
	protected HttpServletRequest request;  
	@Resource
	protected HttpSession session;  
	@Resource
	protected ServletContext application;  

}
