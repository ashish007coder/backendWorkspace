package com.app.childAdoption.childadoptionapp.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ngos")
public class Ngo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ngo_id;
	
	@Column(name = "ngo_name")
	private String ngoName;
	
//	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "set_up_date")
	private Date setUpDate;
	
	private String address;
	
	private String state;

	private String district;
	
	@Column(name = "Contact_Person")
	private String contactPerson;
	
	@Column(name = "Phone_Number")
	private String PhoneNumber;
	
	private String email;
	
	private String password;
	
	@Transient
	private String confirmPassword;
	
	/*@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REQUEST",joinColumns = @JoinColumn(name = "ngo_id",referencedColumnName = "ngo_id"),inverseJoinColumns = @JoinColumn(name = "reg_No",referencedColumnName = "reg_No"))
	private List<Parent> listOfParents = new ArrayList<>(); */
	
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy = "ngo")
	private List<Request> requests = new ArrayList<>();
	

	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@JsonManagedReference
	@OneToMany(mappedBy = "ngo",targetEntity = Child.class,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private List<Child> listOfchildren = new ArrayList<>();
	
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
	

	public Ngo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
	public int getNgo_id() {
		return ngo_id;
	}

	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
	}
	

	/*public List<Parent> getListOfParents() {
		return listOfParents;
	}

	public void setListOfParents(List<Parent> listOfParents) {
		this.listOfParents = listOfParents;
	}*/
	
	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	
	public List<Child> getListOfchildren() {
		return listOfchildren;
	}

	
	public void setListOfchildren(List<Child> listOfchildren) {
		this.listOfchildren = listOfchildren;
	}

	
	

	@Override
	public String toString() {
		return "Ngo [ngo_id=" + ngo_id + ", ngoName=" + ngoName + ", setUpDate=" + setUpDate + ", address=" + address
				+ ", state=" + state + ", district=" + district + ", contactPerson=" + contactPerson + ", PhoneNumber="
				+ PhoneNumber + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}

	public void addChild(Child c) {
		listOfchildren.add(c);
		c.setNgo(this);
	}
	public void removeChild(Child c) {
		listOfchildren.remove(c);
		c.setNgo(null);
	}
}
