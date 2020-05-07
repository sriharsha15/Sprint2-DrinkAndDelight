package com.capgemini.drinkanddelight.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drinkanddelight.dao.DistributorDao;
import com.capgemini.drinkanddelight.entity.Distributor;

@Transactional
@Service
public class DistributorServiceImpl implements DistributorService
{
@Autowired
private DistributorDao distributordao;
/*
 * Description:This method is used to Add Distributor in the database.
 * MethodName: addDistributor
 * Type 	 : Distributor
 * parameters: distributor
 * Author 	 : Sriharsha
 * Date 	 : 20/04/2020
 */
	@Override
	public Distributor addDistributor(Distributor distributor) {
		// TODO Auto-generated method stub
		
		return distributordao.addDistributor(distributor);
	}
	/*
	 * Description:This method is used to Dispaly Distributor for particular distributorId in the database.
	 * MethodName: display
	 * Type 	 : String
	 * parameters: distributorId
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public Distributor display(String distributorId) {
		// TODO Auto-generated method stub
		
		return distributordao.display(distributorId);
	}
	/*
	 * Description:This method is used to Dispaly all Distributors in the database.
	 * MethodName: displayAll
	 * Type 	 : List<Distributor>
	 * parameters: 
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	public List<Distributor> displayAll() {
		// TODO Auto-generated method stub
		
		return distributordao.displayAll();
	}
	/*
	 * Description:This method is used to check for particular distributorId exist or not in the database.
	 * MethodName: distributorIDExist
	 * Type 	 : boolean
	 * parameters: distributorId
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public boolean distributorIDExist(String distributorId) {
		// TODO Auto-generated method stub
		return distributordao.distributorIDExist(distributorId);
	}
	/*
	 * Description:This method is used to update Distributor in the database.
	 * MethodName: updateDistributor
	 * Type 	 : String
	 * parameters: Distributor
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@Override
	public String updateDistributor(String distributorid, String name, String address, String phone) {
		// TODO Auto-generated method stub
		return distributordao.updateDistributor(distributorid, name, address, phone);
	}


}
