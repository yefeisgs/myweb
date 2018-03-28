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

/*
 * Filter、Listener、Servlet称为web三大组件，它们都是单例模式
 * Servlet:第一个请求的时候被创建,然后常驻内存，单例模式类不能有用来存储数据的成员变量,否则会出现线程安全问题
 * */

// 由于此类继承了HttpServlet,因此它就可以接受Http请求.而且此类还可以Dao交互
@WebServlet(urlPatterns = "/servlet/ProductServlet")
public class ProductServlet extends HttpServlet {

	private ProductDaoImpl productDao = new ProductDaoImpl();

	// 单例模式下的成员变量会有线程安全问题
	// String keyword = null;
	// web: servlet service、dao都应该为单例模式
	public ProductServlet() {
		super();
		System.out.println("ProductServlet............");
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	// 用来处理get请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 所有请求都在doPost中处理
		doPost(request, response);

	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request);
		// 获取前端数据,并且封装在Product对象中(java web:从客户端发送过来的请求都被封装成request对象)
		Product product = new Product();
		// getParameter("name") 与前端form表单的name属性对应
		product.setName(request.getParameter("name"));
		product.setPrice(new BigDecimal(request.getParameter("price")));
		product.setRemark(request.getParameter("remark"));
		product.setId(Integer.parseInt(request.getParameter("id")));
		productDao.update(product);
		// 返回给客户端响应(页面/JSON)
		// sendRedirect重定向,web中访问资源都需要添加工程名
		// 在重定向模式下servlet->jsp不能共享request数据
		response.sendRedirect("/myweb/query.jsp");
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request);
		// 获取前端数据,并且封装在Product对象中(java web:从客户端发送过来的请求都被封装成request对象)
		Product product = new Product();
		// getParameter("name") 与前端form表单的name属性对应
		product.setName(request.getParameter("name"));
		product.setPrice(new BigDecimal(request.getParameter("price")));
		product.setRemark(request.getParameter("remark"));
		productDao.save(product);
		// 返回给客户端响应(页面/JSON)
		// sendRedirect重定向,web中访问资源都需要添加工程名
		// 在重定向模式下servlet->jsp不能共享request数据
		response.sendRedirect("/myweb/query.jsp");
	}

	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// session是服务器给每个用户分配的空间,在第一次访问服务器时会创建.默认声明周期为30分钟
		// 每个用户都有自己的查询关键字,应该存储到自己的session中
		HttpSession session = request.getSession();
		System.out.println("session:" + session + "," + session.getId());
		// 1: 获取前端数据
		String keyword = request.getParameter("keyword");
		session.setAttribute("keyword", keyword);
		// 2: 调用Service业务逻辑
		List<Product> proList = productDao.queryByBame(keyword);
		// 3: 返回结果(jsp/json)
		// Servlet --> JSP如何传递数据 (JSP:提供内置对象：request,session,application)
		request.setAttribute("proList", proList); // key value结构
		// response.sendRedirect("/webshop/query.jsp");
		// 页面跳转只有两种：重定向(不能共享同一个request),转发(只能转发系统内部页面,因此默认已经添加工程名)
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/query.jsp");
		dispatcher.forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1: 获取要删除的id
		String id = request.getParameter("id");
		productDao.delete(Integer.parseInt(id));
		// 2: 获取原来keyword查询
		HttpSession session = request.getSession();
		System.out.println("session:" + session + "," + session.getId());
		String keyword = (String) session.getAttribute("keyword");
		List<Product> proList = productDao.queryByBame(keyword);
		// 3: 返回结果(jsp/json)
		request.setAttribute("proList", proList); // key value结构
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/query.jsp");
		dispatcher.forward(request, response);

	}
	
	public void getById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1: 获取要删除的id
		String id = request.getParameter("id");
		// 2: 先获取要更新的数据
		Product product = productDao.getById(Integer.parseInt(id));
		
		// 3: 把待更新的数据存储到request中,然后转发到update.jsp
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
		dispatcher.forward(request, response);
	}

	// 用来处理post请求
	/*
	 * request: 从前端传入的请求数据(封装) reponse: 从服务器端返回的客户端的响应数据(封装)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 通过获取type,得到请求的类型
		String type = request.getParameter("type");
		// 通过反射获取当前Servlet中与type同名的方法
		Class clazz = this.getClass(); // 有三种方式:ProductServlet.class文件
		try {
			Method method = clazz.getDeclaredMethod(type,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// if (type.equals("save")) {
		//
		// } else if (type.equals("query")) {
		//
		// } else if (type.equals("delete")) {
		//
		// }

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
