package com.pyramid.web.jx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pyramid.model.catalog.Category;
import com.pyramid.service.catalog.CatalogService;
import com.sun.jersey.api.JResponse;
import com.sun.jersey.api.view.Viewable;
@Component
@Path("/main")
public class MainController {
	@Autowired
	private CatalogService categoryServiceImpl;
	
	@GET
	@Path("/index")
	@Produces("text/html")
	public Response index(){
		Map reqAttribute = new HashMap();
		List<Category> categories = null;
		categories = categoryServiceImpl.getAllCategories();
		reqAttribute.put("categories", categories);
		return Response.ok(new Viewable("/index.jsp" ,reqAttribute)).build();
	}

}
