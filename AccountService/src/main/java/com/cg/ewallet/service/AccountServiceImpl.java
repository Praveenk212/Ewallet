package com.cg.ewallet.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ewallet.dao.AccountDao;
import com.cg.ewallet.dao.CustomerDao;
import com.cg.ewallet.dto.CustomerDTO;
import com.cg.ewallet.entity.Account;
import com.cg.ewallet.entity.Customer;
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
	public String createCustomerAccount(CustomerDTO customer) throws UserExistsException  {


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
			custDao.save(new Customer(customer.getPhoneNo(), customer.getPassword(), customer.getCustName(), customer.getAge(),
					customer.getGender(), customer.getEmailId()));
			return "Account Detail sucessfully submitted"; 
		}
	}


	//For getting all the accont that are there in the database 
	@Override
	public List<Customer> getAllUser() {

		return custDao.findAll();
	}


	
	
	//To Get the Customer Details based on there mobile number
	@Override
	public Customer getUserByMobileNumber(long mobileNo) throws UserNotFoundException {

		Customer customer = null;
		List<Customer> allCustList = custDao.findAll();

		for(Customer cust:allCustList) {
			if(cust.getPhoneNo()==mobileNo) {
				customer= cust;
				break;
			}}

		if(customer==null)
		{
			throw new UserNotFoundException("User with "+mobileNo+" Not Found");
		}

		return customer;

	}

	
	//This method will give the list of account whose account creation detail is pending
		//method will throw a exception if there is no pending account.
	@Override
	public List<Customer> getAccountsToApprove() throws NoPendingAccount{

		List<Customer> pendingAccounts= new ArrayList<>();
		List<Customer> accounts = custDao.findAll();
		for(Customer acc:accounts) {
			if((acc.getAccountStatus().equalsIgnoreCase("pending")))
			{
				pendingAccounts.add(acc);
			}
		}
		if(pendingAccounts.isEmpty())
		{
			throw new NoPendingAccount("No pending Account");
		}
		else
		{
			return pendingAccounts;
		}

	}

	
	//This method will approve the account of person based on there age 
	//method accept mobile number as argument
	//Will throw a exception user not found if no user in pending account have given mobile number
	@Override
	public String approveAccount(long mobileNo) throws UserNotFoundException, NoSuchAlgorithmException {

		List<Customer> accounts = custDao.findAll();
		int flag=0;
		for(Customer acc:accounts) 
		{
			if(acc.getPhoneNo()==mobileNo && (acc.getAccountStatus().equalsIgnoreCase("pending")))
			{
					
						if(acc.getAge()>18)
						{
							acc.setAccountStatus("approved");
							Account account=new Account(mobileNo);
							accountDao.save(account);
							flag=1;
						}
						else
						{
							acc.setAccountStatus("rejected");
							flag=2;
						}
				break;
			}
		}
		if(flag==0)
		{
			throw new UserNotFoundException("Account with mobile number"+mobileNo+" not found or already approved or rejected");
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

	
	//Use to update the detail of user if there is any error in the user data
	@Override
	public String updatePersonalDetail(CustomerDTO customer) {

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
			custDao.saveAndFlush(new Customer(customer.getPhoneNo(), customer.getPassword(), customer.getCustName(), customer.getAge(),
					customer.getGender(), customer.getEmailId()));
			return "Personal detail sucessfully updated for "+customer.getCustName();
		}


	}



}
