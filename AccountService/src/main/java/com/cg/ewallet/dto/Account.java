package com.cg.ewallet.dto;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="account")
public class Account {
	
	public static long generateAccount() {
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();

	    // first not 0 digit
	    sb.append(random.nextInt(9) + 1);

	    // rest of 11 digits
	    for (int i = 0; i < 11; i++) {
	        sb.append(random.nextInt(10));
	    }

	    return Long.valueOf(sb.toString()).longValue();
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
	public Account(long phoneNo) {
		super();
//		long autoGeneratedAccNo=(long)(Math.floor(Math.random()*1000000000000l)+1);
			this.accNo=Account.generateAccount();
		this.balance = 0;
		this.phoneNo = phoneNo;
	}


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