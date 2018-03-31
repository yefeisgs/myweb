package cn.ahyd.shop.service;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.ahyd.shop.model.Users;

@Service(value="usersService")
public class UsersServiceImpl{
	
	@Resource 
	private JdbcTemplate jdbcTemplate = null;

	
	public Users login(String name, String pass) {
		String sql = "select * from users where name = ? and pass = ?";
		try{
			return jdbcTemplate.queryForObject(sql, new Object[] { name, pass },
					new BeanPropertyRowMapper<Users> (Users.class));
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}