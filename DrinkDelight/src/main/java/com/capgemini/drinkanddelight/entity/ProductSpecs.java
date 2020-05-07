package com.capgemini.drinkanddelight.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
public class ProductSpecs {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productOrderId_sequence")
//	@SequenceGenerator(sequenceName = "productOrderId_sequence", allocationSize = 1, name = "productOrderId_sequence")
	private String productId;
	
	private String name;
	private float quantityValue;
	private String quantityUnit;
	private double pricePerUnit;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(float quantityValue) {
		this.quantityValue = quantityValue;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	@Override
	public String toString() {
		return "ProductSpecs [productId=" + productId + ", name=" + name + ", quantityValue=" + quantityValue
				+ ", quantityUnit=" + quantityUnit + ", pricePerUnit=" + pricePerUnit + "]";
	}
	public ProductSpecs(String productId, String name, float quantityValue, String quantityUnit, double pricePerUnit) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.pricePerUnit = pricePerUnit;
	}
	public ProductSpecs() {
		super();
	}
	
	

}
