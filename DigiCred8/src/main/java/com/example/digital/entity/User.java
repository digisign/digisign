package com.example.digital.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="user")
public class User implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long userId;
	@Column(name="user_name",nullable = false)
	private String userName;
	@Column(name="password",nullable = false)
	private String password;
	@Column(name="is_active")
	private boolean active;
	@Column(name="email",nullable = false)
	private String email;
	@Column(name="created_date",nullable = false)
	private Date createdDate;
	@Column(name="updated_date",nullable = false)
	private Date updatedDate;
	@Column(name="social_id")
	private String socialId;
	@Column(name="status_id")
	private String statusId;
	@Column(name="is_email_verified")
	private boolean isemailVerified;
	
	@javax.persistence.Transient
	private String newPassword;
	
	@javax.persistence.Transient
	private String aadharNo;

	@javax.persistence.Transient
	private String newEmail;

	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL ,fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns=@JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@javax.persistence.Transient
    private Long roleId;

	@JsonIgnore
	@Column(name="salt")
	private String salt;
	
	


	public User() {
		super();
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public Set<Role> getRoles() {
		
		return roles;	
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}


	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}


	public boolean isIsemailVerified() {
		return isemailVerified;
	}


	public void setIsemailVerified(boolean isemailVerified) {
		this.isemailVerified = isemailVerified;
	}
}