package com.codingdojo.exam.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Size(min=2,message="First Name must be at least 2 characters")
	private String firstName;
	
	
	@Size(min=2,message="Last Name must be at least 2 characters")
	private String lastName;
	
	@NotEmpty
	@Email(message="Email cannot be blank")
	private String email;
	
	
	@Size(min=8,max=128,message="password needs to be between 8-128 characters")
	private String password;
	
	@Transient
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    // ================================ RELATIPNSHIPS ================================
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Book> books;
    


    // ================================ CONSTRUCTORS ================================
    public User() {
		super();
    }

	// ================================ GETTERS / SETTERS ================================
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
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

	public List<Book> getNames() {
		return books;
	}

	public void setNames(List<Book> things) {
		this.books = things;
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
