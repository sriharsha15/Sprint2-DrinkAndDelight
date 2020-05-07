package com.capgemini.drinkanddelight.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drinkanddelight.dao.ProductPlaceAnOrderDao;
import com.capgemini.drinkanddelight.entity.PlaceOrder;
import com.capgemini.drinkanddelight.entity.ProductSpecs;

@Transactional
@Service
public class ProductPlaceAnOrderServiceImpl implements ProductPlaceAnOrderService {

	@Autowired
	private ProductPlaceAnOrderDao placeAnOrderDao;

	/*
	 * This method is used to add ProductSpecification Details into the ProductSpecs Table. 
	 * Method : addProductSpecs 
	 * Type : Boolean 
	 * parameters: productSpecs
	 * Author : Murali Krishna 
	 * Date : 20/04/2020
	 */
	
	@Override
	public boolean addProductSpecs(ProductSpecs productSpecs) {
		// TODO Auto-generated method stub

		return placeAnOrderDao.addProductSpecs(productSpecs);

	}

	/*
	 * This method is used to getProductSpecs from the ProductSpecs Table. 
	 * Method : getAllProductSpecs 
	 * Type : List 
	 * parameters: 
	 * Author : Murali Krishna 
	 * Date : 19/04/2020
	 */
	
	@Override
	public List<ProductSpecs> getAllProductSpecs() {
		// TODO Auto-generated method stub
		List<ProductSpecs> list = placeAnOrderDao.getAllProductSpecs();
		return list;
	}

	/*
	 * This method is used to Place An Order
	 * Method : placeAnOrder 
	 * Type : Boolean
	 * parameters: productOrder 
	 * Author : Murali Krishna 
	 * Date : 21/04/2020
	 */
	
	@Override
	public boolean productPlaceOrder(PlaceOrder productOrder) {
		// TODO Auto-generated method stub

		return placeAnOrderDao.placeAnOrder(productOrder);

	}
	
	/*
	 * This method is used to getProductOrderedList from the PlaceOrder Table.
	 * Method : getProductOrderedList 
	 * Type : List 
	 * parameters: 
	 * Author : Murali Krishna
	 * Date : 19/04/2020
	 */
	
	@Override
	public List<PlaceOrder> getProductOrderedList() {
		// TODO Auto-generated method stub
		List<PlaceOrder> productList = placeAnOrderDao.getProductOrderedList();
		return productList;
	}

	/*
	 * This method is used to Cancel An Order
	 * Method : cancelAnOrder 
	 * Type : Boolean 
	 * parameters: productId 
	 * Author : Murali Krishna 
	 * Date : 21/04/2020
	 */
	
	@Override
	public boolean productCancelOrder(int productId) {
		// TODO Auto-generated method stub
		return placeAnOrderDao.cancelAnOrder(productId);

	}

	/*
	 * This method is used to check Weather orderId is Exist or Not. 
	 * Method : orderIdExists 
	 * Type : boolean 
	 * parameters: orderId 
	 * Author : Murali Krishna 
	 * Date : 20/04/2020
	 */
	
	@Override
	public boolean orderIdExists(int orderId) {
		// TODO Auto-generated method stub
		return placeAnOrderDao.orderIdExists(orderId);
	}

}
