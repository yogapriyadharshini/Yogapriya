package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.dao.ProductDAOImpl;
import com.niit.shoppingcart.dao.CategoryDAOImpl;
import com.niit.shoppingcart.dao.UserDAOImpl;
import com.niit.shoppingcart.dao.SupplierDAOImpl;

@Controller
public class TestController {

	
	@Autowired
    UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;

    @Autowired
    User user;
    
    @Autowired
    SupplierDAO supplierDAO;
	
	@RequestMapping("/checkout")
	public ModelAndView toCheckout()
	{
		return new ModelAndView("checkout");
	}
	
	@RequestMapping("/checkoutl")
	public ModelAndView toCheckoutl()
	{
		return new ModelAndView("checkoutl");
	}
	
	@RequestMapping("/admin")
	public ModelAndView toAdmin()
	{
		return new ModelAndView("admin");
	}
	
	@RequestMapping("/codes")
	public ModelAndView toCodes()
	{
		return new ModelAndView("codes");
	}
	
	
	@RequestMapping("/contact")
	public ModelAndView toContact()
	{
		return new ModelAndView("contact");
	}
	
	@RequestMapping("/index")
	public ModelAndView toIndex()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView toLogin()
	{
		return new ModelAndView("login");
	}
	
	
	@RequestMapping("/register")
	public ModelAndView toRegister()
	{
		return new ModelAndView("register");
	}
	
	@RequestMapping("/product")
	public ModelAndView toProduct()
	{
		return new ModelAndView("product");
	}
	
	@RequestMapping("/single")
	public ModelAndView toSingle()
	{
		return new ModelAndView("single");
	}
	
	@RequestMapping("/products1")
	public ModelAndView toProducts1()
	{
		return new ModelAndView("products1");
	}
	
	@RequestMapping (value="/savenewcategory")
	 public ModelAndView newcat (@RequestParam("id") String id,@RequestParam("name") String name){
		 Category cat=new Category();
		 cat.setId(id);
		 cat.setName(name);
		 categoryDAO.saveOrUpdate(cat);
		 
		 ModelAndView mv;
		 return new ModelAndView("Cat");
		 
		 
	 }



@RequestMapping("/addCat")
public ModelAndView toAddCat(){
return new ModelAndView("addCat");
}

@RequestMapping (value="/savenewsupplier")
public ModelAndView newsupplier (@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("address") String address){
	 Supplier supplier=new Supplier();
	 supplier.setId(id);
	 supplier.setName(name);
	 supplier.setAddress(address);
	 supplierDAO.saveorupdate(supplier);
	 
	 ModelAndView mv;
	 return new ModelAndView("Supplier");
	 
	 
}



@RequestMapping("/addSupp")
public ModelAndView toAddSupp(){
return new ModelAndView("addSupp");
}
@RequestMapping (value="/savenewproduct")
public ModelAndView newproducts (@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("supplier") String supplier,@RequestParam("category") String category,@RequestParam("price") String price,@RequestParam("description") String description){
	 Product products=new Product();
	 products.setId(id);
	 products.setName(name);
	 products.setSupplier(supplier);
	 products.setCategory(category);
	 products.setPrice(price);
	 products.setDesc(description);
	 productDAO.saveorupdate(products);
	 
	 ModelAndView mv;
	 return new ModelAndView("Products");
	 
	 
}



@RequestMapping("/addProd")
public ModelAndView toAddProd(){
return new ModelAndView("addProd");
}

@RequestMapping (value="/savenewuser")
public ModelAndView newuser (@RequestParam("id") String id,@RequestParam("username1") String username1,@RequestParam("username2") String username2,@RequestParam("password") String password,@RequestParam("utype") String utype,@RequestParam("email") String email,@RequestParam("address") String Address,@RequestParam("phno") String phno){
	 User user=new User();
	 user.setId(id);
	 user.setUsername1(username1);
	 user.setUsername2(username2);
	 user.setPassword(password);
	 user.setUtype(utype);
	 user.setEmail(email);
	 user.setAddress(Address);
	 user.setPhno(phno);
	 userDAO.saveOrUpdate(user);
	 
	 ModelAndView mv;
	 return new ModelAndView("User");
	 
	 
}



@RequestMapping("/addUser")
public ModelAndView toAddUser(){
return new ModelAndView("addUser");
}
	

	 @RequestMapping(value="/IsValidUser",method=RequestMethod.POST)
	 public ModelAndView executeLogin(@RequestParam("Email") String Email,@RequestParam("Password") String pwd){
     
    	 ModelAndView mv;
		 if(Email.equals("sai95@gmail.com"))
		 {
			 mv=new ModelAndView("index");
		 }
			 else {
				 mv=new ModelAndView("register");
				 
			}
		 
	 return mv;
	 }
	
	 
	 @RequestMapping("/allCat")
	 public ModelAndView toCat()
	 {
		 return new ModelAndView("Cat");
	 }
	 
	 @RequestMapping("/allUser")
	 public ModelAndView toUser()
	 {
		 return new ModelAndView("User");
	 }
	 
	 @RequestMapping("/allProd")
	 public ModelAndView toProducts()
	 {
		 return new ModelAndView("Products");
	 }
	 
	 @RequestMapping("/allSupp")
	 public ModelAndView toSupplier()
	 {
		 return new ModelAndView("Supplier");
	 }
@RequestMapping("/dispProd")
public @ResponseBody String dispProd()
{
	List<Product> listProd=productDAO.list();
	
	Gson g=new Gson();
	String Products=g.toJson(listProd);
	
	for(Product u:listProd){
		
		System.out.println(u.getId());
		System.out.println(u.getName());
		System.out.println(u.getSupplier());
		System.out.println(u.getCategory());
		System.out.println(u.getPrice());
		System.out.println(u.getDesc());
		System.out.println("next");
	}
	return Products;
}
@RequestMapping("/dispSupp")
public @ResponseBody String dispSupp()
{
	List<Supplier> listSupp=supplierDAO.list();
	
	Gson g=new Gson();
	String Supplier=g.toJson(listSupp);
	
	for(Supplier u:listSupp){
		
		System.out.println(u.getId());
		System.out.println(u.getName());
		System.out.println(u.getAddress());
		
		System.out.println(" next ");
		
	}
	return Supplier;
}

@RequestMapping("/dispUser")
public @ResponseBody String dispUser()
{
	List<User> listUser=userDAO.list();
	
	Gson g=new Gson();
	String User=g.toJson(listUser);
	
	for(User u:listUser){
		
		System.out.println(u.getId());
		System.out.println(u.getUsername1());
		System.out.println(u.getUsername2());
		System.out.println(u.getPassword());
		System.out.println(u.getUtype());
		System.out.println(u.getEmail());
		System.out.println(u.getAddress());
		System.out.println(u.getPhno());
		System.out.println(" next ");
	}
	
	return User;
}
@RequestMapping("/dispCat")
public @ResponseBody String dispCategory()
{
	List<Category> listCategory=categoryDAO.list();
	
	Gson g=new Gson();
	String Cat=g.toJson(listCategory);
	
	for(Category u:listCategory){
		
		System.out.println(u.getId());
		System.out.println(u.getName());
		
		System.out.println(" next ");
		
	}
	return Cat;
}
	
}