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
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1: 获取前端数据
		// request.setCharacterEncoding("UTF-8"); // 过滤器已经解决此问题
		// 2: 调用业务逻辑(如果登录成功则把登录信息存储到session中,否则重新调回login.jsp)
		Users users = usersService.login(request.getParameter("name"),
				request.getParameter("password"));
		if (users != null) {
			request.getSession().setAttribute("users", users);
			// 会跳转到后台
		} else {
			request.setAttribute("error", "登录失败!");
		}
		// 3: 返回结果(jsp/json)
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
