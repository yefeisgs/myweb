package cn.ahyd.shop.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.ahyd.shop.service.ProductServiceImpl;

public class InitDataListerner implements ServletContextListener {
	
	private ProductServiceImpl productService = new ProductServiceImpl();

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		ServletContext application = event.getServletContext();
		application.setAttribute("proList", productService.queryByBame(""));
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

}
