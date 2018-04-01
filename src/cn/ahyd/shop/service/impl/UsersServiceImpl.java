package cn.ahyd.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.ahyd.shop.model.Users;
import cn.ahyd.shop.service.UsersService;

@Service(value="usersService")
public class UsersServiceImpl implements UsersService{
	
	@Resource 
	private JdbcTemplate jdbcTemplate = null;

	
	/* (non-Javadoc)
	 * @see cn.ahyd.shop.service.UsersService#login(java.lang.String, java.lang.String)
	 */
	@Override
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