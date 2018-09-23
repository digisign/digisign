package com.example.digital.entity;


import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")

//@Entity
//@Table(name = "user_role")
@Embeddable
public class UserRole implements Serializable {

	public UserRole() {
		super();
	}

	@Column(name="user_id")
	private Long userId;
	@Column(name="role_id")
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
