package cn.ahyd.shop.dao;

import cn.ahyd.shop.model.Users;

public interface UsersDao {

	Users login(String name, String pass);

}