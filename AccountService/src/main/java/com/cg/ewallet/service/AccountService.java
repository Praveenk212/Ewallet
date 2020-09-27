package com.cg.ewallet.service;

import java.util.List;

import com.cg.ewallet.dto.Customer;

public interface AccountService {
	

	Customer getUserByMobileNumber(long mobileNo);
	List<Customer> getAllUser();
	
	List<Customer> getAccountsToApprove();
	
	String approveAccount(long mobileNo);
	
	
	String createCustomerAccount(Customer customer);
	
	String updatePersonalDetail(Customer customer);

}
