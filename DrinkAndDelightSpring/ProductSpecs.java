package com.capgemini.drinkanddelight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
public class ProductSpecs {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSpec_sequence")
	@SequenceGenerator(sequenceName = "productSpec_sequence", allocationSize = 1, name = "productSpec_sequence")
	private int productId;
	
	private String name;
	private double quantityValue;
	private double quantityUnit;
	private double pricePerUnit;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}
	public double getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(double quantityUnit) {
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
	public ProductSpecs(int productId, String name, double quantityValue, double quantityUnit, double pricePerUnit) {
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
