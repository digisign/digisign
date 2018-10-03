Create database if not exists digisign;
use digisign;

Drop table if exists `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `salt` varchar(60) NOT NULL,
  `social_id` varchar(50) DEFAULT NULL,
  `status_id` varchar(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `social_id` (`social_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

Drop table if exists `role`;

CREATE TABLE `role` (
  `role_id` bigint(10) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `role_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

Drop table if exists user_role;

CREATE TABLE `user_role` (
  `user_id` bigint(10) DEFAULT NULL,
  `role_id` bigint(10) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

Drop table if exists Contact;

CREATE TABLE `contact` (
  `contact_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(500) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `mobile_number_1` varchar(20) DEFAULT NULL,
  `mobile_number_2` varchar(20) DEFAULT NULL,
  `email_id_1` varchar(50) DEFAULT NULL,
  `email_id_2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  UNIQUE KEY `mobile_number_1` (`mobile_number_1`),
  UNIQUE KEY `mobile_number_2` (`mobile_number_2`),
  UNIQUE KEY `email_id_1` (`email_id_1`),
  UNIQUE KEY `email_id_2` (`email_id_2`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

Drop table if exists  Address_Type;

CREATE TABLE `address_type` (
  `address_type` varchar(2) NOT NULL,
  `address_type_desc` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`address_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

Drop table if exists Contact_Address;

CREATE TABLE `contact_address` (
  `address_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `contact_id` bigint(10) DEFAULT NULL,
  `address_type` varchar(2) DEFAULT NULL,
  `address_1` varchar(500) DEFAULT NULL,
  `address_2` varchar(500) DEFAULT NULL,
  `address_3` varchar(500) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `postal_code` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `contact_id` (`contact_id`),
  KEY `address_type` (`address_type`),
  CONSTRAINT `contact_address_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  CONSTRAINT `contact_address_ibfk_2` FOREIGN KEY (`address_type`) REFERENCES `address_type` (`address_type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

Drop table if exists learner;

CREATE TABLE `learner` (
  `learner_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) DEFAULT NULL,
  `contact_id` bigint(10) DEFAULT NULL,
  `aadhar_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`learner_id`),
  KEY `user_id` (`user_id`),
  KEY `contact_id` (`contact_id`),
  CONSTRAINT `learner_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `learner_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

Drop table if exists institution;

CREATE TABLE `institution` (
  `institution_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `contact_id` bigint(10) DEFAULT NULL,
  `parent_institution_id` bigint(10) DEFAULT NULL,
  `institution_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`institution_id`),
  KEY `contact_id` (`contact_id`),
  KEY `institution_ibfk_2_idx` (`parent_institution_id`),
  CONSTRAINT `institution_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  CONSTRAINT `institution_ibfk_2` FOREIGN KEY (`parent_institution_id`) REFERENCES `institution` (`institution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;

drop table if exists institution_user;

CREATE TABLE `institution_user` (
  `institution_user_id` bigint(10) NOT NULL,
  `institution_id` bigint(10) NOT NULL,
  `user_id` bigint(10) DEFAULT NULL,
  `contact_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`institution_id`,`institution_user_id`),
  KEY `user_id` (`user_id`),
  KEY `contact_id` (`contact_id`),
  CONSTRAINT `institution_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `institution_user_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

Drop table if exists course;

CREATE TABLE `course` (
  `course_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(200) DEFAULT NULL,
  `short_name` varchar(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `institution_id` bigint(10) DEFAULT NULL,
  `course_period` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `institution_id` (`institution_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`institution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=latin1;

drop table if exists `subject`;

CREATE TABLE `subject` (
  `subject_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(100) DEFAULT NULL,
  `course_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=latin1;

drop table if exists `status`;

CREATE TABLE `status` (
  `status_id` bigint(10) NOT NULL,
  `status_name` varchar(20) DEFAULT NULL,
  `status_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists `credential`;

CREATE TABLE `credential` (
  `credential_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `credential_name` varchar(100) DEFAULT NULL,
  `credential_Year` int(11) DEFAULT NULL,
  `course_id` bigint(10) DEFAULT NULL,
  `institution_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`credential_id`),
  KEY `course_id` (`course_id`),
  KEY `institution_id` (`institution_id`),
  CONSTRAINT `credential_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `credential_ibfk_2` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`institution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=900052 DEFAULT CHARSET=latin1;

drop table if exists grade;

CREATE TABLE `grade` (
  `grade_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `course_grade` (
  `course_id` bigint(10) DEFAULT NULL,
  `grade_id` bigint(10) DEFAULT NULL,
  KEY `grade_id` (`grade_id`),
  KEY `course_grade_ibfk_1_idx` (`course_id`),
  CONSTRAINT `course_grade_ibfk_2` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists marks_type;

CREATE TABLE `marks_type` (
  `marks_type_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `type_desc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`marks_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

drop table if exists learner_credential;

CREATE TABLE `learner_credential` (
  `learner_credential_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `learner_id` bigint(10) DEFAULT NULL,
  `credential_id` bigint(10) DEFAULT NULL,
  `course_id` bigint(10) DEFAULT NULL,
  `grade_id` bigint(10) DEFAULT NULL,
  `marks_obtained` varchar(10) DEFAULT NULL,
  `marks_type_id` bigint(10) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `start_year` int(11) DEFAULT NULL,
  `end_year` int(11) DEFAULT NULL,
  `total_marks` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`learner_credential_id`),
  KEY `learner_id` (`learner_id`),
  KEY `credential_id` (`credential_id`),
  KEY `grade_id` (`grade_id`),
  KEY `course_id` (`course_id`),
  KEY `marks_type_id` (`marks_type_id`),
  CONSTRAINT `learner_credential_ibfk_1` FOREIGN KEY (`learner_id`) REFERENCES `learner` (`learner_id`),
  CONSTRAINT `learner_credential_ibfk_2` FOREIGN KEY (`credential_id`) REFERENCES `credential` (`credential_id`),
  CONSTRAINT `learner_credential_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `learner_credential_ibfk_4` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`),
  CONSTRAINT `learner_credential_ibfk_5` FOREIGN KEY (`marks_type_id`) REFERENCES `marks_type` (`marks_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000390 DEFAULT CHARSET=latin1;

drop table if exists learner_credential_resourse;

CREATE TABLE `learner_credential_resourse` (
  `learner_credential_id` bigint(10) DEFAULT NULL,
  `resource_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(100) NOT NULL,
  `file_type` varchar(100) DEFAULT NULL,
  `thumbnail_path` varchar(100) NOT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`),
  UNIQUE KEY `resourse` (`file_path`),
  KEY `learner_credential_id` (`learner_credential_id`),
  KEY `learner_credential_resourse_ibfk_2_idx` (`status_id`),
  CONSTRAINT `learner_credential_resourse_ibfk_1` FOREIGN KEY (`learner_credential_id`) REFERENCES `learner_credential` (`learner_credential_id`),
  CONSTRAINT `learner_credential_resourse_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1100384 DEFAULT CHARSET=latin1;






