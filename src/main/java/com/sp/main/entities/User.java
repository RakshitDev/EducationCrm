package com.sp.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@Pattern(regexp = "^[a-zA-Z]{5,25}$",message = "Invalid name Format")
	private String name;
	@Column
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Invalid Email Input")
	private String email;
	
	@Column
	@Pattern(regexp = "^[a-zA-Z0-9]{5,25}$",message = "Invalid Password")
	private String password;
	@Column
	@Pattern(regexp = "^[0-9]{10}$",message = "Invalid phonenumber Format")
	private String phoneno;
	@Column
	@Pattern(regexp = "^[a-zA-Z]{3,25}$",message = "Invalid city name")
	private String city;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
