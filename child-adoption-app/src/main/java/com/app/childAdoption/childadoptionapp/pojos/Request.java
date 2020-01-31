package com.app.childAdoption.childadoptionapp.pojos;

import javax.persistence.Entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "REQUEST")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int req_id;
	
	private String genderOfChild;
	
	private String healthStatusOfChild;
	
	private String categoryOfChild;
	
	private int ageOfChild;
	
	private String state;
	
	private String statusOfRequest;
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ngo_id")
	private Ngo ngo;
	
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "reg_No")
	private Parent parent;
	
//	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "child_id")
	private Child child;
	
	
	private String moto;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate requested_date;
	
	public Request() {
		// TODO Auto-generated constructor stub
	}

	public Request(int req_id, Ngo ngo, Parent parent, String moto, LocalDate requested_date) {
		super();
		this.req_id = req_id;
		this.ngo = ngo;
		this.parent = parent;
		this.moto = moto;
		this.requested_date = requested_date;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public Ngo getNgo() {
		return ngo;
	}

	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}

	public LocalDate getRequested_date() {
		return requested_date;
	}

	public void setRequested_date(LocalDate requested_date) {
		this.requested_date = requested_date;
	}

	public String getGenderOfChild() {
		return genderOfChild;
	}

	public void setGenderOfChild(String genderOfChild) {
		this.genderOfChild = genderOfChild;
	}

	public String getHealthStatusOfChild() {
		return healthStatusOfChild;
	}

	public void setHealthStatusOfChild(String healthStatusOfChild) {
		this.healthStatusOfChild = healthStatusOfChild;
	}

	public int getAgeOfChild() {
		return ageOfChild;
	}

	public void setAgeOfChild(int ageOfChild) {
		this.ageOfChild = ageOfChild;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatusOfRequest() {
		return statusOfRequest;
	}

	public void setStatusOfRequest(String statusOfRequest) {
		this.statusOfRequest = statusOfRequest;
	}

	public String getCategoryOfChild() {
		return categoryOfChild;
	}

	public void setCategoryOfChild(String categoryOfChild) {
		this.categoryOfChild = categoryOfChild;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Request [req_id=" + req_id + ", genderOfChild=" + genderOfChild + ", healthStatusOfChild="
				+ healthStatusOfChild + ", categoryOfChild=" + categoryOfChild + ", ageOfChild=" + ageOfChild
				+ ", state=" + state + ", statusOfRequest=" + statusOfRequest + ", moto=" + moto + ", requested_date="
				+ requested_date + "]";
	}


	
	
	
}
