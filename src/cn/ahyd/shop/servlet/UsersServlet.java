package cn.ahyd.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ahyd.shop.dao.UsersDaoImpl;
import cn.ahyd.shop.model.Users;
import cn.ahyd.shop.service.UsersServiceImpl;

@WebServlet(urlPatterns = "/UsersServlet")
public class UsersServlet extends HttpServlet {
	private UsersServiceImpl usersService = new UsersServiceImpl();

	public void destroy() {
		super.destroy(); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Users users = usersService.login(request.getParameter("name"),
				request.getParameter("password"));
		if (users != null) {
			request.getSession().setAttribute("users", users);
			
			response.sendRedirect(request.getContextPath() + "/admin/index.jsp");


		} else {
			request.setAttribute("error", "登录失败!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

	public void init() throws ServletException {
		
	}

}
