package com.pyramid.dao.catalog;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pyramid.model.catalog.Category;
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCategory(Category category){
		sessionFactory.getCurrentSession().save(category);
	}
	
	public void updateCategory(Category category){
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	
	public void removeCategory(Category category){
		sessionFactory.getCurrentSession().delete(category);
	}
	
	public Category getCategoryById(Integer id)
	{
		return (Category)sessionFactory.getCurrentSession().createSQLQuery("select * from Category where id="+id).addEntity(Category.class).uniqueResult();
	}
	
	public List<Category> getAllCategories(){
		return (List<Category>)sessionFactory.getCurrentSession().createSQLQuery("select * from Category").addEntity(Category.class).list();
	}
}
