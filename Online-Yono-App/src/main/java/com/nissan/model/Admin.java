package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblAdmin")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	@Column(nullable = false)
	private String adminName;
	@Column(nullable = false)
	private int adminPin = 9895;
	
	@JoinColumn(name="bankId")
	@OneToOne
	Bank bank;
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String adminName, int adminPin) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPin = adminPin;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getAdminPin() {
		return adminPin;
	}

	public void setAdminPin(int adminPin) {
		this.adminPin = adminPin;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPin=" + adminPin + "]";
	}
	
	
	
}
