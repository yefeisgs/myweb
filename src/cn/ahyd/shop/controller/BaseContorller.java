package cn.ahyd.shop.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import cn.ahyd.shop.service.ProductServiceImpl;
import cn.ahyd.shop.service.UsersServiceImpl;

@Controller
public class BaseContorller {
	
	@Resource
	protected ProductServiceImpl productService = null;
	
	@Resource
	protected UsersServiceImpl usersServiceImpl = null;
	
	
	@Resource
	protected HttpServletRequest request;  
	@Resource
	protected HttpSession session;  
	@Resource
	protected ServletContext application;  

}
