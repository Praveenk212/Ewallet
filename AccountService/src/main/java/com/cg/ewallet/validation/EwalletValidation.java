package com.cg.ewallet.validation;

import org.springframework.stereotype.Repository;

@Repository
public class EwalletValidation 
{
	
	public static boolean checkPassword(String password)
	{

		String regex="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		return password.matches(regex);
	} 
	
	public static boolean checkCustomerName(String name)
	{
		String regex="^[a-zA-Z\\s]*$";
		return name.matches(regex);
	}
	
	
	public static boolean checkCustomerMobile(String moblieNo)
	{
		String regex="(0/91)?[6-9][0-9]{9}";
		return moblieNo.matches(regex);
	}

	
	
	public static boolean checkCustomerEmail(String email)
	{
		String regex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(regex);
	}
}
