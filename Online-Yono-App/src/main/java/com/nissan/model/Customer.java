package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tblCustomer")
public class Customer {

	//declare fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	@Column(nullable=false)
	private String customerName;
	@Column(nullable=false,unique=true)
	private String mobileNumber;
	private String emailId;
	private String panNo;
	
	@Value("${isDisabled}")
	private boolean isDisabled = false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<Account> accounts;
	
	//Default constructor
	public Customer() {
	}
	
	//parameterized constructor
	public Customer(int customerId, String customerName, String mobileNumber, String emailId, String panNo,List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.panNo = panNo;
		this.accounts = accounts;
	}


	//getters and setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public void setAccount(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Account> getAccount() {
		return accounts;
	}

	public boolean isDisabled() {
		return isDisabled;
	}
	
	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
	
	//Override toString()

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", panNo=" + panNo + "]";
	}
	

}
