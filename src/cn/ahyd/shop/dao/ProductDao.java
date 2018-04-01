package cn.ahyd.shop.dao;

import java.util.List;

import cn.ahyd.shop.model.Product;

public interface ProductDao {

	List<Product> queryByBame(String name);

	List<Product> queryByBame(String name, int page, int size);

	Product getById(int id);

	void save(Product product);

	void update(Product product);

	void delete(int i);

}