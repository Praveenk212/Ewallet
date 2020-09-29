package com.cg.ewallet.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="account")
public class Account {

	public static long generateAccount() {
		Random ran = new Random();
		StringBuilder sb = new StringBuilder();

		
		int rValue = ran.nextInt(9);
		// first not 0 digit
		sb.append(rValue + 1);

		// rest of 11 digits
		for (int i = 0; i < 11; i++) {
			sb.append(ran.nextInt(10));
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
	public Account(long phoneNo) {
		super();
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