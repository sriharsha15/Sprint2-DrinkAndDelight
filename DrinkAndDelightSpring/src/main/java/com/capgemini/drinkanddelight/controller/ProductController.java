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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.drinkanddelight.entity.PlaceOrder;
import com.capgemini.drinkanddelight.entity.ProductSpecs;
import com.capgemini.drinkanddelight.exception.PlaceAnOrderException;
import com.capgemini.drinkanddelight.exception.ProductOrderIdException;
import com.capgemini.drinkanddelight.service.ProductPlaceAnOrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sprint2")
public class ProductController {

	@Autowired
	private ProductPlaceAnOrderService PlaceAnOrderService;

	// Add Products to Specification Table
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProductSpec(@RequestBody ProductSpecs productSpecs){
		String specResult = null;
		boolean specStatus = PlaceAnOrderService.addProductSpecs(productSpecs);
		if (specStatus == true) {
			specResult = "Product Added Successfully";
		} else {
			specResult = "Unsuccessfull While Adding Product";
		}
		return new ResponseEntity<String>(specResult, HttpStatus.OK);
	}

	// Get All Products
	@GetMapping("/GetProductDetails")
	public ResponseEntity<List<ProductSpecs>> getProductlist() {
		List<ProductSpecs> productList = PlaceAnOrderService.getAllProductSpecs();
		return new ResponseEntity<List<ProductSpecs>>(productList, HttpStatus.OK);
	}

	// Place An Order
	@PostMapping("/placeProductOrder")
	public ResponseEntity<String> addProductOrder(@RequestBody PlaceOrder productOrder) throws PlaceAnOrderException {
		String placeResult = null;
		boolean placeStatus = PlaceAnOrderService.productPlaceOrder(productOrder);
		if (placeStatus == true) {
			placeResult = "Order Placed Successfully";
			return new ResponseEntity<String>(placeResult, HttpStatus.OK);
		} else {
			placeResult = "Unsuccessfull While Placing An Order";
			throw new PlaceAnOrderException("Unsuccessfull While Placing An Order");
		}

	}

	// Get All Placed Orders
	@GetMapping("/GetOrderedDetails")
	public ResponseEntity<List<PlaceOrder>> getOrderedList() {
		List<PlaceOrder> list = PlaceAnOrderService.getProductOrderedList();
		return new ResponseEntity<List<PlaceOrder>>(list, HttpStatus.OK);
	}

	// Cancel An Order by orderId
	@DeleteMapping("/cancelProductOrder/{id}")
	public ResponseEntity<Boolean> deleteProductOrder(@PathVariable("id") int orderId) throws ProductOrderIdException {
		if (PlaceAnOrderService.orderIdExists(orderId)) {
			Boolean status = PlaceAnOrderService.productCancelOrder(orderId);
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		} else {
			throw new ProductOrderIdException("Placed Order Id Does Not Exist");
		}

	}
}