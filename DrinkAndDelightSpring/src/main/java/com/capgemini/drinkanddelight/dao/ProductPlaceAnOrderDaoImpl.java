package com.capgemini.drinkanddelight.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.drinkanddelight.entity.PlaceOrder;
import com.capgemini.drinkanddelight.entity.ProductSpecs;

@Transactional
@Repository
public class ProductPlaceAnOrderDaoImpl implements ProductPlaceAnOrderDao {

	@PersistenceContext
	private EntityManager entityManager;

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
		entityManager.persist(productSpecs);
		return true;
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
		String getAllProducts = "SELECT product_specs FROM ProductSpecs product_specs";
		TypedQuery<ProductSpecs> query = entityManager.createQuery(getAllProducts, ProductSpecs.class);
		return query.getResultList();
	}

	/*
	 * This method is used to Place An Order and add details in PlaceOrder Table and update details in ProductSpec Table. 
	 * Method : placeAnOrder 
	 * Type : Boolean
	 * parameters: productOrder 
	 * Author : Murali Krishna 
	 * Date : 21/04/2020
	 */

	@Override
	public boolean placeAnOrder(PlaceOrder productOrder) {
		// TODO Auto-generated method stub

		// Calculating Total Price
		double totalPrice = productOrder.getQuantityUnit() * productOrder.getPricePerUnit();

		// Getting dateOfOrder as System Current date and dateOfDelivery as System
		// Current date plus(+) 14 days
		LocalDate dateOfOrder = LocalDate.now();
		LocalDate dateOfDelivery = dateOfOrder.plusDays(14);

		String deliveryStatus = "Reviewing";

		String Qstr = "SELECT product_specs FROM ProductSpecs product_specs";
		TypedQuery<ProductSpecs> query = entityManager.createQuery(Qstr, ProductSpecs.class);
		boolean flag = true;
		int length = query.getResultList().size();
		for (int loop = 0; loop < length; loop++) {
			if (query.getResultList().get(loop).getName().contentEquals(productOrder.getName())
					&& productOrder.getQuantityUnit() <= query.getResultList().get(loop).getQuantityUnit()
					&& productOrder.getQuantityValue() <= query.getResultList().get(loop).getQuantityValue()
					&& productOrder.getPricePerUnit() == query.getResultList().get(loop).getPricePerUnit()) {
				int orderId = query.getResultList().get(loop).getProductId();
				ProductSpecs productSpec = entityManager.find(ProductSpecs.class, orderId);

				double quantityUnit = productSpec.getQuantityUnit() - productOrder.getQuantityUnit();
				double quantityValue = productSpec.getQuantityValue() - productOrder.getQuantityValue();

				productSpec.setQuantityUnit(quantityUnit);
				productSpec.setQuantityValue(quantityValue);

				entityManager.persist(productOrder);

				// Setting values to ProductOrder Table
				productOrder.setTotalPrice(totalPrice);
				productOrder.setDateOfOrder(dateOfOrder);
				productOrder.setDateOfDelivery(dateOfDelivery);
				productOrder.setDeliveryStatus(deliveryStatus);

				flag = true;
				break;
			} else {
				flag = false;
			}
		}

		return flag;
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
		String productOrderedList = "SELECT product_place_order FROM PlaceOrder product_place_order";
		TypedQuery<PlaceOrder> query = entityManager.createQuery(productOrderedList, PlaceOrder.class);
		return query.getResultList();
	}

	/*
	 * This method is used to Cancel An Order and remove order details in PlaceOrder Table and update details in ProductSpec Table 
	 * Method : cancelAnOrder 
	 * Type : Boolean 
	 * parameters: productId 
	 * Author : Murali Krishna 
	 * Date : 21/04/2020
	 */

	@Override
	public Boolean cancelAnOrder(int productId) {
		// TODO Auto-generated method stub
		PlaceOrder productOrder = entityManager.find(PlaceOrder.class, productId);
		String productName = productOrder.getName();

		String Qstr = "SELECT product_specs FROM ProductSpecs product_specs WHERE product_specs.name = :name";
		TypedQuery<ProductSpecs> query = entityManager.createQuery(Qstr, ProductSpecs.class);
		List<ProductSpecs> productList = query.setParameter("name", productName).getResultList();

		int orderId = productList.get(0).getProductId();
		ProductSpecs productSpecs = entityManager.find(ProductSpecs.class, orderId);

		double quantityUnit = productSpecs.getQuantityUnit() + productOrder.getQuantityUnit();
		double quantityValue = productSpecs.getQuantityValue() + productOrder.getQuantityValue();

		entityManager.remove(productOrder);

		productSpecs.setQuantityUnit(quantityUnit);
		productSpecs.setQuantityValue(quantityValue);

		return true;
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
		if (entityManager.find(PlaceOrder.class, orderId) != null) {
			return true;
		} else {
			return false;
		}
	}

}
