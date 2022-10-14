package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblBank")
public class Bank {
	
	//declare fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private static final double MINIMUM_BALANCE =5000;

	
	//List of admins
	@OneToMany(mappedBy = "bank")
	List<Admin> admins;
	
	//default Constructor
	public Bank() {
	}

	//parameterized Constructor
	public Bank(int bankId, String bankName, List<Customer> customers) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	
	
	//getters and setters
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public static double getMinimumBalance() {
		return MINIMUM_BALANCE;
	}

	//Overriding toString()
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
	}

	
	
	
}
