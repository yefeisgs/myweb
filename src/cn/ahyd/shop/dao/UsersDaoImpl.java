package cn.ahyd.shop.dao;

import java.util.List;

import cn.ahyd.shop.model.Users;

public class UsersDaoImpl extends BaseDaoImpl<Users> {
	
	public Users  login(String name, String pass) {
		
		String sql = "select * from users where name = ? and pass = ?";
		List<Users> uList = super.queryByBame(sql, new Object[] { name, pass },
				Users.class);
		return uList.size() == 1 ? uList.get(0) : null;
		
	}

}
