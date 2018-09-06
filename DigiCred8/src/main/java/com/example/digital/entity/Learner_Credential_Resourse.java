package com.example.digital.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonView;

@SuppressWarnings("serial")
@Entity
@Table(name="Learner_Credential_Resourse")
public class Learner_Credential_Resourse implements Serializable {

	
	
	public Learner_Credential_Resourse() {
		super();
	}

	public Learner_Credential_Resourse(
			String fileName, String fileType,String resourse) {
		super();
		this.resourse = resourse;
		this.fileName = fileName;
		this.fileType = fileType;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="r_id")
	@JsonView(View.FileInfo.class)
	private long resourseId;

	@JoinColumn(name="Learner_Credential_Id")
	@ManyToOne( fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Learner_Credential learnerCredential;
	
	@Lob
	@Column(name="Resourse")
	private String resourse;
	
	@JsonView(View.FileInfo.class)
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_type")
	private String fileType;

	public Learner_Credential getLearnerCredential() {
		return learnerCredential;
	}

	public void setLearnerCredential(Learner_Credential learnerCredential) {
		this.learnerCredential = learnerCredential;
	}

	public String getResourse() {
		return resourse;
	}

	public void setResourse(String resourse) {
		this.resourse = resourse;
	}

	



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getFileType() {
		return fileType;
	}



	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getResourseId() {
		return resourseId;
	}

	public void setResourseId(long resourseId) {
		this.resourseId = resourseId;
	}

	
}
