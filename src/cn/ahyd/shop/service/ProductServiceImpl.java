package cn.ahyd.shop.service;

import java.util.List;

import cn.ahyd.shop.dao.ProductDaoImpl;
import cn.ahyd.shop.model.Product;

public class ProductServiceImpl {
	
	
	private ProductDaoImpl productDao = null;
	
	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}
	

	public Product getById(int id) {
		 System.out.println("**************");
		return productDao.getById(id);
	}

	// 如果没有给集合指定类型,则默认就是object类型.可以指定泛型<Product>
	public List<Product> queryByBame(String name) {
		return productDao.queryByBame(name);
	}

	public List<Product> queryByBame(String name, int page, int size) {
		return productDao.queryByBame(name, page, size);

	}

	// 完成数据的插入操作 ctrl + shift + f
	public void save(Product product) {
		productDao.save(product);
	}

	public void update(Product product) {
		productDao.update(product);
	}

	public void delete(int id) {
		productDao.delete(id);
	}

}
