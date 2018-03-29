package cn.anyd.shop.util;



import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;


import cn.ahyd.shop.model.Product;
import cn.ahyd.shop.dao.ProductDaoImpl;


public class Maintest {
	public static void main(String[] args) {
		// 加载spring的配置文件(默认是饿汉模式)
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-bean.xml");
		System.out.println("---------------------------------------");
		// 通过id获取相应的class文件,从而创建当前类的对象
//		System.out.println(context.getBean("product"));
//		System.out.println(context.getBean("product"));
		// 只能通过Spring的方式创建,采用使用IOC AOP的功能
		ProductDaoImpl daoImpl = context.getBean("productDao",ProductDaoImpl.class);

		daoImpl.getById(3);
	}
	

}
