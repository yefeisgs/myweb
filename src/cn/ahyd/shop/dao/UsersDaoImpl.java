package cn.ahyd.shop.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.ahyd.shop.model.Users;

public class UsersDaoImpl {
	
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public Users  login(String name, String pass) {
		
		String sql = "select * from users where name = ? and pass = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { name, pass },
				new BeanPropertyRowMapper<Users> (Users.class));
		
	}

}
