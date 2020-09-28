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
import com.cg.ewallet.exception.NoPendingAccount;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.exception.UserNotFoundException;
import com.cg.ewallet.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class Controller {

	@GetMapping("/")
	public String homePage()
	{
		return  "Home Page For AccountService";
	}

	Logger log=LoggerFactory.getLogger(Controller.class);


	@Autowired(required=true)
	AccountService accService;


	@PostMapping(value="/newcustomer")
	public ResponseEntity<String> createCustomerAccount(@RequestBody Customer customer)
	{
		String accountCreationMessage="";
		try
		{
		    accountCreationMessage= accService.createCustomerAccount(customer);
		}catch(UserExistsException ex) {
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
		log.info("Creating New Account");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Not a Proper Request");	
		}
		return new ResponseEntity<String>(accountCreationMessage,HttpStatus.OK);
	}
	
	
	@GetMapping("/getcustomerbymobile/{mobileno}")
	public ResponseEntity<Customer> getCustomerByMobileNumber(@PathVariable long mobileno) throws UserNotFoundException
	{
		Customer customer = null;
		try {
			customer = accService.getUserByMobileNumber(mobileno);
		} catch (UserNotFoundException e) {
			//return new ResponseEntity<Customer>(customer,HttpStatus.BAD_REQUEST);
			throw new UserNotFoundException(e.getMessage());
		}
		log.info("Get Detail by mobile number");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Get Detail By mobile number failed");
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
			log.warn("Getting all user deatil failed");
		}
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/getaccounttoapprove")
	public ResponseEntity<List<Customer>> getAccountToApprove() throws NoPendingAccount
	{
		
		List<Customer> customers=null;
		try
		{
			customers=accService.getAccountsToApprove();
		}
		catch(NoPendingAccount ex)
		{
			throw new NoPendingAccount(ex.getMessage());
		}
		log.info("Get All account deatil that are pending");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("All pending accont getting is failed");
		}
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/approveaccount/{mobileNo}")
	public ResponseEntity<String> approveAccount(@PathVariable long mobileNo) throws UserNotFoundException
	{
		String accountstatusmsg=null;
		try
		{
			accountstatusmsg=accService.approveAccount(mobileNo);
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException(e.getMessage());
		}
		
		log.info("Account with is requested for approval");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Approve Account Failed");
		}
		return new ResponseEntity<String>(accountstatusmsg,HttpStatus.OK);
	}
	
	@PostMapping(value="/updatedetail")
	public ResponseEntity<String> updateDetail(@RequestBody Customer customer)
	{
		String updateMessage= accService.updatePersonalDetail(customer);
		log.info("Updating Detail ");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Updating Detail Failed");	
		}
		return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
	}






}

