package com.pyramid.web.jx.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pyramid.dao.catalog.CategoryDao;
import com.pyramid.model.catalog.Category;
import com.pyramid.model.personInfo.User;
import com.pyramid.service.catalog.CatalogService;
import com.sun.jersey.api.JResponse;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

@Component
@Path("/category")
public class CategorySService {
	
	@Autowired
	private CatalogService categoryServiceImpl;
	
	@GET
	@Path("/get/all")
	@Produces("application/json")
	public JResponse<List<Category>> getAllCategories(){
		List<Category> categories = null;
		categories = categoryServiceImpl.getAllCategories();
		return JResponse.ok(categories).build();
		
	}
	
	@POST
	@Path("/upload/image")
	@Consumes("multipart/form-data")
	public void getImage(MultipartBody body){
		List<Attachment> attachments = body.getAllAttachments();
		for(Attachment attach : attachments){
			System.out.println(attach.getContentId());
		}
		return ;
	}
	
}
