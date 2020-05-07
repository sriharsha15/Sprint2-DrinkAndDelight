package com.capgemini.drinkanddelight.service;


import java.util.List;

import com.capgemini.drinkanddelight.entity.PlaceOrder;
import com.capgemini.drinkanddelight.entity.ProductSpecs;


public interface ProductPlaceAnOrderService {
	
	public boolean addProductSpecs(ProductSpecs productSpecs);

	
	public List<ProductSpecs> getAllProductSpecs();
	
	
	public List<PlaceOrder> getProductOrderedList();
	
	
	public boolean productPlaceOrder(PlaceOrder productOrder);
	
	
	public boolean productCancelOrder(int orderId);

	
	public boolean orderIdExists(int orderId);
	
	
}
