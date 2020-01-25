package com.app.childAdoption.childadoptionapp.pojos;

import javax.persistence.Entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "REQUEST")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int req_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ngo_id")
	private Ngo ngo;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reg_No")
	private Parent parent;
	
	private String moto;
	
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
	
}
