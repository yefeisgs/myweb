package cn.ahyd.shop.service;

import cn.ahyd.shop.dao.UsersDaoImpl;
import cn.ahyd.shop.model.Users;

public class UsersServiceImpl{
	
private UsersDaoImpl usersDao = new UsersDaoImpl();
	
	public Users login(String name, String pass) {
		return usersDao.login(name, pass);
	}
}