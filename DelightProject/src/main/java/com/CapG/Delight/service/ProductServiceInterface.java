package com.CapG.Delight.service;

import java.util.List;

import com.CapG.Delight.entity.ProductOrder;

public interface ProductServiceInterface {
	
	public ProductOrder trackById(String id);
    	
   	public List<ProductOrder> reterive();

	public boolean updateIdWithStatus(String id, String status);

}