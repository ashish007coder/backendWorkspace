package com.app.childAdoption.childadoptionapp.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHILD")
public class Child {

	@Id
	@Column(name = "CHILD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int child_id;
	
	@Column(name = "CHILD_NAME")
	private String child_name;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "COLOR")
	private String color;
	
	private String url;
	
	@Column(name = "HEALTH_STATUS")
	private String health;
	
	@Column(name = "BLOOD_GROUP")
	private String bloodGroup;
	
	@ManyToOne
	@JoinColumn(name = "reg_No",referencedColumnName = "REG_NO")
	private Parent parent;
	
	@ManyToOne
	@JoinColumn(name = "ngo_id",referencedColumnName = "NGO_ID")
	private Ngo ngo;
	
	
	public Child() {
		
	}
	public Child(int id, String name, int age, String gender, String color, String url, String health,
			String bloodGroup) {
		super();
		this.child_id = id;
		this.child_name = name;
		this.age = age;
		this.gender = gender;
		this.color = color;
		this.url = url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	@Override
	public String toString() {
		return "Child [id=" + child_id + ", name=" + child_name + ", age=" + age + ", gender=" + gender + ", color=" + color
				+ ", url=" + url + ", health=" + health + ", bloodGroup=" + bloodGroup + "]";
	}
	
	
	
}
