package com.example.digital.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_recovery")
public class UserRecovery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_rec_id", nullable = false, updatable = false)
	private Long userRecId;
	
	@JoinColumn(name="user_id")
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private User user;
	
	@Column(name="token",nullable = false)
	private String token;
	
	@Column(name="validity_duration")
	private Integer validityDuration;
	@Column(name="issued_time")
	private Date issuedTime;
	
	@Column(name="created_date",nullable = false)
	private Date createdDate;
	@Column(name="updated_date",nullable = false)
	private Date updatedDate;
	@Column(name="is_validated")
	private boolean validated;
	public Long getUserRecId() {
		return userRecId;
	}
	public void setUserRecId(Long userRecId) {
		this.userRecId = userRecId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getValidityDuration() {
		return validityDuration;
	}
	public void setValidityDuration(Integer validityDuration) {
		this.validityDuration = validityDuration;
	}
	public Date getIssuedTime() {
		return issuedTime;
	}
	public void setIssuedTime(Date issuedTime) {
		this.issuedTime = issuedTime;
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

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}
}
