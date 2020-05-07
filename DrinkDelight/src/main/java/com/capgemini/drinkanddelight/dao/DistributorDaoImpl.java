package com.capgemini.drinkanddelight.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.drinkanddelight.entity.Distributor;
@Repository
public class DistributorDaoImpl implements DistributorDao
{
	@PersistenceContext
	EntityManager entityManager;
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
		entityManager.persist(distributor);
		return distributor;
		
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
		Distributor distributor = entityManager.find(Distributor.class, distributorId);
		return distributor;
		

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
		
		String Qstr = "SELECT distributor FROM Distributor distributor";
		TypedQuery<Distributor> query = entityManager.createQuery(Qstr, Distributor.class);
		return query.getResultList();	
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
		if(entityManager.find(Distributor.class, distributorId)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
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
	public String updateDistributor( String distributorid, String name,String address,String phone) {
		// TODO Auto-generated method stub
		Distributor distributor=entityManager.find(Distributor.class,distributorid);
		distributor.setName(name);
	    distributor.setAddress(address);
		distributor.setPhoneNumber(phone);
		return "Details Updated";
		
	}
	
}
