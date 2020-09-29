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
//		@Before
//		public void Start()
//		{
//			validation=new EwalletValidation();
//		}
		@Test
		public void testIsValidIncomeForFloat() 
		{
			boolean flag=validation.isFloat("123.98");
			assertTrue(flag);	
		}
		@Test
		public void testIsValidIncomeForString() 
		{
			boolean flag=validation.isFloat("abc");
			assertFalse(flag);	
		}
		@Test
		public void testIsValidIncomeForCombinationStartWithAlphabet() 
		{
			boolean flag=validation.isFloat("abc123.98");
			assertFalse(flag);	
		}
		@Test
		public void testIsValidIncomeForCombinationStartsWithInt() 
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

