package com.vedjunit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
public class Country {
	
	
	@Id
	private Integer id;
	private String countryName;
	private String stateName;
	public Country(Integer id, String countryName, String stateName) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.stateName = stateName;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", stateName=" + stateName + "]";
	}
	
}
