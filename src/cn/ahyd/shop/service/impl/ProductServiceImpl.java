package cn.ahyd.shop.service.impl;

import java.util.List;

import cn.ahyd.shop.dao.ProductDao;
import cn.ahyd.shop.model.Product;
import cn.ahyd.shop.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	
	private ProductDao productDao = null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	


	@Override
	public Product getById(int id) {
		return productDao.getById(id);
	}

	
	
	@Override
	public List<Product> queryByBame(String name) {
		return productDao.queryByBame(name);
	}

	
	@Override
	public List<Product> queryByBame(String name, int page, int size) {
		return productDao.queryByBame(name, page, size);

	}

	
	
	@Override
	public void save(Product product) {
		productDao.save(product);
	}

	
	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	
	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

}
