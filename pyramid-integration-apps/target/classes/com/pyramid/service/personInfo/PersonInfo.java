package com.pyramid.service.personInfo;

import org.springframework.stereotype.Service;

import com.pyramid.model.personInfo.User;

@Service
public interface PersonInfo {
	public User getUser(String login);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void removeUser(User user);
}
