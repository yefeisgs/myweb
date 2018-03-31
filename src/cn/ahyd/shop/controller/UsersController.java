package cn.ahyd.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ahyd.shop.model.Users;

@Controller
@RequestMapping(value = "/users")
public class UsersController extends BaseContorller{
	@RequestMapping("/login")
	public String login(String name, String password){
	
		Users users = usersServiceImpl.login(name , password);
		if (users != null) {
			session.setAttribute("users", users);
			return "redirect:/admin/index.jsp";

		} else {
			request.setAttribute("error", "登录失败!");
			return "forward:/login.jsp";
		}
		
		
	}

}
