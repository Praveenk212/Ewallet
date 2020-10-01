package com.cg.ewallet.dto;



public class CustomerDTO {
	
	private long phoneNo;
	
	private String password;

	private String custName;

	private int age;
	
	private String gender;
	
	private String emailId;

	private String accountStatus;


	/*
		Constructor of the DTO class.
	*/
	public CustomerDTO(){}
	
	
	public CustomerDTO(long phoneNo, String password, String custName, int age, String gender, String emailId) {
		super();
		this.phoneNo = phoneNo;
		this.password = password;
		this.custName = custName;
		this.age = age;
		this.gender = gender;
		this.emailId = emailId;
		this.accountStatus = "pending";
	}
	public CustomerDTO(long phoneNo, String password, String custName, int age, String gender, String emailId,String status) {
		super();
		this.phoneNo = phoneNo;
		this.password = password;
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
	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
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
		return "Customer [phoneNo=" + phoneNo + ", password=" + password + ", custName=" + custName + ", age=" + age
				+ ", gender=" + gender + ", emailId=" + emailId + ", accountStatus=" + accountStatus + "]";
	}


	
	
	
	

	
	
}
