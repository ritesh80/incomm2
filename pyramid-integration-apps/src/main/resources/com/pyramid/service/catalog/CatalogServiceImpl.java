package com.pyramid.service.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyramid.dao.catalog.CategoryDao;
import com.pyramid.dao.catalog.ProductDao;
import com.pyramid.model.catalog.Category;
import com.pyramid.model.catalog.Product;

@Service
public class CatalogServiceImpl implements CatalogService{
	@Autowired
	private ProductDao productDaoImpl;
	
	@Autowired
	private CategoryDao categoryDaoImpl;

	public ProductDao getProductDaoImpl() {
		return productDaoImpl;
	}

	public void setProductDaoImpl(ProductDao productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	public CategoryDao getCategoryDaoImpl() {
		return categoryDaoImpl;
	}

	public void setCategoryDaoImpl(CategoryDao categoryDaoImpl) {
		this.categoryDaoImpl = categoryDaoImpl;
	}
	
	public Category getCategoryById(Integer id){
		return categoryDaoImpl.getCategoryById(id);
	}
	
	public List<Category> getAllCategories(){
		return categoryDaoImpl.getAllCategories();
	}

	public Product getProductById(Integer part_id){
		return productDaoImpl.getProductById(part_id);
	}
	
	public List<Product> getProductBycategory_id(Integer category_id){
		return productDaoImpl.getProductBycategory_id(category_id);
	}
	
	public void addCategory(Category category){
		categoryDaoImpl.addCategory(category);
	}
	
	public void updateCategory(Category category)
	{
		categoryDaoImpl.updateCategory(category);
	}
	
	public void removeCategory(Category category){
		categoryDaoImpl.removeCategory(category);
	}
	
	public void addProduct(Product product){
		productDaoImpl.addProduct(product);
	}
	
	public void updateProduct(Product product){
		productDaoImpl.updateProduct(product);
	}
	
	public void removeProduct(Product product){
		productDaoImpl.removeProduct(product);
	}

}
