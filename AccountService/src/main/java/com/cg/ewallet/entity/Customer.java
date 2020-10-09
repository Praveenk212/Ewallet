package com.cg.ewallet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="phoneno")
	private long phoneNo;
	@Column(name="password")
	private String passWord;
	@Column(name="custname")
	private String custName;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="emailid")
	private String emailId;
	@Column(name="accountstatus")
	private String accountStatus;

	
	
	
	

	/*
		Constructor of the DTO class.
	*/
	public Customer(){}
	
	
	public Customer(long phoneNo, String passWord, String custName, int age, String gender, String emailId) {
		super();
		this.phoneNo = phoneNo;
		this.passWord = passWord;
		this.custName = custName;
		this.age = age;
		this.gender = gender;
		this.emailId = emailId;
		this.accountStatus = "pending";
	}
	
	public Customer(long phoneNo, String passWord, String custName, int age, String gender, String emailId,String status) {
		super();
		this.phoneNo = phoneNo;
		this.passWord = passWord;
		this.custName = custName;
		this.age = age;
		this.gender = gender;
		this.emailId = emailId;
		this.accountStatus = status;
	}

	/*
		Getter-Setter to get and set the values.
	*/
	


	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	


	

	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	

	/*	
	Override toString() method
	//To string method this method will show following detail if you print instance of this class
*/
	
	@Override
	public String toString() {
		return "Customer [phoneNo=" + phoneNo + ", password=" + passWord + ", custName=" + custName + ", age=" + age
				+ ", gender=" + gender + ", emailId=" + emailId + ", accountStatus=" + accountStatus + "]";
	}


	
	
	
	

	
	
}
