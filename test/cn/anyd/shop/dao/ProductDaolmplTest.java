package cn.anyd.shop.dao;



import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.ahyd.shop.dao.ProductDao;
import cn.ahyd.shop.dao.impl.ProductDaoImpl;
import cn.ahyd.shop.model.Product;

public class ProductDaolmplTest {
	
	private static ProductDao daoImpl = null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	daoImpl = new ProductDaoImpl();	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		daoImpl = null;
		
	}

	@Test
	public void testSave() {
		Product product = new Product();
		product.setName("000笔记本电脑");
		product.setPrice(new BigDecimal(99.99));
		product.setRemark("333游戏本!");
		daoImpl.save(product);
	}

	@Test
	public void testUpdate() {
		Product product = new Product();
		product.setName("111笔记本电脑");
		product.setPrice(new BigDecimal(100.99));
		product.setRemark("111游戏本!");
		product.setId(new Integer(9));
		daoImpl.update(product);	
	}

	@Test
	public void testDelete() {
		daoImpl.delete(5);
	}

	@Test
	public void testGetByid() {
		Product byid = daoImpl.getById(6);
		System.out.println(byid);
	}
	
	@Test
	public void testQueryName() {
		List<Product> proList = daoImpl.queryByBame("");
		for(Product temp:proList){
			System.out.println(temp);
		}
	}
	
	@Test
	public void testQueryName1() {
		List<Product> proList = daoImpl.queryByBame("", 2, 4);
		for(Product temp:proList){
			System.out.println(temp);
		}
	}

}
