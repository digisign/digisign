package com.example.digital.repository;

import javax.transaction.Transactional;

import com.example.digital.entity.LearnerCredentialResource;


@Transactional
public interface ILearner_Credential_ResourseDao  {

	public LearnerCredentialResource findByresourseId(long resourseId);

	public void save(LearnerCredentialResource filemode);
}
