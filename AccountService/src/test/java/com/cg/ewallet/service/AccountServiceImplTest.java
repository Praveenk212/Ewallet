package com.cg.ewallet.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import com.cg.ewallet.dao.CustomerDao;
import com.cg.ewallet.dto.Customer;

@SpringBootTest
public class AccountServiceImplTest {
	
	@Autowired
	private AccountService accService;

	@MockBean
	private CustomerDao custDao;
	
	@Test
	public void createNewCustomerTest()
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
	    assertEquals("Mobile Number alredy Exist try to Login", accService.createCustomerAccount(custTwo).toString());
	}

	 

}
