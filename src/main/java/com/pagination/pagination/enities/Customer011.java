package com.pagination.pagination.enities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Customer011 {

	private int primaryType;
	@Id
	private String primaryId;
	private String Name;
	private String place;
	private Date DOB;
	private int Age;

	public Customer011() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer011(int primaryType, String primaryId, String name, String place, Date dOB, int age) {
		super();
		this.primaryType = primaryType;
		this.primaryId = primaryId;
		Name = name;
		this.place = place;
		DOB = dOB;
		Age = age;
	}

	public int getPrimaryType() {
		return primaryType;
	}

	public void setPrimaryType(int primaryType) {
		this.primaryType = primaryType;
	}

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	@Override
	public String toString() {
		return "Customer011 [primaryType=" + primaryType + ", primaryId=" + primaryId + ", Name=" + Name + ", place="
				+ place + ", DOB=" + DOB + ", Age=" + Age + "]";
	}

	

}
