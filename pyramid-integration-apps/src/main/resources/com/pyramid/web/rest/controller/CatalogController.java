package com.pyramid.web.rest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pyramid.model.catalog.Product;
import com.pyramid.service.catalog.CatalogService;

@Controller
public class CatalogController {
	
	@Autowired
	private CatalogService catalogServiceImpl;
	
	@RequestMapping(value="/catalog/index.html", method =RequestMethod.GET)	
	public ModelAndView initialCatalogPage(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap();
		map.put("categories", catalogServiceImpl.getAllCategories());
		return new ModelAndView("catalog/index").addAllObjects(map);
	}
	@RequestMapping(value="/catalog/products.html", method =RequestMethod.GET)	
	public ModelAndView initialcatalog(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap();
		Integer category = 0;
		if(request.getParameter("cateogry_id") != null && !request.getParameter("cateogry_id").equals("") )
		category = Integer.parseInt(request.getParameter("category_id"));
		map.put("products", catalogServiceImpl.getProductBycategory_id(category));
		return new ModelAndView("catalog/prodIndex").addAllObjects(map);
	}
	
	@RequestMapping(value="/catalog/findPart", method =RequestMethod.GET)	
	public Product findPart(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap();
		Integer part_id = 0;
		if(request.getParameter("part_id") != null && !request.getParameter("part_id").equals("") )
			part_id = Integer.parseInt(request.getParameter("part_id"));
		Product prod = catalogServiceImpl.getProductById(part_id);
		return prod;
	}
	
	@RequestMapping(value="/catalog/cart.html", method =RequestMethod.GET)	
	public ModelAndView initialCartPage(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap();
		String products = (String)request.getSession().getAttribute("products");
		return new ModelAndView("catalog/index").addAllObjects(map);
	}
}
