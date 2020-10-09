package com.cg.ewallet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.cg.ewallet.dao.CustomerDao;
import com.cg.ewallet.dto.CustomerDTO;
import com.cg.ewallet.entity.Customer;
import com.cg.ewallet.exception.CustomerInfoNotValid;
import com.cg.ewallet.exception.MobileNoNotValid;
import com.cg.ewallet.exception.NoPendingAccount;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.exception.UserNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {
	
	@Autowired
	private AccountService accService;

	@MockBean
	private CustomerDao custDao;
	
	@Test
	public void createNewCustomerTest() throws UserExistsException ,CustomerInfoNotValid
	{
		Customer custOne = new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com");
		when(custDao.save(custOne)).thenReturn(custOne);
	    assertEquals("Account Detail sucessfully submitted", accService.createCustomerAccount(
	    		new CustomerDTO(custOne.getPhoneNo(), custOne.getPassWord(), custOne.getCustName(), custOne.getAge(),
	    				custOne.getGender(), custOne.getEmailId())));
	}
	
	@Test
	public void createNewCustomerWithInvalidMobileNumber() throws UserExistsException ,CustomerInfoNotValid
	{
		Customer custOne = new Customer(78765432l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com");
		when(custDao.save(custOne)).thenReturn(custOne);
	    
	    assertEquals(assertThrows(
				CustomerInfoNotValid.class,()
				 ->  accService.createCustomerAccount(
				    		new CustomerDTO(custOne.getPhoneNo(), custOne.getPassWord(), custOne.getCustName(), custOne.getAge(),
				    				custOne.getGender(), custOne.getEmailId()))).getMessage(),"Please give correct data");
	}
	
	@Test
	public void createNewCustomerWithInvalidGmail() throws UserExistsException ,CustomerInfoNotValid
	{
		Customer custOne = new Customer(7876543265l, "John@123", "John", 19,"Male","howtodoinjavagmail.com");
		when(custDao.save(custOne)).thenReturn(custOne);
	    
	    assertEquals(assertThrows(
				CustomerInfoNotValid.class,()
				 ->  accService.createCustomerAccount(
				    		new CustomerDTO(custOne.getPhoneNo(), custOne.getPassWord(), custOne.getCustName(), custOne.getAge(),
				    				custOne.getGender(), custOne.getEmailId()))).getMessage(),"Please give correct data");
	}
	
	
	@Test
	public void createNewCustomerWithInvalidCustomerName() throws UserExistsException ,CustomerInfoNotValid
	{
		Customer custOne = new Customer(7876543298l, "John@123", "John12", 19,"Male","howtodoinjava@gmail.com");
		when(custDao.save(custOne)).thenReturn(custOne);
	    
	    assertEquals(assertThrows(
				CustomerInfoNotValid.class,()
				 ->  accService.createCustomerAccount(
				    		new CustomerDTO(custOne.getPhoneNo(), custOne.getPassWord(), custOne.getCustName(), custOne.getAge(),
				    				custOne.getGender(), custOne.getEmailId()))).getMessage(),"Please give correct data");
	}
	
	
	@Test
	public void createNewCustomerWithInvalidPassword() throws UserExistsException ,CustomerInfoNotValid
	{
		Customer custOne = new Customer(7876543298l, "John123", "John", 19,"Male","howtodoinjava@gmail.com");
		when(custDao.save(custOne)).thenReturn(custOne);
	    
	    assertEquals(assertThrows(
				CustomerInfoNotValid.class,()
				 ->  accService.createCustomerAccount(
				    		new CustomerDTO(custOne.getPhoneNo(), custOne.getPassWord(), custOne.getCustName(), custOne.getAge(),
				    				custOne.getGender(), custOne.getEmailId()))).getMessage(),"Please give correct data");
	}
	
	
	
	@Test
	public void getAllUserTest()
	{
		List<Customer> list = new ArrayList<Customer>();
		Customer custOne = new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com");
		Customer custTwo = new Customer(7876543212l, "Alex@123", "kolenchiski", 19,"Male", "alexk@yahoo.com");
		list.add(custOne);
		list.add(custTwo);
		
		when(custDao.findAll()).thenReturn(list);
		
	    assertEquals(2, accService.getAllUser().size());
	}
	
	
	
	@Test
	public void getAccountToApproveTest() throws NoPendingAccount
	{
		List<Customer> list = new ArrayList<Customer>();
		Customer custOne = new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com","pending");
		Customer custTwo = new Customer(7876543291l, "Ross@123", "kolenchiski", 19,"Male", "rossk@yahoo.com","pending");
		Customer custThree = new Customer(7876543225l, "Hema@123", "kolenchiski", 19,"Male", "hema@yahoo.com","approved");
		list.add(custOne);
		list.add(custTwo);
		list.add(custThree);
		
		when(custDao.findAll()).thenReturn(list);
		
	    assertEquals(2, accService.getAccountsToApprove().size());
	}
	
	@Test
	public void getAccountToApproveTestWithNoPendingAccount() throws NoPendingAccount
	{
		List<Customer> list = new ArrayList<Customer>();
		Customer custOne = new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com","approved");
		Customer custTwo = new Customer(7876543291l, "Ross@123", "kolenchiski", 19,"Male", "rossk@yahoo.com","approved");
		Customer custThree = new Customer(7876543225l, "Hema@123", "kolenchiski", 19,"Male", "hema@yahoo.com","approved");
		list.add(custOne);
		list.add(custTwo);
		list.add(custThree);
		
		when(custDao.findAll()).thenReturn(list);
		
		  assertEquals(assertThrows(
					NoPendingAccount.class,()
					 ->  accService.getAccountsToApprove()).getMessage(),"No pending Account");
	}
	
	@Test
	public void getAccountByMobileNumberTest() throws UserNotFoundException, MobileNoNotValid
	{
		List<Customer> list = new ArrayList<Customer>();
		Customer custOne = new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com","approved");
		Customer custTwo = new Customer(7876543291l, "Ross@123", "kolenchiski", 19,"Male", "rossk@yahoo.com","approved");
		Customer custThree = new Customer(7876543225l, "Hema@123", "kolenchiski", 19,"Male", "hema@yahoo.com","approved");
		list.add(custOne);
		list.add(custTwo);
		list.add(custThree);
		
		when(custDao.findAll()).thenReturn(list);
		
		assertEquals(new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com","approved").toString()
				, accService.getUserByMobileNumber(7876543212l).toString());
	}
	
	
	
	

	 

}
