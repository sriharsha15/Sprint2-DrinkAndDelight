package com.capgemini.drinkanddelight.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductStock {
	
	@Id
	private String orderId;
	private String name;
	private String distributorId;
	private double pricePerUnit;
	private double quantityValue;
	private String quantityUnit;
	private long price;
	private String warehouseId;
	private Date deliveryDate;
	private Date manufacturingDate;
	private Date expiryDate;
	private String qualityCheck;
	private Date exitDate;
	
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public Date getExitDate() {
		return exitDate;
	}
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}
	
	
	
	@Override
	public String toString() {
		return "ProductStock [orderId=" + orderId + ", name=" + name + ", distributorId=" + distributorId
				+ ", pricePerUnit=" + pricePerUnit + ", quantityValue=" + quantityValue + ", quantityUnit="
				+ quantityUnit + ", price=" + price + ", warehouseId=" + warehouseId + ", deliveryDate=" + deliveryDate
				+ ", manufacturingDate=" + manufacturingDate + ", expiryDate=" + expiryDate + ", qualityCheck="
				+ qualityCheck + ", exitDate=" + exitDate + "]";
	}
	
	
	
	public ProductStock(String orderId, String name, String distributorId, double pricePerUnit, double quantityValue,
			String quantityUnit, long price, String warehouseId, Date deliveryDate, Date manufacturingDate,
			Date expiryDate, String qualityCheck, Date exitDate) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.distributorId = distributorId;
		this.pricePerUnit = pricePerUnit;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.price = price;
		this.warehouseId = warehouseId;
		this.deliveryDate = deliveryDate;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.qualityCheck = qualityCheck;
		this.exitDate = exitDate;
	}
	
	
	
	public ProductStock() {
		super();
	}
	
}
