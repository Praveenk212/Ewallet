package com.cg.ewallet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.cg.ewallet.dao.CustomerDao;
import com.cg.ewallet.entity.Customer;
import com.cg.ewallet.exception.UserExistsException;

@RunWith(SpringRunner.class)
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
	

	 

}
