package com.codingdojo.loginandreg.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

import com.codingdojo.loginandreg.constraintcomposition.ValidLicensePlate;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Size(min=2,message="First name at least 2 characters")
	private String firstName;
	
    @ValidLicensePlate
	private String lastName;
	
	@NotEmpty
	@Email(message="Email cannot be blank")
	private String email;
	
	
	@Size(min=8,max=128,message="password needs to be between 8-128 characters")
	private String password;
	
	@Transient
	private String confirm;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // Need to add one to many with plants
    // remember getters and setters
    // remember to update constructors

	//CONSTRUCTORS
	public User() {
		super();
	}
	
	public User(@NotEmpty @Size(min = 2, message = "First name cannot be blank") String firstName,
			@NotEmpty @Size(min = 2, message = "Last Name cannot be blank") String lastName,
			@NotEmpty @Email(message = "Email cannot be blank") String email,
			@NotEmpty @Size(min = 8, max = 128, message = "password needs to be between 8-128 characters") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public User(@NotNull @Size(min = 2, max = 25, message = "First name cannot be blank") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "last Name cannot be blank") String lastName,
			@NotEmpty @Email(message = "Email cannot be blank") String email,
			@NotNull @Size(min = 8, max = 128, message = "password needs to be between 8-128 characters") String password,
			@NotEmpty(message = "Confirm Password is required!") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
	}

	public User(Long id, @NotNull @Size(min = 2, max = 25, message = "First name cannot be blank") String firstName,
			@NotNull @Size(min = 2, max = 25, message = "last Name cannot be blank") String lastName,
			@NotEmpty @Email(message = "Email cannot be blank") String email,
			@NotNull @Size(min = 8, max = 128, message = "password needs to be between 8-128 characters") String password,
			@NotEmpty(message = "Confirm Password is required!") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	// GETTERS / SETTERS
	public String getEmail() {
		return email;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
