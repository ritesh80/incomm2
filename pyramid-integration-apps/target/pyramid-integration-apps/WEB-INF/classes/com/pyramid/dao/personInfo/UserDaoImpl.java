package com.pyramid.dao.personInfo;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.pyramid.model.personInfo.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user){
		sessionFactory.getCurrentSession().save(user);
	}
	
	public void updateUser(User user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void removeUser(User user){
		sessionFactory.getCurrentSession().delete(user);
	}
	
	public User getUser(String login){
		System.out.println("user ====:" + login);
		User user =  (User)sessionFactory.getCurrentSession().createSQLQuery("select * from User where login='"+login+"'").addEntity(User.class).uniqueResult();
		System.out.println("user :" + user.getFirstname());
		return user;
	}
}
