package com.cg.ewallet.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.cg.ewallet.dto.CustomerDTO;
import com.cg.ewallet.entity.Customer;
import com.cg.ewallet.exception.CustomerInfoNotValid;
import com.cg.ewallet.exception.MobileNoNotValid;
import com.cg.ewallet.exception.NoPendingAccount;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.exception.UserNotFoundException;

public interface AccountService {
	
	
	//To Get the Customer Details based on there mobile number
	Customer getUserByMobileNumber(long mobileNo) throws UserNotFoundException, MobileNoNotValid;
	
	//For getting all the accont that are there in the database 
	List<Customer> getAllUser();
	
	
	//This method will give the list of account whose account creation detail is pending
		//method will throw a exception if there is no pending account.
	List<Customer> getAccountsToApprove() throws NoPendingAccount;
	
	
	//This method will approve the account of person based on there age 
	//method accept mobile number as argument
	//Will throw a exception user not found if no user in pending account have given mobile number
	String approveAccount(long mobileNo) throws UserNotFoundException,NoSuchAlgorithmException;
	
	
	
	//For Creating a new user account by getting Customer dto object
	String createCustomerAccount(CustomerDTO customer) throws UserExistsException,CustomerInfoNotValid;
	
	
	//Use to update the detail of user if there is any error in the user data
	String updatePersonalDetail(CustomerDTO customer) throws CustomerInfoNotValid;

}
