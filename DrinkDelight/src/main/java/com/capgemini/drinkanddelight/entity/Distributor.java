package com.capgemini.drinkanddelight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Distributor {
	@Id
	private String distributorid;
	private String name;
	private String address;
	@Column(length=10)
	private String phone;
	public String getDistributorid() {
		return distributorid;
	}
	public void setDistributorid(String distributorid) {
		this.distributorid = distributorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhoneNumber(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Distributor [distributorId=" + distributorid + ", name=" + name + ", Address=" + address
				+ ", phoneNumber=" + phone + "]";
	}
	
	
}
