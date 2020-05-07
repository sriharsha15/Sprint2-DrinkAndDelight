package com.capgemini.drinkanddelight.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.drinkanddelight.entity.Distributor;
import com.capgemini.drinkanddelight.entity.ProductStock;


public interface ProductDao 
{
	public ProductStock trackProductOrder(String orderId);
	public String updateExitDateinStock(String orderId,Date exitDate);
	public String updateProductStock(String orderId,Date manufacturingDate,Date expiryDate,String qualityCheck);
	public boolean doesProductOrderIdExist(String orderId);
	public List<ProductStock> displayAll();
	public boolean delete(String orderId);
	public ProductStock addProductStock(ProductStock productstock);
}
