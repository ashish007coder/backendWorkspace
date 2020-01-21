package com.app.childAdoption.childadoptionapp.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "NGOS")
public class Ngo {

	@Id
	@Column(name = "NGO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ngo_id;
	
	@Column(name = "NGO_NAME")
	private String ngoName;
	
	@Column(name = "SET_UP_DATE")
	private Date setUpDate;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "CONTACT_PERSON")
	private String contactPerson;
	
	@Column(name = "PHONE_NUMBER")
	private String PhoneNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REQUEST",joinColumns = @JoinColumn(name = "ngo_id",referencedColumnName = "NGO_ID"),inverseJoinColumns = @JoinColumn(name = "reg_No",referencedColumnName = "REG_NO"))
	private List<Parent> parents = new ArrayList<>(); 
	
	
	@OneToMany(mappedBy = "ngo",targetEntity = Child.class)
	private List<Child> children = new ArrayList<>();
	
	public Ngo() {
		
	}
	
	public Ngo(int ngoid, String ngoName, Date setUpDate, String address, String state, String district,
			String contactPerson, String phoneNumber, String email, String password, String confirmPassword) {
		super();
		this.ngo_id = ngoid;
		this.ngoName = ngoName;
		this.setUpDate = setUpDate;
		this.address = address;
		this.state = state;
		this.district = district;
		this.contactPerson = contactPerson;
		PhoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}


	public int getReg_id() {
		return ngo_id;
	}


	public void setReg_id(int ngoid) {
		this.ngo_id = ngoid;
	}


	public String getNgoName() {
		return ngoName;
	}


	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}


	public Date getSetUpDate() {
		return setUpDate;
	}


	public void setSetUpDate(Date setUpDate) {
		this.setUpDate = setUpDate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
