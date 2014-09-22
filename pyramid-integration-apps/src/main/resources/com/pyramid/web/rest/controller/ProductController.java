package com.pyramid.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pyramid.service.catalog.CatalogService;

@Controller
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private CatalogService catalogServiceImpl;
	
	
}
