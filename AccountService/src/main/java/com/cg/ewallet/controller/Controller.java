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

import com.cg.ewallet.dto.CustomerDTO;
import com.cg.ewallet.dto.Message;
import com.cg.ewallet.entity.Customer;
import com.cg.ewallet.exception.CustomerInfoNotValid;
import com.cg.ewallet.exception.MobileNoNotValid;
import com.cg.ewallet.exception.NoPendingAccount;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.exception.UserNotFoundException;
import com.cg.ewallet.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class Controller {

	
	//This Method will Show the given test when you hit
	//localhost:portnumber
	@GetMapping("/")
	public String homePage()
	{
		return  "Home Page For AccountService";
	}

	Logger log=LoggerFactory.getLogger(Controller.class);


	@Autowired(required=true)
	AccountService accService;


	//For Creating a new user account by getting Customer dto object
	@PostMapping(value="/newcustomer")
	public ResponseEntity<Message> createCustomerAccount(@RequestBody CustomerDTO customer)
	{
		String accountCreationMessage="";
		try
		{
		    accountCreationMessage= accService.createCustomerAccount(customer);
		}catch(Exception ex) {
			//Throw an exception when user with mobilenumber already exist on db
			return new ResponseEntity<>(new Message(ex.getMessage()),HttpStatus.BAD_REQUEST);
		}
		log.info("Creating New Account");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Not a Proper Request");	
		}
		return new ResponseEntity<>(new Message(accountCreationMessage),HttpStatus.OK);
	} 
	 
	 
	//To Get the Customer Details based on there mobile number
	@GetMapping("/getcustomerbymobile/{mobileno}")
	public ResponseEntity<Customer> getCustomerByMobileNumber(@PathVariable long mobileno) throws UserNotFoundException, MobileNoNotValid
	{
		Customer customer = null;
		try {
			customer = accService.getUserByMobileNumber(mobileno);
		} catch (UserNotFoundException e) {
           //wILL throw this exception if database doesnot have any 
			//user with given mobile number
			throw new UserNotFoundException(e.getMessage());
		}
		log.info("Get Detail by mobile number");
		if(HttpStatus.BAD_REQUEST==null)
		{
			//Will log this message if there is a bad request
			log.warn("Get Detail By mobile number failed");
		}
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}

	
	
	//For getting all the accont that are there in the database 
	@GetMapping("/getallcustomer")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		
		List<Customer> customers=accService.getAllUser();
		log.info("Get Detail of all user");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Getting all user deatil failed");
		}
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	
	
	//This method will give the list of account whose account creation detail is pending
	//method will throw a exception if there is no pending account.
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
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	
	
	
	//This method will approve the account of person based on there age 
	//method accept mobile number as argument
	//Will throw a exception user not found if no user in pending account have given mobile number
	@GetMapping("/approveaccount/{mobileNo}")
	public ResponseEntity<Message> approveAccount(@PathVariable long mobileNo) throws UserNotFoundException, NoSuchAlgorithmException
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
		return new ResponseEntity<>(new Message(accountstatusmsg),HttpStatus.OK);
	}
	
	
	
	//Use to update the detail of user if there is any error in the user data
	@PostMapping(value="/updatedetail")
	public ResponseEntity<Message> updateDetail(@RequestBody CustomerDTO customer) throws CustomerInfoNotValid
	{
		String updateMessage= accService.updatePersonalDetail(customer);
		log.info("Updating Detail ");
		if(HttpStatus.BAD_REQUEST==null)
		{
			log.warn("Updating Detail Failed");	
		}
		return new ResponseEntity<>(new Message(updateMessage),HttpStatus.OK);
	}






}

