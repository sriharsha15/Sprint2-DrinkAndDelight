package com.capgemini.drinkanddelight.service;

import java.util.List;

import com.capgemini.drinkanddelight.entity.Distributor;

public interface DistributorService 
{
	public Distributor addDistributor(Distributor distributor);
	public Distributor display(String distributorId);
	public List<Distributor> displayAll();
	public boolean distributorIDExist(String distributorId);
	public String updateDistributor( String distributorid, String name,String address,String phone);
}
