package com.pyramid.dao.catalog;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pyramid.model.catalog.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product product){
		sessionFactory.getCurrentSession().save(product);
	}
	
	public void updateProduct(Product product){
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	
	public void removeProduct(Product product){
		sessionFactory.getCurrentSession().delete(product);
	}
	
	public Product getProductById(Integer part_id){
		return (Product)sessionFactory.getCurrentSession().createSQLQuery("select * from Product where id="+part_id).addEntity(Product.class).uniqueResult();
	}
	
	public List<Product> getProductBycategory_id(Integer category_id){
		return (List<Product>)sessionFactory.getCurrentSession().createSQLQuery("select * from PRODUCT prod JOIN PRODUCT_CATEGORY prod_cat ON (prod.id = prod_cat.product_id) where prod_cat.product_id="+category_id).addEntity(Product.class).list();
	}
}
