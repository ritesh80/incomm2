package com.pyramid.dao.catalog;

import java.util.List;

import com.pyramid.model.catalog.Category;

public interface CategoryDao {
	
	public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void removeCategory(Category category);
	
	public Category getCategoryById(Integer id);
	
	public List<Category> getAllCategories();

}
