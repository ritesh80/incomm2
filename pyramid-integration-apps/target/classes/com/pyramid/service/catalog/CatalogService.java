package com.pyramid.service.catalog;

import java.util.List;

import com.pyramid.model.catalog.Category;
import com.pyramid.model.catalog.Product;

public interface CatalogService {
	public Category getCategoryById(Integer id);
	
	public List<Category> getAllCategories();

	public Product getProductById(Integer part_id);
	
	public List<Product> getProductBycategory_id(Integer category_id);
	
	public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void removeCategory(Category category);
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void removeProduct(Product product);
}
