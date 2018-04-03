package cn.ahyd.shop.service;

import cn.ahyd.shop.model.Users;

public interface UsersService {

	public abstract Users login(String name, String pass);

}