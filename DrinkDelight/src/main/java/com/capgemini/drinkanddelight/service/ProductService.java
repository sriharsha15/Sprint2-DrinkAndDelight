package com.capgemini.drinkanddelight.service;

import java.util.Date;
import java.util.List;

import com.capgemini.drinkanddelight.entity.ProductStock;
import com.capgemini.drinkanddelight.exception.ProductStockException;

public interface ProductService {
	public ProductStock trackProductOrder(String orderId);
	public boolean doesProductOrderIdExist(String orderId);
	public String updateExitDateinStock(String orderId,Date exitDate)throws ProductStockException;
	public String updateProductStock(String orderId,Date manufacturingDate,Date expiryDate,String qualityCheck)throws ProductStockException;
	public boolean exitDateCheck(Date exitDate)throws ProductStockException ;
	public boolean validateManfacturingDate(Date manufacturingDate)throws ProductStockException;
	public boolean validateExpiryDate(Date manufacturingDate,Date expiryDate) throws ProductStockException;
	public List<ProductStock> displayAll();
	public boolean delete(String orderId);
	public ProductStock addProductStock(ProductStock productstock);
}

