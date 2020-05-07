package com.capgemini.drinkanddelight.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drinkanddelight.dao.ProductDao;
import com.capgemini.drinkanddelight.entity.ProductStock;
import com.capgemini.drinkanddelight.exception.ProductStockException;
@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
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
		return productDao.trackProductOrder(orderId);
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
	public String updateExitDateinStock(String orderId, Date exitDate) throws ProductStockException {
		// TODO Auto-generated method stub
		if(exitDateCheck(exitDate))
		{
			return productDao.updateExitDateinStock(orderId, exitDate);
		}
		else
			
		return "null";
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
	public String updateProductStock(String orderId, Date manufacturingDate, Date expiryDate, String qualityCheck) throws ProductStockException {
		// TODO Auto-generated method stub
		if(validateManfacturingDate( manufacturingDate) && validateExpiryDate( manufacturingDate,expiryDate))
		{
			return productDao.updateProductStock(orderId, manufacturingDate, expiryDate, qualityCheck);
		}
		else
		{
		return "null";
		}
	}
	/*
	 * Description:This method is used to Validate Date enter by User.
	 * MethodName: exitDateCheck
	 * Type 	 : boolean
	 * parameters: exitDate
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean exitDateCheck(Date exitDate) throws ProductStockException {
		// TODO Auto-generated method stub
		if(exitDate==null)
	      {
			return false;
	      }
	    	  LocalDate date = exitDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	          LocalDate current = LocalDate.now();
	          if( date.isAfter(current))
	          {
	        	  return true;
	          }
	          else
	          {
	        	  throw new ProductStockException("Not a valid date");
	          }
	}
	/*
	 * Description:This method is used to Validate manfacturingDate enter by User.
	 * MethodName: validateManfacturingDate
	 * Type 	 : boolean
	 * parameters: manfacturingDate
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean validateManfacturingDate(Date manufacturingDate) throws ProductStockException {
		// TODO Auto-generated method stub
		if(manufacturingDate==null)
	      {
			return false;
	      }
	          
	    	  LocalDate date = manufacturingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	          LocalDate current = LocalDate.now();
	          if( date.isBefore(current))
	          {
	        	  return true;
	          }
	          else
	          {
	        	  throw new ProductStockException("Not a valid date");
	          }
		
	}
	/*
	 * Description:This method is used to Validate expiryDate  enter by User.
	 * MethodName: validateExpiryDate
	 * Type 	 : boolean
	 * parameters: manfacturingDate,expiryDate
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean validateExpiryDate(Date manufacturingDate, Date expiryDate) throws ProductStockException {
		// TODO Auto-generated method stub
		if(manufacturingDate==null || expiryDate==null)
	      {
			return false;
	      } 
	
	          
	    	  LocalDate date1 = manufacturingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	          LocalDate date2 = expiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	          if( date2.isAfter(date1))
	          {
	        	  return true;
	          }
	          else
	          {
	        	  throw new ProductStockException("Not a valid date");
	          }
		 
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
		return productDao.doesProductOrderIdExist(orderId);
	}
	/*
	 * Description:This method is used to Display all ProductStock in database.
	 * MethodName: displayAll
	 * Type 	 : List<ProductStock>
	 * parameters: 
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public List<ProductStock> displayAll() {
		// TODO Auto-generated method stub
		return productDao.displayAll();
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
		return productDao.delete(orderId);
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
	   
		return  productDao.addProductStock(productstock);
	}

}
