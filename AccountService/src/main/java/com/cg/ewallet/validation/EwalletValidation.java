package com.cg.ewallet.validation;

import org.springframework.stereotype.Repository;

@Repository
public class EwalletValidation 
{
	public boolean isFloat(String value)
	{
		String regex="[-+]?(\\d+)|(\\d*\\.\\d+)";
		return value.matches(regex);
	}
	public boolean isDigit(String id)
	{
	String regex = "[1-9][0-9]*|0";
	return id.matches(regex);
	}
	public boolean checkAccountNo(String accountNo)
	{
	String regex ="\\d{11}";
	return accountNo.matches(regex);
	}
	public boolean checkBalance(String balance)
	{
	String regex ="^[0-9]{1,15}$";
	return balance.matches(regex);
	}
	public boolean checkUserName(String userName)
	{
		String regex ="(^[a-z]{1}[a-z0-9_-]{2,15}$)";

		return userName.matches(regex);
	}
	
	public boolean checkPassword(String password)
	{

		String regex="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		return password.matches(regex);
	}
	
	public boolean checkCustomerName(String name)
	{
		String regex="^[a-zA-Z\\\\s]*$";
		return name.matches(regex);
	}
	
	public boolean checkCustomerAge(String custAge)
	{
		char ch[]=custAge.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(!Character.isDigit(ch[i]))
			{
				return false;
			}
		}
		int age=Integer.parseInt(custAge);
		
		return (age>1 && age<=120)?true:false; 
	
	}	
	public boolean checkCustomerGender(String gender)
	{
		return gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") ;
	}
	
	public boolean checkCustomerMobile(String moblieNo)
	{
		String regex="(0/91)?[7-9][0-9]{9}";
		return moblieNo.matches(regex);
	}
	
	public boolean checkCustomerCity(String city)
	{
		String regex="^[a-zA-Z]";
		return city.matches(regex);
	}
	public boolean checkCustomerAddress(String address)
	{
		String regex="^[a-zA-Z\\\\\\\\s]*$";
		return address.matches(regex);
	}
	
	public boolean checkCustomerAadharNo(String aadharNo)
	{
		String regex="^[2-9]{1}[0-9]{11}$";
		return aadharNo.matches(regex);
	}
	
	public boolean checkCustomerEmail(String email)
	{
		String regex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(regex);
	}
}
