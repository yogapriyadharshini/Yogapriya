package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.dao.*;
import com.niit.shoppingcart.model.*;


public class CategoryTest {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
		
		
		
	   CategoryDAO categoryDAO = 	(CategoryDAO) context.getBean("categoryDAO");
	   
	   Category category = 	(Category) context.getBean("category");
	   category.setId("CA004");
	   category.setName("ACCESSORIES");
	   
	   
	   
	   categoryDAO.saveOrUpdate(category);
	
	 /*  
	   
		SupplierDAO supplierDAO = 	(SupplierDAO) context.getBean("supplierDAO");
		   
		   Supplier supplier = 	(Supplier) context.getBean("supplier");
		   supplier.setId("SU001");
		   supplier.setName("AUREILA");
		   supplier.setAddress("US");
		   
		   
		   supplierDAO.saveorupdate(supplier);
		   */
		   
		   
		   
		   
		  /* 
			UserDAO userdao= (UserDAO) context.getBean("userdao");
			User user= (User) context.getBean("user");
			
			user.setId("01");
			user.setUsername1("JHON");
			user.setUsername2("PETER");
			user.setUtype("user");
			user.setEmail("example@gmail.com");
			user.setPassword("password");
			user.setAddress("US");
			user.setPhno("123456789");
			
			userdao.saveOrUpdate(user);*/
			
			/*String type=userdao.isValidUser("usr001", "password");
			if(type=="user"){
				System.out.println("valid user");
				
			}
			else{System.out.println("invalid user");}
		 */
		/*ProductDAO productDAO=(ProductDAO)context.getBean("ProductDAO");
		Product product=new Product();
		product.setId("001");
		product.setName("BIBA");
		product.setCategory("CA002");
		product.setSupplier("SU001");
		product.setPrice("17550");
		product.setDesc("BIBA EXTRAORDINARY COLLECTIONS");
		productDAO.saveorupdate(product);
		   */
		   
	   
	
	}

}
