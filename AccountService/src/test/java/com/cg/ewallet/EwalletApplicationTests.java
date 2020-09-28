package com.cg.ewallet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ewallet.dao.CustomerDao;
import com.cg.ewallet.dto.Customer;
import com.cg.ewallet.exception.UserExistsException;
import com.cg.ewallet.service.AccountService;
import com.cg.ewallet.validation.EwalletValidation;


@SpringBootTest
class EwalletApplicationTests {

	@Test
	void contextLoads() {
		
	}
	@Autowired
	EwalletValidation validation;

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
	
	
	@Test
	public void testIsValidBalanceForFloat() 
	{
		boolean flag=validation.isFloat("123.98");
		assertTrue(flag);	
	}
	@Test
	public void testIsValidBalanceForString() 
	{
		boolean flag=validation.isFloat("abc");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidBalanceForCombinationStartWithAlphabet() 
	{
		boolean flag=validation.isFloat("abc123.98");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidBalanceForCombinationStartsWithInt() 
	{
		boolean flag=validation.isFloat("1675abc");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidUserName() 
	{
		boolean flag=validation.checkUserName("praveen123");
		assertTrue(flag);	
	}
	@Test
	public void testIsValidUserNameContainsUnserScore() 
	{
		boolean flag=validation.checkUserName("praveen123_");
		assertTrue(flag);	
	}
	@Test
	public void testIsValidUserNameStartsWithCapital() 
	{
		boolean flag=validation.checkUserName("Praveen123");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidUserNameContainsCapital() 
	{
		boolean flag=validation.checkUserName("pravEEn123");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidUserNameContainsOnlyDigits() 
	{
		boolean flag=validation.checkUserName("988123");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidPassWord() 
	{
		boolean flag=validation.checkPassword("Praveen@1222");
		assertTrue(flag);	
	}
	@Test
	public void testIsValidPassWordContainsOnlyDigits() 
	{
		boolean flag=validation.checkPassword("988123");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidPassWordContainsOnlyAlphabets() 
	{
		boolean flag=validation.checkPassword("abcdef");
		assertFalse(flag);	
	}
	@Test
	public void testIsValidPassWordContainsOnlyAlphabetsAndCharacters() 
	{
		boolean flag=validation.checkPassword("abcdef123");
		assertFalse(flag);	
	}
	@Test
	public void testIsContainsOnlyDigitForRequestId()
	{
		boolean flag=validation.isDigit("123456");
		assertTrue(flag);
	}
	@Test
	public void testIsContainsOnlyCharcterForRequestId()
	{
		boolean flag=validation.isDigit("abscde");
		assertFalse(flag);
	}
	

}
