package com.example.digital.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="user")
public class User implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Logger log =Logger.getLogger(this.getClass().getName());
	
	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private long userId;
	
	

	/*@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")*/
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Transient
	@Column(name="password_confirm")
	private String passwordConfirm;
	
	@Column(name="enable")
	//@Enumerated(EnumType.STRING)
	 private boolean enable;
	 
	/*@Column 
	@Enumerated(EnumType.STRING)
	private UserState enabled;*/	
	@Column(name="Email_Id")
	private String emailId;
	@Column(name="Created_Date")
	private Date createdDate;
	@Column(name="Social_Id")
	private String socialId;
	@Column(name="Status_Id")
	private String statusId;
	
	@Column(name="confirmation_token")
	private String confirmationToken;
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL ) 
	@JoinTable(name = "user_role", joinColumns=@JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	

	public long getUserId() {
		return userId;
	}

	
	public void setUserId(long userId) {
		this.userId = userId;
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



	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public boolean getEnable() {
		return enable;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	

	public String getPasswordConfirm() {
		return passwordConfirm;
	}


	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}


	public User(long userId, String username, String password, String passwordConfirm, boolean enable, String emailId,
			Date createdDate, String socialId, String statusId, String confirmationToken, Set<Role> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.enable = enable;
		this.emailId = emailId;
		this.createdDate = createdDate;
		this.socialId = socialId;
		this.statusId = statusId;
		this.confirmationToken = confirmationToken;
		this.roles = roles;
	}
	
}