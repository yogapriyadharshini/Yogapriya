package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;


public interface SupplierDAO {

	public  List <Supplier> list(); 
	public Supplier get(String id);
	public void saveorupdate(Supplier supplier);
	public void delet(String id);
	
}
