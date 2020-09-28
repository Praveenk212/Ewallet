package com.cg.ewallet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import org.junit.Test;

import com.cg.ewallet.dao.CustomerDao;
import com.cg.ewallet.dto.Customer;
import com.cg.ewallet.exception.UserExistsException;

@SpringBootTest
public class AccountServiceImplTest {
	
	@Autowired
	private AccountService accService;

	@MockBean
	private CustomerDao custDao;
	
	@Test
	public void createNewCustomerTest() throws UserExistsException
	{
		Customer custOne = new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com");
		when(custDao.save(custOne)).thenReturn(custOne);
	    assertEquals("Account Detail sucessfully submitted", accService.createCustomerAccount(custOne).toString());
	}
	@Test
	public void createNewCustomerTestWith()
	{
		Customer custOne = new Customer(7876543212l, "John@123", "John", 19,"Male","howtodoinjava@gmail.com");
		Customer custTwo = new Customer(7876543212l, "Alex@123", "kolenchiski", 19,"Male", "alexk@yahoo.com");
		when(custDao.save(custOne)).thenReturn(custOne);
	    try {
			assertEquals("Mobile Number alredy Exist try to Login", accService.createCustomerAccount(custTwo).toString());
		} catch (UserExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 

}
