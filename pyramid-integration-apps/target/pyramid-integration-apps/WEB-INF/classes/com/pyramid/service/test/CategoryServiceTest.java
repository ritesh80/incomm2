package com.pyramid.service.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import com.pyramid.model.catalog.Category;
import com.pyramid.service.catalog.CatalogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/pyramid-storage.xml"})
public class CategoryServiceTest {
	  private final static Logger logger = LoggerFactory
		      .getLogger(CategoryServiceTest.class);
	  
	 @Autowired
	  CatalogService categoryServiceImp;
	 
	  @Test
	  public void test() {    
		 /* Category category = new Category();
		  category.setName("xxx");
		  category.setDisplayName("scs sds");*/
		  Category category = categoryServiceImp.getCategoryById(3);
		  category.setName("club car 4");
	    categoryServiceImp.updateCategory(category);
	  }
}
