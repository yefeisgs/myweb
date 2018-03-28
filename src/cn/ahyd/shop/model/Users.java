package cn.ahyd.shop.model;

import java.io.Serializable;

public class Users implements Serializable{
	
   
	private static final long serialVersionUID = -8028314857303471448L;

	private Integer id;

	private String name;
	
	private String pass;
	
	

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	

}
