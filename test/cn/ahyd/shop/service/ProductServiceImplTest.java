package cn.ahyd.shop.service;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ahyd.shop.model.Product;
import cn.ahyd.shop.service.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-bean.xml")
public class ProductServiceImplTest {

	@Resource(name="productService")  // 查找spring-bean.xml中 id为 productService的Bean
	private ProductServiceImpl productService;

	@Test
	public void testGetById() {
		System.out.println(productService.getById(2));
	}

	@Test
	public void testQueryByBameString() {
		List<Product> product = productService.queryByBame("");
		for(Product temp:product){
			System.out.println(temp);
		}
		
	}

	@Test
	public void testQueryByBameStringIntInt() {
		List<Product> proList = productService.queryByBame("", 2, 4);
		for(Product temp:proList){
			System.out.println(temp);
		}
	}

	@Test
	public void testSave() {
		Product product = new Product();
		product.setName("000笔记本电脑");
		product.setPrice(new BigDecimal(99.99));
		product.setRemark("333游戏本!");
		productService.save(product);
	}

	@Test
	public void testUpdate() {
		Product product = new Product();
		product.setName("111笔记本电脑");
		product.setPrice(new BigDecimal(100.99));
		product.setRemark("111游戏本!");
		product.setId(new Integer(9));
		productService.update(product);	
	}

	@Test
	public void testDelete() {
		
		productService.delete(5);
		
	}

}
