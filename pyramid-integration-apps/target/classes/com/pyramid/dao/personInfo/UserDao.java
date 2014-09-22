package com.pyramid.dao.personInfo;

import com.pyramid.model.personInfo.User;

public interface UserDao {
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void removeUser(User user);

	public User getUser(String login);
}
