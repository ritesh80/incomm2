package com.pyramid.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyramid.model.personInfo.User;
import com.pyramid.service.personInfo.PersonInfo;
@Controller
public class LoginIntegrationServiceController {
	@Autowired
	PersonInfo personInfoImpl;
	
	@RequestMapping(value="/personinfo/get/{login}", method =RequestMethod.GET)	
	public User getLogin(@PathVariable String login){
		//User user = new User();
		//user.setLogin(login);
		//user.setMessage("welcome" +login);
		User user = personInfoImpl.getUser(login);
		return user;
	}
	@RequestMapping(value="/personinfo/login/set", method =RequestMethod.POST)	
	public boolean setUser(@RequestBody User user){
		return true;	
		
	}
	@RequestMapping(value="/personinfo/login/defaultInfo", method =RequestMethod.GET)	
	public User getInfo(){
		User user = new User();
		user.setLogin("demo");
		user.setPassword("demo");
		user.setMessage("Hello demo ");
		return user;
	}
	
}
