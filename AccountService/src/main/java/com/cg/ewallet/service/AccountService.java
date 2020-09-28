package com.cg.ewallet.service;

import java.util.List;

import com.cg.ewallet.dto.Customer;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.exception.UserNotFoundException;

public interface AccountService {
	

	Customer getUserByMobileNumber(long mobileNo) throws UserNotFoundException;
	List<Customer> getAllUser();
	
	List<Customer> getAccountsToApprove();
	
	String approveAccount(long mobileNo);
	
	
	String createCustomerAccount(Customer customer) throws UserExistsException;
	
	String updatePersonalDetail(Customer customer);

}
