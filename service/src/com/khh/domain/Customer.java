package com.khh.domain;
import java.io.Serializable;

public class Customer implements Serializable {
	private String customerID;
	private String customerName;
	private String companyName;
	private String companyAddress;
	
	
	public Customer(String customerID, String customerName, String companyName, String companyAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
}
