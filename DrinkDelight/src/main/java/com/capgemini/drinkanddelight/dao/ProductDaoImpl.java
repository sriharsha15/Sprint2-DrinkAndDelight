package com.capgemini.drinkanddelight.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.drinkanddelight.entity.ProductStock;

@Repository
public class ProductDaoImpl implements ProductDao
{
	@PersistenceContext
	EntityManager entitymanager;
	/*
	 * Description:This method is used to track the particular orderId in the database.
	 * MethodName: trackProductOrder
	 * Type 	 : String
	 * parameters: orderId
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public ProductStock trackProductOrder(String orderId) {
		// TODO Auto-generated method stub
		ProductStock productstock=entitymanager.find(ProductStock.class,orderId);
		return productstock;
	}
	/*
	 * Description:This method is used to update exitDate for particular orderId in the database.
	 * MethodName: updateExitDateinStock
	 * Type 	 : String
	 * parameters: orderId,exitDate
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public String updateExitDateinStock(String orderId, Date exitDate) {
		// TODO Auto-generated method stub
		ProductStock productstock=entitymanager.find(ProductStock.class,orderId);
		productstock.setExitDate(exitDate);
		return "Exit Date Inserted";
	}

	/*
	 * Description:This method is used to update manufacturingDate,expiryDate,qualityCheck for particular orderId in the database.
	 * MethodName: updateProductStock
	 * Type 	 : String
	 * parameters: orderId,manufacturingDate,expiryDate,qualityCheck
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public String updateProductStock(String orderId, Date manufacturingDate, Date expiryDate, String qualityCheck) {
		// TODO Auto-generated method stub
		ProductStock productstock=entitymanager.find(ProductStock.class,orderId);
		productstock.setManufacturingDate(manufacturingDate);
		productstock.setExpiryDate(expiryDate);
		productstock.setQualityCheck(qualityCheck);
		return "Details Inserted";
		
	}
	/*
	 * Description:This method is used to check orderID exist or not in ProductStock.
	 * MethodName: doesProductOrderIdExist
	 * Type 	 : boolean
	 * parameters: orderId
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean doesProductOrderIdExist(String orderId) {
		// TODO Auto-generated method stub
	 if(entitymanager.find(ProductStock.class,orderId)==null) 
	 {
		 return false;
	 }
	 else
		return true;
	}
	/*
	 * Description:This method is used to Display all ProductStock in database.
	 * MethodName: displayAll
	 * Type 	 : List<ProductStock>
	 * parameters: 
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
public List<ProductStock> displayAll() {
		
		String Qstr = "SELECT productstock FROM ProductStock productstock";
		TypedQuery<ProductStock> query = entitymanager.createQuery(Qstr, ProductStock.class);
		return query.getResultList();	
}
/*
 * Description:This method is used to delete stock  in database.
 * MethodName: delete
 * Type 	 : boolean
 * parameters: orderId
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@Override
public boolean delete(String orderId) {
	// TODO Auto-generated method stub
	ProductStock productstock=entitymanager.find(ProductStock.class, orderId);
	
	if(orderId==productstock.getOrderId()) {
	
		entitymanager.remove(entitymanager.find(ProductStock.class, orderId));
		return true;
	}
	else {
		return false;
	}


}
/*
 * Description:This method is used to add stock  in database.
 * MethodName: addProductStock
 * Type 	 : ProductStock
 * parameters: ProductStock
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
@Override
public ProductStock addProductStock(ProductStock productstock) {
	// TODO Auto-generated method stub
	entitymanager.persist(productstock);
	return productstock;
}

}
