package cn.ahyd.shop.service;

import cn.ahyd.shop.model.Users;

public interface UsersService {

	Users login(String name, String pass);

}