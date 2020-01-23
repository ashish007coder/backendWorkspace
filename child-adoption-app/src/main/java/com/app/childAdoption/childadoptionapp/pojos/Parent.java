package com.app.childAdoption.childadoptionapp.pojos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "parents")
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reg_No;
	
	private String gender;
	
	@Column(name = "male_parent_name")
	private String maleParName;
	
	@Column(name = "female_parent_name")
	private String femaleParName;
	
	@Column(name = "male_parent_age")
	private int maleParAge;
	
	@Column(name = "female_parent_age")
	private int femaleParAge;
	
	@Column(name = "composite_age")
	private int compositeAge;
	
	@Column(name = "male_parent_occupation")
	private String mOccupation;
	
	@Column(name = "female_parent_occupation")
	private String fOccupation;
	
	@Column(name = "male_parent_income")
	private double mIncome;
	
	@Column(name = "female_parent_income")
	private double fIncome;
	
	@Column(name = "number_of_children")
	private int numOfChildren;
	
	private String address;
	
	private String city;
	
	private String district;
	
	private String state;
	
	private int pinCode;
	
	@Column(name = "aadhar_card_no" )
	private int adharNumber;
	
	@Column(name = "mobile_no" )
	private int mobileNumber;
	
	@Column(name = "marital_status" )
	private String maritalStatus;
	
	private Date reg_date;
	
	@Column(name = "num_of_children_parent_have" )
	private int numOfchildrenParentHave;

	private String password;
	
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,targetEntity = Child.class)
	private List<Child> listOfchildren = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "listOfParents",targetEntity = Ngo.class,cascade = CascadeType.ALL)
	private List<Ngo> listOfNgos;
	
	public Parent(int regNo, String gender, String maleParName, String femaleParName, int maleParAge, int femaleParAge,
			int compositeAge, String fOccupation, String mOccupation, double mIncome, double fIncome, int numOfChildren,
			String address, String city, String district, String state, int pinCode, int adharNumber, int mobileNumber,
			String maritalStatus, Date reg_date, int numOfchildrenParentHave, String password, String email) {
		super();
		this.reg_No = regNo;
		this.gender = gender;
		this.maleParName = maleParName;
		this.femaleParName = femaleParName;
		this.maleParAge = maleParAge;
		this.femaleParAge = femaleParAge;
		this.compositeAge = compositeAge;
		this.fOccupation = fOccupation;
		this.mOccupation = mOccupation;
		
		this.mIncome = mIncome;
		this.fIncome = fIncome;
		this.numOfChildren = numOfChildren;
		this.address = address;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
		this.adharNumber = adharNumber;
		this.mobileNumber = mobileNumber;
		this.maritalStatus = maritalStatus;
		this.reg_date = reg_date;
		this.numOfchildrenParentHave = numOfchildrenParentHave;
		this.password = password;
		this.email = email;
	}
	public Parent() {
		// TODO Auto-generated constructor stub
	}
	public int getNumOfchildrenParentHave() {
		return numOfchildrenParentHave;
	}
	public void setNumOfchildrenParentHave(int numOfchildrenParentHave) {
		this.numOfchildrenParentHave = numOfchildrenParentHave;
	}

	public int getRegNo() {
		return reg_No;
	}
	public void setRegNo(int regNo) {
		this.reg_No = regNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaleParName() {
		return maleParName;
	}
	public void setMaleParName(String maleParName) {
		this.maleParName = maleParName;
	}
	public String getFemaleParName() {
		return femaleParName;
	}
	public void setFemaleParName(String femaleParName) {
		this.femaleParName = femaleParName;
	}
	public int getMaleParAge() {
		return maleParAge;
	}
	public void setMaleParAge(int maleParAge) {
		this.maleParAge = maleParAge;
	}
	public int getFemaleParAge() {
		return femaleParAge;
	}
	public void setFemaleParAge(int femaleParAge) {
		this.femaleParAge = femaleParAge;
	}
	public int getCompositeAge() {
		return compositeAge;
	}
	public void setCompositeAge(int compositeAge) {
		this.compositeAge = compositeAge;
	}
	public String getfOccupation() {
		return fOccupation;
	}
	public void setfOccupation(String fOccupation) {
		this.fOccupation = fOccupation;
	}
	public String getmOccupation() {
		return mOccupation;
	}
	public void setmOccupation(String mOccupation) {
		this.mOccupation = mOccupation;
	}
	public double getmIncome() {
		return mIncome;
	}
	public void setmIncome(double mIncome) {
		this.mIncome = mIncome;
	}
	public double getfIncome() {
		return fIncome;
	}
	public void setfIncome(double fIncome) {
		this.fIncome = fIncome;
	}
	public int getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public int getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(int adharNumber) {
		this.adharNumber = adharNumber;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getReg_No() {
		return reg_No;
	}
	public void setReg_No(int reg_No) {
		this.reg_No = reg_No;
	}
	
	public List<Child> getListOfchildren() {
		return listOfchildren;
	}
	public void setListOfchildren(List<Child> listOfchildren) {
		this.listOfchildren = listOfchildren;
	}
	public List<Ngo> getListOfNgos() {
		return listOfNgos;
	}
	public void setListOfNgos(List<Ngo> listOfNgos) {
		this.listOfNgos = listOfNgos;
	}
	@Override
	public String toString() {
		return "Parent [regNo=" + reg_No + ", gender=" + gender + ", maleParName=" + maleParName + ", femaleParName="
				+ femaleParName + ", maleParAge=" + maleParAge + ", femaleParAge=" + femaleParAge + ", compositeAge="
				+ compositeAge + ", fOccupation=" + fOccupation + ", mOccupation=" + mOccupation + ", mIncome="
				+ mIncome + ", fIncome=" + fIncome + ", numOfChildren=" + numOfChildren + ", address=" + address
				+ ", city=" + city + ", district=" + district + ", state=" + state + ", pinCode=" + pinCode
				+ ", adharNumber=" + adharNumber + ", mobileNumber=" + mobileNumber + ", maritalStatus=" + maritalStatus
				+ ", reg_date=" + reg_date + ", numOfchildrenParentHave=" + numOfchildrenParentHave + ", password="
				+ password + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
}
