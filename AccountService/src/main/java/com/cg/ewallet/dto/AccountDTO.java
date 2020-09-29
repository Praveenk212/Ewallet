package com.cg.ewallet.dto;

public class AccountDTO {

	
	private long phoneNo;

	private long accNo;

	private float balance;


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
