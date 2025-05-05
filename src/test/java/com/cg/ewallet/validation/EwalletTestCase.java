package com.cg.ewallet.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EwalletTestCase {
		
	    @Autowired
		EwalletValidation validation;

		@Test
		public void testCustomerCompleteName() 
		{
			boolean flag=EwalletValidation.checkCustomerName("Praveen Kumar");
			assertTrue(flag);	
		}

		@Test
		public void testCustomerCompleteNameWithDigits() 
		{
			boolean flag=EwalletValidation.checkCustomerName("Praveen212");
			assertFalse(flag);	
		}
		@Test
		public void testCustomerCompleteNameConatinsSpecialChar() 
		{
			boolean flag=EwalletValidation.checkCustomerName("Praveen@Kumar");
			assertFalse(flag);	
		}
		@Test
		public void testCustomerCompleteNameConatinsOnlyDigits() 
		{
			boolean flag=EwalletValidation.checkCustomerName("123456");
			assertFalse(flag);	
		}
		
		@Test
		public void testCustomerCompleteNameConatinsNumberAndSpecialChar() 
		{
			boolean flag=EwalletValidation.checkCustomerName("1234@");
			assertFalse(flag);	
		}
		
		
		@Test
		public void testIsValidPassWord() 
		{
			boolean flag=EwalletValidation.checkPassword("Praveen@1222");
			assertTrue(flag);	
		}
		@Test
		public void testIsValidPassWordContainsOnlyDigits() 
		{
			boolean flag=EwalletValidation.checkPassword("988123");
			assertFalse(flag);	
		}
		@Test
		public void testIsValidPassWordContainsOnlyAlphabets() 
		{
			boolean flag=EwalletValidation.checkPassword("abcdef");
			assertFalse(flag);	
		}
		@Test
		public void testIsValidPassWordContainsOnlyAlphabetsAndCharacters() 
		{
			boolean flag=EwalletValidation.checkPassword("abcdef123");
			assertFalse(flag);	
		}
		
		@Test
		public void testCustomerMobileNumber() 
		{
			boolean flag=EwalletValidation.checkCustomerMobile("7865432167");
			assertTrue(flag);	
		}
		
		@Test
		public void testCustomerMobileNumberContainsCharacter() 
		{
			boolean flag=EwalletValidation.checkCustomerMobile("786543216p");
			assertFalse(flag);	
		}
		@Test
		public void testCustomerMobileNumberContainsSpecialCharacter() 
		{
			boolean flag=EwalletValidation.checkCustomerMobile("786543216@");
			assertFalse(flag);	
		}
		
		@Test
		public void testCustomerMobileNumberContainsLessThanTenDigits() 
		{
			boolean flag=EwalletValidation.checkCustomerMobile("78654321");
			assertFalse(flag);	
		}
		
		@Test
		public void testCustomerEmail() 
		{
			boolean flag=EwalletValidation.checkCustomerEmail("pk.umar@gmail.com");
			assertTrue(flag);	
		}
		
		@Test
		public void testCustomerEmailDontHaveAtSymbol() 
		{
			boolean flag=EwalletValidation.checkCustomerEmail("pkgmail.com");
			assertFalse(flag);	
		}
		
		@Test
		public void testCustomerEmailDontHaveDotCom() 
		{
			boolean flag=EwalletValidation.checkCustomerEmail("pk@gmail");
			assertFalse(flag);	
		}
		


	}

