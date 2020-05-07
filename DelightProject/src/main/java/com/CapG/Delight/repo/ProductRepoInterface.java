package com.CapG.Delight.repo;

import java.util.List;

import com.CapG.Delight.entity.ProductOrder;



public interface ProductRepoInterface {
	
	public ProductOrder trackById(String id);
	
	public List<ProductOrder> reterive();

	public boolean updateIdWithStatus(String id, String status);

}