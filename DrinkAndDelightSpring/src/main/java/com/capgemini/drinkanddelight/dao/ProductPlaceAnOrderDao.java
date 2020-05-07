package com.capgemini.drinkanddelight.dao;

import java.util.List;

import com.capgemini.drinkanddelight.entity.PlaceOrder;
import com.capgemini.drinkanddelight.entity.ProductSpecs;

public interface ProductPlaceAnOrderDao {
	 

	public boolean addProductSpecs(ProductSpecs productSpecs);
	
	
	public List<ProductSpecs> getAllProductSpecs();
	
	
	public List<PlaceOrder> getProductOrderedList();
	
	
	public boolean placeAnOrder(PlaceOrder productOrder);
	
	
	public Boolean cancelAnOrder(int productId);
	

	public boolean orderIdExists(int orderId);
	
	
	
}
