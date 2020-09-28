package com.cg.ewallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ewallet.dao.AccountDao;
import com.cg.ewallet.dao.CustomerDao;
import com.cg.ewallet.dto.Account;
import com.cg.ewallet.dto.Customer;
import com.cg.ewallet.exception.NoPendingAccount;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.exception.UserNotFoundException;
import com.cg.ewallet.validation.EwalletValidation;


@Service
public class AccountServiceImpl implements AccountService {
	
	
	
	@Autowired(required = true)
	CustomerDao custDao;
	@Autowired(required = true)
	AccountDao accountDao;
	@Autowired(required = true)
	EwalletValidation ewalletValidation;
	
	@Override
	public String createCustomerAccount(Customer customer) throws UserExistsException  {
	
		
		List<Customer> customers = custDao.findAll();
		int flag=0;

		for(Customer cust:customers){
			if(cust.getPhoneNo()==customer.getPhoneNo())
			{
			flag=1;
			break;
			}
		}
		
		if(flag==1)
		{
			throw new UserExistsException("User With this mobile number already Exist");
		}
		else
		{
			custDao.save(customer);
			return "Account Detail sucessfully submitted"; 
		}
	}



	@Override
	public List<Customer> getAllUser() {
	
		return custDao.findAll();
	}
	

	@Override
	public Customer getUserByMobileNumber(long mobileNo) throws UserNotFoundException {
		
		  Customer customer = null;
		  List<Customer> allCustList = custDao.findAll();
		  
		  for(Customer cust:allCustList) {
			  if(cust.getPhoneNo()==mobileNo) {
				  System.out.println(cust);
				  customer= cust;
				  break;
			  }}
		  
		  if(customer==null)
		  {
			  throw new UserNotFoundException("User with "+mobileNo+" Not Found");
		  }
		  
		  return customer;
		
	}

	@Override
	public List<Customer> getAccountsToApprove() throws NoPendingAccount{
		
		List<Customer> pendingAccounts= new ArrayList<Customer>();
		List<Customer> accounts = custDao.findAll();
		for(Customer acc:accounts) {
			if((acc.getAccountStatus().equalsIgnoreCase("pending")))
			{
				pendingAccounts.add(acc);
			}
		}
		if(pendingAccounts.size()==0)
		{
			throw new NoPendingAccount("No pending Account");
		}
		else
		return pendingAccounts;
	}

	@Override
	public String approveAccount(long mobileNo) throws UserNotFoundException {
		
		List<Customer> accounts = custDao.findAll();
		int flag=0;
		for(Customer acc:accounts) {
			if(acc.getPhoneNo()==mobileNo)
			{
			if((acc.getAccountStatus().equalsIgnoreCase("pending")))
			{
				if(acc.getAge()>18)
				{
					acc.setAccountStatus("approved");
					Account account=new Account(mobileNo);
					accountDao.save(account);
					flag=1;
					break;
				}
				else
				{
					acc.setAccountStatus("rejected");
					flag=2;
		            break;
				}
			}
			}
		}
		if(flag==0)
		{
			throw new UserNotFoundException("Account with mobile number"+mobileNo+" not found");
		}
		else if(flag==1)
		{
			return "Account is approved";
		}
		else
		{
			return "Account is rejected";
		}	
	}
	
	@Override
	public String updatePersonalDetail(Customer customer) {
		
		  int flag=0;
		  List<Customer> allCustList = custDao.findAll();
		  
		  for(Customer cust:allCustList) {
			  if(cust.getPhoneNo()==customer.getPhoneNo()) {
				  flag=1;
				  break;
			  }}
		  
		  if(flag==0)
		  {
			 return "User with Detail "+customer.getPhoneNo()+" Not Found";
		  }
		  else
		  {
			  custDao.saveAndFlush(customer);
			  return "Personal detail sucessfully updated for "+customer.getCustName();
		  }

		
	}
		
	

}