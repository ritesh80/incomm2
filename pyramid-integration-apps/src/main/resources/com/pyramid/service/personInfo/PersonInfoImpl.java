package com.pyramid.service.personInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pyramid.dao.personInfo.UserDao;
import com.pyramid.model.personInfo.User;
@Service
public class PersonInfoImpl implements PersonInfo,UserDetailsService {
	@Autowired
	private UserDao userDaoImpl;
	
	public User getUser(String login){
		return userDaoImpl.getUser(login);
	}
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		System.out.println("login name ."+  login);
		User user = userDaoImpl.getUser(login);
		if(user == null){
			throw new UsernameNotFoundException(login + " not found");
		}
		System.out.println("user found."+  user.getFirstname());
		List<SimpleGrantedAuthority> grantAuthories = new java.util.ArrayList<SimpleGrantedAuthority>();
		grantAuthories.add(new SimpleGrantedAuthority("Admin"));
		UserDetails userd = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), true, true, true, true, grantAuthories);
        return userd;
	}
	
	public void addUser(User user){
		userDaoImpl.addUser(user);
	}
	
	public void updateUser(User user){
		userDaoImpl.updateUser(user);
	}
	
	public void removeUser(User user){
		userDaoImpl.removeUser(user);
	}
}
