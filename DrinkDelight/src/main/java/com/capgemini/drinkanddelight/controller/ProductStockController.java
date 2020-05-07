package com.capgemini.drinkanddelight.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.drinkanddelight.entity.ProductStock;
import com.capgemini.drinkanddelight.exception.ProductStockException;
import com.capgemini.drinkanddelight.service.ProductService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductStockController
{
@Autowired
ProductService productservice;
/*
 * This is a GetMethod is used to track the particular orderId in the database.
 * Method 	 : trackProductOrder
 * Type 	 : ResponseEntity<ProductStock>
 * parameters: orderId
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@GetMapping("/getproductstock/{id}")
public ResponseEntity<ProductStock> trackProductOrder(@PathVariable("id") String orderId) throws ProductStockException {
	
	if(productservice.doesProductOrderIdExist(orderId))
	{
		ProductStock status = productservice.trackProductOrder(orderId);
		return new ResponseEntity<ProductStock>(status, HttpStatus.OK);
	}
	else
	{
	throw new ProductStockException("Orderid Does not exist");
	}
}
/*
 * This is a PostMethod is used to update the exitDate of the particular orderID in the database.
 * Method 	 : updateExitDate
 * Type 	 : String
 * parameters: orderId,ProductStock
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@PostMapping("/exitDate/{id}")
public String updateExitDate(@PathVariable("id") String orderId, @RequestBody ProductStock productStock ) throws ProductStockException {
	
	if(productservice.doesProductOrderIdExist(orderId))
	{
		productservice.updateExitDateinStock(orderId, productStock.getExitDate());
		return "Data Inserted";
	}
	else
	{
	throw new ProductStockException("Orderid Does not exist");
	}
}
/*
 * This is a PostMethod is used to update the manfacturingDate,expiryDate,qualityCheck of the particular orderID in the database.
 * Method 	 : updateProductStockDetails
 * Type 	 : String
 * parameters: orderId,ProductStock
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@PostMapping("/updateDetails/{id}")
public String updateProductStockDetails(@PathVariable("id") String orderId, @RequestBody ProductStock productStock) throws ProductStockException {
	
	if(productservice.doesProductOrderIdExist(orderId))
	{
		productservice.updateProductStock(orderId, productStock.getManufacturingDate(),productStock.getExpiryDate(),productStock.getQualityCheck());
		return "Data Inserted";
	}
	else
	{
	throw new ProductStockException("Orderid Does not exist");
	}
}
/*
 * This is a GetMethod is used to get all ProductStock Details in the database.
 * Method 	 : getAllProductStock
 * Type 	 : List
 * parameters: 
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@GetMapping("/getproductstocks")
public ResponseEntity<List<ProductStock>> getAllProductStock( ) {
	List<ProductStock> ps = productservice.displayAll();
	return new ResponseEntity<List<ProductStock>>(ps, HttpStatus.OK);
}
/*
 * This is a DeleteMethod is used to Delete Particular Stock in the database.
 * Method 	 : deleteStock
 * Type 	 : String
 * parameters: orderId
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@DeleteMapping("/deleteStock/{id}")
public ResponseEntity<String> deleteStock(@PathVariable("id") String orderId) {
	
	String result=null;
	Boolean status = productservice.delete(orderId);
	if(status== true) {
		 result = "Stock deleted ";
		 return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	else {
		result = "Unsuccessfull";
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
/*
 * This is a PostMethod is used to add the stock in the database.
 * Method 	 : addStock
 * Type 	 : ProductStock
 * parameters: ProductStock
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@PostMapping("/addstock")
public ResponseEntity<ProductStock> addStock(@RequestBody ProductStock productstock) {

	ProductStock stock = productservice.addProductStock(productstock);

	return new ResponseEntity<ProductStock>(stock, HttpStatus.OK);
}
}
