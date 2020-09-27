package com.cg.ewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.dto.Customer;
import com.cg.ewallet.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

@RestController
@RequestMapping(value="/")
//,produces="text/plain"
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class Controller {

	@GetMapping("/")
	public String Home()
	{
		return  "Home Page For AccountService";
	}

	Logger log=LoggerFactory.getLogger(Controller.class);

	//	public Controller() {
	//		super();
	//		PropertyConfigurator.configure("controller.properties");
	//	}


	@Autowired(required=true)
	AccountService accService;


	@PostMapping(value="/newcustomer")
	public ResponseEntity<String> createCustomerAccount(@RequestBody Customer customer)
	{
		String toBeReturned= accService.createCustomerAccount(customer);
		log.info("Creating New Account");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Bad request");	
		}
		return new ResponseEntity<String>(toBeReturned,HttpStatus.OK);
	}
	
	@GetMapping("/getcustomerbymobile/{mobileno}")
	public ResponseEntity<Customer> getCustomerByMobileNumber(@PathVariable long mobileno)
	{
		Customer customer=accService.getUserByMobileNumber(mobileno);
		log.info("Get Detail by mobile number");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Bad request");
		}
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

	@GetMapping("/getallcustomer")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		
		List<Customer> customers=accService.getAllUser();
		log.info("Get Detail of all user");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Bad request");
		}
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/getaccounttoapprove")
	public ResponseEntity<List<Customer>> getAccountToApprove()
	{
		
		List<Customer> customers=accService.getAccountsToApprove();
		log.info("Get All account deatil that are pending");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Bad request");
		}
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/approveaccount/{mobileno}")
	public ResponseEntity<String> approveAccount(@PathVariable long mobileno)
	{
		String accountstatusmsg=accService.approveAccount(mobileno);
		log.info("Account with "+mobileno+" is requested for approval");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Bad request");
		}
		return new ResponseEntity<String>(accountstatusmsg,HttpStatus.OK);
	}
	
	@PostMapping(value="/updatedetail")
	public ResponseEntity<String> updateDetail(@RequestBody Customer customer)
	{
		String updateMessage= accService.updatePersonalDetail(customer);
		log.info("Updating Detail of "+customer.getCustName());
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Bad request");	
		}
		return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
	}






}

