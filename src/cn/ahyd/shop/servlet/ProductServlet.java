package cn.ahyd.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ahyd.shop.dao.ProductDaoImpl;
import cn.ahyd.shop.model.Product;


@WebServlet(urlPatterns = "/servlet/ProductServlet")
public class ProductServlet extends HttpServlet {

	private ProductDaoImpl productDao = new ProductDaoImpl();

	
	public ProductServlet() {
		super();
		System.out.println("ProductServlet............");
	}

	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);

	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request);
		
		Product product = new Product();
		
		product.setName(request.getParameter("name"));
		product.setPrice(new BigDecimal(request.getParameter("price")));
		product.setRemark(request.getParameter("remark"));
		product.setId(Integer.parseInt(request.getParameter("id")));
		productDao.update(product);
		
		response.sendRedirect("/myweb/query.jsp");
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request);
		
		Product product = new Product();
		
		product.setName(request.getParameter("name"));
		product.setPrice(new BigDecimal(request.getParameter("price")));
		product.setRemark(request.getParameter("remark"));
		productDao.save(product);
		
		response.sendRedirect("/myweb/query.jsp");
	}

	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("session:" + session + "," + session.getId());
		
		String keyword = request.getParameter("keyword");
		session.setAttribute("keyword", keyword);
		
		List<Product> proList = productDao.queryByBame(keyword);
		
		request.setAttribute("proList", proList); // key value结构
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/query.jsp");
		dispatcher.forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		productDao.delete(Integer.parseInt(id));
		
		HttpSession session = request.getSession();
		System.out.println("session:" + session + "," + session.getId());
		String keyword = (String) session.getAttribute("keyword");
		List<Product> proList = productDao.queryByBame(keyword);
		
		request.setAttribute("proList", proList);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/query.jsp");
		dispatcher.forward(request, response);

	}
	
	public void getById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Product product = productDao.getById(Integer.parseInt(id));
		
		
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
		dispatcher.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		Class clazz = this.getClass();
		try {
			Method method = clazz.getDeclaredMethod(type,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void init() throws ServletException {
		
	}

}
