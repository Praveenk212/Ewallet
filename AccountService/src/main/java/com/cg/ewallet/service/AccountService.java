package com.cg.ewallet.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.cg.ewallet.dto.CustomerDTO;
import com.cg.ewallet.entity.Customer;
import com.cg.ewallet.exception.NoPendingAccount;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.exception.UserNotFoundException;

public interface AccountService {
	

	Customer getUserByMobileNumber(long mobileNo) throws UserNotFoundException;
	List<Customer> getAllUser();
	
	List<Customer> getAccountsToApprove() throws NoPendingAccount;
	
	String approveAccount(long mobileNo) throws UserNotFoundException,NoSuchAlgorithmException;
	
	
	String createCustomerAccount(CustomerDTO customer) throws UserExistsException;
	
	String updatePersonalDetail(CustomerDTO customer);

}
