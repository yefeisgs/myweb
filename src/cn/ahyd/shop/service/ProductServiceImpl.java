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
		return productDao.getById(id);
	}

	
	public List<Product> queryByBame(String name) {
		return productDao.queryByBame(name);
	}

	public List<Product> queryByBame(String name, int page, int size) {
		return productDao.queryByBame(name, page, size);

	}

	
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
