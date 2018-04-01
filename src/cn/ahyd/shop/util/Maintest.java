package cn.ahyd.shop.util;

import java.util.ArrayList;
import java.util.List;

public class Maintest {
	public static void main(String[] args)  {
		
		demo03();
	}
	
	public  static void demo01() {
		
		System.out.println("JVM申请的本项目内存最大值：" + Runtime.getRuntime().totalMemory()/1024.0/1024.0 + "MB");
		System.out.println("当前项目可用的初始值：" + Runtime.getRuntime().maxMemory()/1024.0/1024.0 + "MB");
		System.out.println("当请项目空闲的内存：" + Runtime.getRuntime().freeMemory()/1024.0/1024.0 + "MB");
		
		
	}
	
public  static void demo02() throws Exception{
		List<Object> objList = new ArrayList<Object>();
		System.out.println("JVM申请的本项目内存最大值：" + Runtime.getRuntime().totalMemory()/1024.0/1024.0 + "MB");
		System.out.println("当前项目可用的初始值：" + Runtime.getRuntime().maxMemory()/1024.0/1024.0 + "MB");
		
		for (int i = 1; i<=40; i++){
			
			objList.add(new byte[1024*1024*1]);
			System.out.println("i：" + i +"----->" + Runtime.getRuntime().totalMemory()/1024.0/1024.0 + "MB" + Runtime.getRuntime().maxMemory()/1024.0/1024.0 + "MB");
			Thread.sleep(500);
		}
}
		private static int count = 0;
		
		public void test2(int x, double y, long z){
			
		}
		
		public static void test(int x, double y, long z){
			int a = x;
			double b = y;
			long c = z;
			
			count++;
			test(a,b,c);
		}
	
		public static void demo03(){
			
			try {
				test(100,3.15,1000);
			} catch (Throwable e) {
				System.out.println("count:" + count);
			}
			
	}
		
		



	
}
	


