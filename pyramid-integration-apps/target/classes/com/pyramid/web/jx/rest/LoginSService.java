package com.pyramid.web.jx.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.pyramid.model.personInfo.User;
import com.sun.jersey.api.view.Viewable;


@Component
@Path("/login")
public class LoginSService {
	@GET
	@Path("/get/{login}")
	@Produces("application/xml")
	public User getUser(@PathParam("login")String login){
		User user = new User();
		user.setLogin(login);
		return user;
		
	}
	@GET
	@Path("/welcome")
	@Produces("application/json")
	public String getUser(){
		return "welcome";
		
	}
	
	
	@GET
	@Path("/loginPage")
	@Produces("text/html")
	public Response loginPage(){
		return Response.ok(new Viewable("/login.jsp")).build();
	}
	@GET
	@Path("/logoutPage")
	@Produces("text/html")
	public Response logoutPage(){
		return Response.ok(new Viewable("/logout.jsp")).build();
	}
	@GET
	@Path("/deniedPage")
	@Produces("text/html")
	public Response deniedPage(){
		return Response.ok(new Viewable("/denied.jsp")).build();
	}
}
