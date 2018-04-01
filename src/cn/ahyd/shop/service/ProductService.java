package cn.ahyd.shop.service;

import java.util.List;

import cn.ahyd.shop.model.Product;

public interface ProductService {

	Product getById(int id);

	List<Product> queryByBame(String name);

	List<Product> queryByBame(String name, int page, int size);

	void save(Product product);

	void update(Product product);

	void delete(int id);

}