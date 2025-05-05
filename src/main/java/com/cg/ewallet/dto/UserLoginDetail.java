package com.cg.ewallet.dto;


public class UserLoginDetail {
	
	private long phoneNo;

	private String passWord;
	
	public UserLoginDetail(){}



	
	public String getPassWord() {
		return passWord;
	} 

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}




	public long getPhoneNo() {
		return phoneNo;
	}




	public UserLoginDetail(long mobileNo, String passWord) {
		super();
		this.phoneNo = mobileNo;
		this.passWord = passWord;
	}




	public void setPhoneNo(long mobileNo) {
		this.phoneNo = mobileNo;
	}




	@Override
	public String toString() {
		return "User [phoneNo=" + phoneNo + ", passWord=" + passWord + "]";
	}

	

	
	
}
