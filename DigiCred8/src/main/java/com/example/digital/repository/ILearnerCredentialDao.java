package com.example.digital.repository;

import java.sql.Date;
import java.util.List;

import com.example.digital.entity.Course;
import com.example.digital.entity.Credential;
import com.example.digital.entity.Grade;
import com.example.digital.entity.Learner;
import com.example.digital.entity.Learner_Credential;


public interface ILearnerCredentialDao {

	List<Learner_Credential> getAllLearner_Credentials();
	Learner_Credential getLearner_CredentialByid(long learner_credential_Id);
    void addLearner_Credential(Learner_Credential learner_credential);
    void updateLearner_Credential(Learner_Credential learner_credential);
    //void deleteLearner_Credential(Learner_Credential learner_Credential);
    boolean Learner_CredentialExists(Learner learner, Credential credential,Course course,Grade grade,String marks,Date issued_date);
	
}
