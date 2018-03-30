package cn.ahyd.shop.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ahyd.shop.model.Product;
import cn.ahyd.shop.service.ProductServiceImpl;
import cn.ahyd.shop.servlet.ProductServlet;


@Controller  
@RequestMapping(value = "/product")
public class ProductController extends BaseContorller{
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/query.jsp";
	}
	
	@RequestMapping("/save")
	public String save(Product product){
		
		productService.save(product);
		return "redirect:/query.jsp";
		
	}
	@RequestMapping("/query")
	public String query(String keyword){
		session.setAttribute("keyword", keyword);
		List<Product> proList = productService.queryByBame(keyword);
		request.setAttribute("proList", proList);		
		return "forward:/query.jsp";  
	}
	@RequestMapping("/delete")
	public String delete(Integer id){
		
		productService.delete(id);
		
		String keyword = (String) session.getAttribute("keyword");
		List<Product> proList = productService.queryByBame(keyword);
		
		request.setAttribute("proList", proList);
		return "forward:/query.jsp";
		
	}
	@RequestMapping("/getById")
	public String getById(Integer id) {
		Product product = productService.getById(id);
		request.setAttribute("product", product);
		return "forward:/update.jsp";
	}
}
