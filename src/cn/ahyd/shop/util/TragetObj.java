package cn.ahyd.shop.util;

import java.lang.reflect.Method;



interface MyInterface {
	public void save();

	public void update();
	
	public void delete();
}

class ProxyObj implements MyInterface {
	
	private MyInterface target;
	
	public ProxyObj(MyInterface target) {
		super();
		this.target = target;
	}
	
	@Override
	public void save(){
		System.out.println("开启事务.............");
		target.save(); 
		System.out.println("提交事务.............");
		
	}

	@Override
	public void update() {
		System.out.println("开启事务.............");
		target.update(); 
		System.out.println("提交事务.............");
		
	}

	@Override
	public void delete() {
		System.out.println("开启事务.............");
		target.delete(); 
		System.out.println("提交事务.............");
		
	}
	
	
}


public class TragetObj implements MyInterface{
	
	public static void main(String[] args){
		TragetObj targetObj = new TragetObj();
		// 创建代理对象(必须要先创建目标对象)
		ProxyObj obj = new ProxyObj(targetObj);
		// 以后就只能通过代理对象去操作(内部封装了目标对象)
		obj.save();
		obj.update();
		obj.delete();

		// 获取当前目标对象实现的接口
		Class clazz = TragetObj.class.getInterfaces()[0];
		// 获取当前接口的方法
		for (Method temp : clazz.getMethods()) {
			System.out.println(temp);
		}
		
	}
	
	public void  save() {
		
		System.out.println("数据入库…………");
		
	}
	
	public void  update() {
		
		System.out.println("数据更新…………");
		
	}
	public void  delete() {
		
		System.out.println("数据删除…………");
		
	}


}
