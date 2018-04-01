package cn.ahyd.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns="/admin/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if (session.getAttribute("users") != null) {
			chain.doFilter(request, response);
		} else {
			
			request.setAttribute("error", "请先登录!");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	@Override
	public void init(FilterConfig afilterconfigrg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
