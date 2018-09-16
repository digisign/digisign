package com.example.digital.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonView;

@SuppressWarnings("serial")
@Entity
@Table(name="learner_credential_resourse")
public class LearnerCredentialResource implements Serializable {

	public LearnerCredentialResource() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_id")
	private Long resourceId;
	@JoinColumn(name="learner_credential_id")
	@OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private LearnerCredential learnerCredential;
	@Column(name="file_path")
	private String filePath;
	@Column(name="file_type")
	private String fileType;
	@Column(name="thumbnail_path")
	private String thumbNailPath;
	@JoinColumn(name="status_id")
	@OneToOne( fetch = FetchType.LAZY)
	private Status status;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public LearnerCredential getLearnerCredential() {
		return learnerCredential;
	}

	public void setLearnerCredential(LearnerCredential learnerCredential) {
		this.learnerCredential = learnerCredential;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getThumbNailPath() {
		return thumbNailPath;
	}

	public void setThumbNailPath(String thumbNailPath) {
		this.thumbNailPath = thumbNailPath;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
