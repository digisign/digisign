package com.example.digital.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class Role implements Serializable {

	public Role() {
		super();
	}
	@Id
	@Column(name="role_id",insertable=false,updatable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long role_id;
	@Column(name="role_name")
	private String role_name;
	@Column(name="role_desc")
	private String role_desc;
	
	@JsonIgnore
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	
	
   	public long getRole_id() {
		return role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	 
	    
	
	@Override
	public String toString() {
		return "Role [ role_id"+ role_id + "role_name"+ role_name + "role_desc"+ role_desc+  "]";
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	

}
