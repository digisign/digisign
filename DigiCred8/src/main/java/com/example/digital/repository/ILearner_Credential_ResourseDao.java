package com.example.digital.repository;

import javax.transaction.Transactional;

import com.example.digital.entity.Learner_Credential_Resourse;

@Transactional
public interface ILearner_Credential_ResourseDao  {

	public Learner_Credential_Resourse findByresourseId(long resourseId);

	public void save(Learner_Credential_Resourse filemode);
}
