package com.cg.ewallet.dto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class AccountDTO {

	
	private long phoneNo;

	private long accNo;

	private float balance;
	
	//This method is used to create account number of 12 digit 
		public static long generateAccount() throws NoSuchAlgorithmException {
			Random rand = SecureRandom.getInstanceStrong();
			StringBuilder sb=new StringBuilder();
				// Account number starts with 1000
				sb.append(1000);

				// rest of 11 digits
				for (int i = 0; i < 8; i++) {
					sb.append(rand.nextInt(10));
				}
			return Long.parseLong(sb.toString());
		}


	/*
		Constructor of the DTO class.
	 */
	public AccountDTO(){}


	public AccountDTO( long accNo, float balance, long phoneNo) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.phoneNo = phoneNo;
	}
	
	public AccountDTO(long phoneNo) throws NoSuchAlgorithmException {
		super();
		this.accNo=AccountDTO.generateAccount();
		this.balance = 0;
		this.phoneNo = phoneNo;
	}



	
	//To string method this method will show following detail if you print instance of this class
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + ", phoneNo=" + phoneNo
				+ "]";
	}


	
	
	//Setter and getter method for the attributes
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public long getPhoneNo() {
		return phoneNo;
	}



	public long getAccNo() {
		return accNo;
	}


	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}

}
