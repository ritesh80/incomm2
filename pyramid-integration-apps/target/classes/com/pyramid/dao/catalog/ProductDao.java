package com.pyramid.dao.catalog;

import java.util.List;

import com.pyramid.model.catalog.Product;

public interface ProductDao {
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void removeProduct(Product product);
	
	public Product getProductById(Integer part_id);
	
	public List<Product> getProductBycategory_id(Integer category_id);

}
