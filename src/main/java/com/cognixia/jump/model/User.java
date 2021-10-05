package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Table(name ="user")
@Entity
public class User implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="first_name", columnDefinition = "varchar(50)")
	@NotBlank(message = "Name cannot be left blank")
	private String firstName;
	
	@Column(name="last_name", columnDefinition = "varchar(50)")
	@NotBlank(message = "Name cannot be left blank")
	private String lastName;
	
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
	@Column(name="contact", columnDefinition = "char(12) default '000-000-0000'")
	private String contact;
	
	@Pattern(regexp = "\\d{2}\\/\\d{2}\\/\\d{4}")
	@Column(name="dob", columnDefinition = "char(10) default '00/00/0000'")
	private String dob;
	
	@Column(name="username", columnDefinition = "varchar(100)")
	@NotBlank(message = "Username cannot be left blank")
	private String username;
	
	@Column(name="p_password", columnDefinition = "varchar(50)")
	@NotBlank(message = "password cannot be left blank")
	private String password;
	
	@Column(name="cash", columnDefinition =" DECIMAL(9,2) DEFAULT 0.00")
	@Min(value=5)
	private double cash;
	
	
	public User()
	{
		this(-1, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", -0.0);
	}


	public User(Integer userId, @NotBlank(message = "Name cannot be left blank") String firstName,
			@NotBlank(message = "Name cannot be left blank") String lastName,
			@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}") String contact,
			@Pattern(regexp = "\\d{2}\\/\\d{2}\\/\\d{4}") String dob,
			@NotBlank(message = "Username cannot be left blank") String username,
			@NotBlank(message = "password cannot be left blank") String password, @Min(5) double cash) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.cash = cash;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getCash() {
		return cash;
	}


	public void setCash(double cash) {
		this.cash = cash;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", dob=" + dob + ", username=" + username + ", password=" + password + ", cash=" + cash + "]";
	}
	
	
}
