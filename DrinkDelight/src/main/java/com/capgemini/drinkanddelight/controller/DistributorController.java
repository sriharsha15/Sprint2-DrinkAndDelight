package com.capgemini.drinkanddelight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.drinkanddelight.entity.Distributor;
import com.capgemini.drinkanddelight.exception.DistributorException;
import com.capgemini.drinkanddelight.service.DistributorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
	
public class DistributorController 
{
	@Autowired
	private DistributorService distributorservice;
	/*
	 * This is a PostMethod is used to add the Distributor in the database.
	 * Method 	 : addDistributor
	 * Type 	 : ResponseEntity<Distributor>
	 * parameters: distributor
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@PostMapping("/distributor")
	public ResponseEntity<Distributor> addDistributor(@RequestBody Distributor distributor) {

		Distributor dist = distributorservice.addDistributor(distributor);

		return new ResponseEntity<Distributor>(dist, HttpStatus.OK);
	}
	/*
	 * This is a GetMethod is used to Display the DistributorDetails for particular distributorId in the database.
	 * Method 	 :  getDistributor
	 * Type 	 : ResponseEntity<Distributor>
	 * parameters: distributorId
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@GetMapping("/getdistributor/{id}")
	public ResponseEntity<Distributor> getDistributor(@PathVariable("id") String distributorId) throws DistributorException {
		
		if(distributorservice.distributorIDExist(distributorId))
		{
			Distributor status = distributorservice.display(distributorId);
			return new ResponseEntity<Distributor>(status, HttpStatus.OK);
		}
		else
			throw new DistributorException("Distributor not found.");
		
	}
	/*
	 * This is a GetMethod is used to Display all Distributor Details  in the database.
	 * Method 	 : getAllDistributor
	 * Type 	 : ResponseEntity<List<Distributor>>
	 * parameters: 
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@GetMapping("/getdistributors")
	public ResponseEntity<List<Distributor>> getAllDistributors( ) {
		List<Distributor> dist = distributorservice.displayAll();
		return new ResponseEntity<List<Distributor>>(dist, HttpStatus.OK);
	}
	/*
	 * This is a GetMethod is used to Update all Distributor Details  in the database.
	 * Method 	 : updateDistributor
	 * Type 	 : String
	 * parameters: Distributor
	 * Author 	 : Sriharsha
	 * Date 	 : 20/04/2020
	 */
	@GetMapping("/updateDistributor/{id}")
	public String updateDistributor(@PathVariable("id") String distributorId, @RequestBody Distributor distributor ) 
	{
		
	return	 distributorservice.updateDistributor(distributor.getDistributorid(), distributor.getName(),distributor.getAddress(),distributor.getPhone());
	
	}
}
