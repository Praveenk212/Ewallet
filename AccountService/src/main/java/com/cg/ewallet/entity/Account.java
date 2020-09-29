package com.cg.ewallet.entity;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="account")
public class Account {

	
	
	//This method is used to create account number of 12 digit 
	public static long generateAccount() throws NoSuchAlgorithmException {
		Random rand = SecureRandom.getInstanceStrong();
		StringBuilder sb=new StringBuilder();
			// Account number starts with 1000
			sb.append(1000);

			// rest of 11 digits
			for (int i = 0; i < 9; i++) {
				sb.append(rand.nextInt(10));
			}
		return Long.parseLong(sb.toString());
	}

	@Id
	@Column(name="phoneno")
	private long phoneNo;
	@Column(name="accno")
	private long accNo;
	@Column(name="balance")
	private float balance;


	/*
		Constructor of the DTO class.
	 */
	public Account(){}


	public Account( long accNo, float balance, long phoneNo) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.phoneNo = phoneNo;
	}
	public Account(long phoneNo) throws NoSuchAlgorithmException {
		super();
		this.accNo=Account.generateAccount();
		this.balance = 0;
		this.phoneNo = phoneNo;
	}


	
	/*	
	Override toString() method
	//To string method this method will show following detail if you print instance of this class
*/
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + ", phoneNo=" + phoneNo
				+ "]";
	}


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
