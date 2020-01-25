package com.app.childAdoption.childadoptionapp.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "children")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int child_id;
	
	private String child_name;

	private int age;
	
	private String gender;
	
	private String color;
	
	private byte[] imageUrl;
	
	@Column(name = "health_status")
	private String health;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "reg_No",referencedColumnName = "reg_No")
	private Parent parent;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ngo_id",referencedColumnName = "ngo_id")
	private Ngo ngo;
	
	
	public Child() {
		
	}
	public Child(int id, String name, int age, String gender, String color, byte[] imageUrl, String health,
			String bloodGroup) {
		super();
		this.child_id = id;
		this.child_name = name;
		this.age = age;
		this.gender = gender;
		this.color = color;
		this.imageUrl = imageUrl;
		this.health = health;
		this.bloodGroup = bloodGroup;
	}
	public int getId() {
		return child_id;
	}
	public void setId(int id) {
		this.child_id = id;
	}
	public String getName() {
		return child_name;
	}
	public void setName(String name) {
		this.child_name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public byte[] getimageUrl() {
		return imageUrl;
	}
	public void setimageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public int getChild_id() {
		return child_id;
	}
	public void setChild_id(int child_id) {
		this.child_id = child_id;
	}
	public String getChild_name() {
		return child_name;
	}
	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Ngo getNgo() {
		return ngo;
	}
	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}
	@Override
	public String toString() {
		return "Child [id=" + child_id + ", name=" + child_name + ", age=" + age + ", gender=" + gender + ", color=" + color
				+ ", imageUrl=" + imageUrl + ", health=" + health + ", bloodGroup=" + bloodGroup + "]";
	}
	
	
	
}
