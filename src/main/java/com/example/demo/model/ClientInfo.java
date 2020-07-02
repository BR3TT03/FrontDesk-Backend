package com.example.demo.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ClientInfo {
	private int id;
	private String name;
	private String academic;
	private String status;
	private String email;
	private String phone;
	private int weight;
	private String address;
	private int age;
	private Date date;
	private String remark;
	private Float height;
	private String gender;
	private String maritalStatus;
	private Timestamp createdAt;
	public ClientInfo(int id, String name, String academic, String status, String email, String phone, int weight,
			String address, int age, Date date, String remark, Float height, String gender, String maritalStatus,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.academic = academic;
		this.status = status;
		this.email = email;
		this.phone = phone;
		this.weight = weight;
		this.address = address;
		this.age = age;
		this.date = date;
		this.remark = remark;
		this.height = height;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.createdAt = createdAt;
	}
	public ClientInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
