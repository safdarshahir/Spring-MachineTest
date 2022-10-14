package com.nissan.model;

import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tblAccount")
public class Account {
	
	//declare fields
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountNo = generateAccNo();
	@Column(nullable=false)
	private String accountType;
	@Column(nullable=false)
	private double accountBalance;
	private int atmPin = generatePin();
	@Value("${isDisabled}")
	private boolean isDisabled = false;
	
	@Column(updatable = false,insertable = false)
	private int customerId;
	@JsonIgnore
	@JoinColumn(name="customerId")
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
	Customer customer;
	
	//default constructor
	public Account() {
		super();
	}

	//parameterized constructor
	public Account(int accountNo, String accountType, double accountBalance, int atmPin, boolean isDisabled,Customer customer) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.atmPin = atmPin;
		this.isDisabled = isDisabled;
		this.customer = customer;
	}

	//getters and setters
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo() {
		this.accountNo = generateAccNo();
	}


	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	
	public int getAtmPin() {
		return atmPin;
	}

	public void setAtmPin() {
		this.atmPin = generatePin();
	}


	public boolean isDisabled() {
		return isDisabled;
	}
	
	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", accountBalance=" + accountBalance
				+ ", atmPin=" + atmPin + ", isDisabled=" + isDisabled + ", customer=" + customer + "]";
	}

	//Method to generate 9 digit account number
	public int generateAccNo(){
		Random rndNo = new Random(System.currentTimeMillis());
		return 14700000+rndNo.nextInt(1000000);
	}
	
	//Method to generate 4 digit pin
	public int generatePin() {
		Random rndNo = new Random(System.currentTimeMillis());
		return rndNo.nextInt((9999-1000)+1)+1000;
	}



}
