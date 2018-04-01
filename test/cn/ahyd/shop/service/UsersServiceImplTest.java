package cn.ahyd.shop.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ahyd.shop.model.Users;
import cn.ahyd.shop.service.impl.UsersServiceImpl;

public class UsersServiceImplTest {
	
	private static ApplicationContext context = null;
	private static UsersService usersService = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	//	usersService = new UsersServiceImpl();
		
		context = new ClassPathXmlApplicationContext("spring-bean.xml");
		usersService = context.getBean("usersService", UsersServiceImpl.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		usersService = null;
	}

	@Test
	public void testLogin() {
		System.out.println("*************");
		Users users = usersService.login("admin", "admin123");
		System.out.println(users);
		System.out.println("-------------");
	}

}
