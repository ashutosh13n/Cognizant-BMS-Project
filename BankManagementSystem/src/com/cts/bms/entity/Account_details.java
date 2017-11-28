package com.cts.bms.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;

public class Account_details {

	@Id
	@Column(name = "acc_no")
	private String acc_no;

	@Column(name = "acc_opendate")
	private Date acc_opendate;

	@Column(name = "acc_type")
	private String acc_type;

	@Column(name = "balance")
	private int balance;

	@Column(name = "branch_name")
	private String branch_name;

	public String getBranch() {
		return branch_name;
	}
	
	public void setBranch(String branch_name) {
		this.branch_name = branch_name;
	}


	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String account_no) {
		this.acc_no = account_no;
	}

	public Date getAcc_opendate() {
		return acc_opendate;
	}

	public void setAcc_opendate(Date acc_opendate) {
		this.acc_opendate = acc_opendate;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
