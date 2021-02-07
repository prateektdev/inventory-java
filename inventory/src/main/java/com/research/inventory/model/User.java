package com.research.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**

* The is model class for the User entity in the application.
* It contain fields like firstname ,lastname ,username ,password ,role

* @version 1.0

* @author Prateek T

*/
@Entity 
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String firstname ;
	
	@Column
	private String lastname ;
	
	@Column
	private String username ;
	
	@Column
	private String password ;
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	@Column
	private String profile_image;
	

	@Column
	private Role role ;

	public Long getId() {
		return id;
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

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
 

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + ", profile_image="
				+ profile_image + ", role=" + role + "]";
	}
	
	
	
}
