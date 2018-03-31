package cn.ahyd.shop.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.ahyd.shop.model.Product;


@Controller  
@RequestMapping(value = "/product")
public class ProductController extends BaseContorller{
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/query.jsp";
	}
	
	@RequestMapping("/save")
	public String save(Product product,@RequestParam("img") MultipartFile file){
		String path = request.getServletContext().getRealPath("/images/");
		String filename = file.getOriginalFilename();
		File dest = new File(path,filename);
		try {
			file.transferTo(dest);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		product.setPic(filename);
		
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
