 package com.cts.bms.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "customer_details")
public class User {
	   
    @Id
    @Column(name="cust_id")
    private String cust_id ;
    
	@Column(name="username")
    private String username;
	
	@Column(name = "password")
    private String password;
    
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "email_adddress")
	private String email;

	@Column(name = "contact_no")
	private long phone;

	@Column(name = "citizen_status")
	private String citizen_status;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;

	@Column(name = "marital_status")
	private String marital_status;

	@Column(name = "guardian_name")
	private String guardian_name;
	
	@Column(name = "guardian_type")
	private String guardian_type;
		
	@Column(name = "idproof_type")
	private String idproof_type;
	
	@Column(name = "iddoc_no")
	private String iddoc_no;
	
	@Column(name = "pancard")
	private String pancard;
	
	@Column(name = "ref_acc_no")
	private long ref_acc_no;
	
	@Column(name = "ref_acc_name")
	private String ref_acc_name;
	
//	@Autowired
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "acc_no")
//	private Account_details account_details;


	@Column(name = "acc_no")
	private String acc_no;

	@Column(name = "acc_opendate")
	private Date acc_opendate;

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
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

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	@Column(name = "acc_type")
	private String acc_type;

	@Column(name = "balance")
	private int balance;

	@Column(name = "branch_name")
	private String branch_name;

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getCitizen_status() {
		return citizen_status;
	}

	public void setCitizen_status(String citizen_status) {
		this.citizen_status = citizen_status;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public String getGuardian_type() {
		return guardian_type;
	}

	public void setGuardian_type(String guardian_type) {
		this.guardian_type = guardian_type;
	}

	public String getIdproof_type() {
		return idproof_type;
	}

	public void setIdproof_type(String idproof_type) {
		this.idproof_type = idproof_type;
	}

	public String getIddoc_no() {
		return iddoc_no;
	}

	public void setIddoc_no(String iddoc_no) {
		this.iddoc_no = iddoc_no;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public long getRef_acc_no() {
		return ref_acc_no;
	}

	public void setRef_acc_no(long ref_acc_no) {
		this.ref_acc_no = ref_acc_no;
	}

	public String getRef_acc_name() {
		return ref_acc_name;
	}

	public void setRef_acc_name(String ref_acc_name) {
		this.ref_acc_name = ref_acc_name;
	}
	
	
	
	
}

