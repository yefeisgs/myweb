package cn.ahyd.shop.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.ahyd.shop.service.ProductServiceImpl;

public class InitDataListerner implements ServletContextListener {
	
	private ProductServiceImpl productService = null;
	
	private ApplicationContext context =null;

	public InitDataListerner(){
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productService = context.getBean("productService",ProductServiceImpl.class);
		
		ServletContext application = event.getServletContext();
		application.setAttribute("proList", productService.queryByBame(""));
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}
}
