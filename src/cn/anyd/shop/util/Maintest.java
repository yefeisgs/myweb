package cn.anyd.shop.util;



import java.lang.reflect.Method;
import java.lang.reflect.Field;


import cn.ahyd.shop.model.Product;


public class Maintest {
	public static void main(String[] args) throws Exception {
		
		Product product = new Product();
		product.setId(12);
		product.id= -1;
		System.out.println(product.id);
		
		Class clazz = Class.forName("cn.ahyd.shop.model.Product");
		
		Object t = clazz.newInstance();
		
		Method setId = clazz.getMethod("setId", Integer.class);
		
		setId.invoke(t, 12);
		
		Method getId = clazz.getMethod("getId");
		
		System.out.println(getId.invoke(t));
		
		Field name = clazz.getDeclaredField("name");
		
		name.setAccessible(true);
		
		name.set(t, "笔记本");
		
		System.out.println(name.get(t));
				
	}
}
