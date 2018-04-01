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
	

	/* (non-Javadoc)
	 * @see cn.ahyd.shop.service.ProductService#getById(int)
	 */
	@Override
	public Product getById(int id) {
		return productDao.getById(id);
	}

	
	/* (non-Javadoc)
	 * @see cn.ahyd.shop.service.ProductService#queryByBame(java.lang.String)
	 */
	@Override
	public List<Product> queryByBame(String name) {
		return productDao.queryByBame(name);
	}

	/* (non-Javadoc)
	 * @see cn.ahyd.shop.service.ProductService#queryByBame(java.lang.String, int, int)
	 */
	@Override
	public List<Product> queryByBame(String name, int page, int size) {
		return productDao.queryByBame(name, page, size);

	}

	
	/* (non-Javadoc)
	 * @see cn.ahyd.shop.service.ProductService#save(cn.ahyd.shop.model.Product)
	 */
	@Override
	public void save(Product product) {
		productDao.save(product);
	}

	/* (non-Javadoc)
	 * @see cn.ahyd.shop.service.ProductService#update(cn.ahyd.shop.model.Product)
	 */
	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	/* (non-Javadoc)
	 * @see cn.ahyd.shop.service.ProductService#delete(int)
	 */
	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

}
