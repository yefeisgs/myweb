package cn.ahyd.shop.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.ahyd.shop.model.Users;
import cn.ahyd.shop.service.UsersServiceImpl;

public class UsersServiceImplTest {

	private static UsersServiceImpl usersService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usersService = new UsersServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		usersService = null;
	}

	@Test
	public void testLogin() {
		Users users = usersService.login("admin", "admin123");
		System.out.println(users);
	}

}
