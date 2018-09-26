Create database if not exists digisign3;
use digisign3;

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
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=latin1;


alter table `user` auto_increment= 100001;

CREATE TABLE `role` (
  `role_id` bigint(10) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `role_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user_role` (
  `user_id` bigint(10) DEFAULT NULL,
  `role_id` bigint(10) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


drop table if exists contact;
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
) ENGINE=InnoDB AUTO_INCREMENT=200001 DEFAULT CHARSET=latin1;

alter table contact auto_increment= 200001;

drop table if exists  address_type;

CREATE TABLE `address_type` (
  `address_type` varchar(2) NOT NULL,
  `address_type_desc` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`address_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 drop table if exists contact_address;

CREATE TABLE `contact_address` (
  `contact_address_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `contact_id` bigint(10) DEFAULT NULL,
  `address_type` varchar(2) DEFAULT NULL,
  `address_1` varchar(500) DEFAULT NULL,
  `address_2` varchar(500) DEFAULT NULL,
  `address_3` varchar(500) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `postal_code` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`contact_address_id`),
  KEY `contact_id` (`contact_id`),
  KEY `address_type` (`address_type`),
  CONSTRAINT `contact_address_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  CONSTRAINT `contact_address_ibfk_2` FOREIGN KEY (`address_type`) REFERENCES `address_type` (`address_type`)
) ENGINE=InnoDB AUTO_INCREMENT=300001 DEFAULT CHARSET=latin1;

alter table contact_address auto_increment= 300001;

CREATE TABLE `learner` (
  `learner_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) DEFAULT NULL,
  `contact_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`learner_id`),
  KEY `user_id` (`user_id`),
  KEY `contact_id` (`contact_id`),
  CONSTRAINT `learner_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `learner_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=400001 DEFAULT CHARSET=latin1;


 alter table `learner`  auto_increment= 400001;


drop table if exists institution;

CREATE TABLE `institution` (
  `institution_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `contact_id` bigint(10) DEFAULT NULL,
  `parent_institution_id` bigint(10) DEFAULT NULL,
  `institution_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`institution_id`),
  UNIQUE KEY `inst_cont` (`contact_id`,`institution_name`),
  KEY `parent_institution_id` (`parent_institution_id`),
  CONSTRAINT `institution_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  CONSTRAINT `institution_ibfk_2` FOREIGN KEY (`parent_institution_id`) REFERENCES `institution` (`institution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=500001 DEFAULT CHARSET=latin1;

alter table institution auto_increment= 500001;

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

alter table institution_user auto_increment=600001;

CREATE TABLE `course` (
  `course_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(200) DEFAULT NULL,
  `short_name` varchar(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `institution_id` bigint(10) DEFAULT NULL,
  `course_period` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `inst_course` (`institution_id`,`course_name`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`institution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=700001 DEFAULT CHARSET=latin1;

alter table course auto_increment= 700001;

drop table if exists `subject`;

CREATE TABLE `subject` (
  `subject_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(200) DEFAULT NULL,
  `course_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `course_sub` (`course_id`,`subject_name`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
                                          
alter table `subject` auto_increment= 800001;   


CREATE TABLE `status` (
  `status_id` bigint(10) NOT NULL,
  `status_name` varchar(20) DEFAULT NULL,
  `status_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `credential` (
  `credential_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `credential_name` varchar(20) DEFAULT NULL,
  `credential_Year` date DEFAULT NULL,
  `course_id` bigint(10) DEFAULT NULL,
  `institution_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`credential_id`),
  KEY `course_id` (`course_id`),
  KEY `institution_id` (`institution_id`),
  CONSTRAINT `credential_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `credential_ibfk_2` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`institution_id`)
) ENGINE=InnoDB AUTO_INCREMENT=900001 DEFAULT CHARSET=latin1;


alter table credential auto_increment= 900001;   

drop table if exists grade;

CREATE TABLE `grade` (
  `grade_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `marks_type` (
  `marks_type_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `type_desc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`marks_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE `learner_credential` (
  `learner_credential_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `learner_id` bigint(10) DEFAULT NULL,
  `credential_id` bigint(10) DEFAULT NULL,
  `course_id` bigint(10) DEFAULT NULL,
  `grade_id` bigint(10) DEFAULT NULL,
  `marks_obtained` varchar(10) DEFAULT NULL,
  `marks_type_id` bigint(10) DEFAULT NULL,
  `total_marks` varchar(10) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `start_year` int(11) DEFAULT NULL,
  `end_year` int(11) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=1000001 DEFAULT CHARSET=latin1;

alter table `learner_credential` auto_increment= 1000001;   


 CREATE TABLE `learner_credential_resourse` (
  `learner_credential_id` bigint(10) DEFAULT NULL,
  `resource_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(20) NOT NULL,
  `file_type` varchar(45) DEFAULT NULL,
  `thumbnail_path` varchar(45) NOT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`resource_id`),
  UNIQUE KEY `resourse` (`file_path`),
  KEY `learner_credential_id` (`learner_credential_id`),
  KEY `learner_credential_resourse_ibfk_2_idx` (`status_id`),
  CONSTRAINT `learner_credential_resourse_ibfk_1` FOREIGN KEY (`learner_credential_id`) REFERENCES `learner_credential` (`learner_credential_id`),
  CONSTRAINT `learner_credential_resourse_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1100001 DEFAULT CHARSET=latin1;


alter table `learner_credential_resourse` auto_increment= 1100001;   

drop table if exists temporarydata;

create table temporarydata(
institution_name varchar(500),
mobile_number_1 varchar(20)unique,
mobile_number_2 varchar(20)unique,
email_id_1 varchar(50)unique,
email_id_2 varchar(50)unique,
address_1 varchar(500),
address_2 varchar(500),
address_3 varchar(500),
city varchar(50),
state varchar(50),
country varchar(20),
postal_code bigint(11));

drop table if exists error_table;

create table error_table(
institution_name varchar(500)unique,
mobile_number_1 varchar(20)unique,
mobile_number_2 varchar(20)unique,
email_id_1 varchar(50)unique,
email_id_2 varchar(50)unique,
address_1 varchar(500),
address_2 varchar(500),
address_3 varchar(500),
city varchar(50),
state varchar(50),
country varchar(20),
postal_code varchar(11));

drop table if exists tempcsdata;

create table tempcsdata(
institution_name varchar(500),
course_name varchar(200),
course_period varchar(4),
subject_name varchar(30) 
);

drop table if exists errorcsdata;

create table errorcsdata(
institution_name varchar(500),
course_name varchar(200),
course_period varchar(4),
subject_name varchar(30) 
);

Insert into marks_type  values(1,'Marks');
Insert into marks_type  values(2,'Grade');
Insert into marks_type  values(3,'CGPA');
Insert into marks_type  values(4,'Percentage');

create VieW institution_course_subject as
select ins.institution_id,ins.institution_name,co.course_id,co.course_name,co.course_period,sb.subject_id,sb.subject_name from institution as ins
join course as co on ins.institution_id=co.institution_id join `subject` as sb on co.course_id=sb.course_id;


create VieW `institution_contact` as
    select 
        `it`.`institution_id` as `institution_id`,
        `it`.`institution_name` as `institution_name`,
        `co`.`contact_id` as `contact_id`,
        `co`.`mobile_number_1` as `mobile_number`,
        `co`.`email_id_1` as `email_id`,
        `ca`.`contact_address_id` as `address_id`,
        `ca`.`address_type` as `address_type`,
        `ca`.`address_1` as `address`,
        `ca`.`city` as `city`,
        `ca`.`state` as `state`,
        `ca`.`country` as `country`,
        `ca`.`postal_code` as `postal_code`
    from
        ((`institution` `it`
        Join `contact` `co` on ((`it`.`contact_id` = `co`.`contact_id`)))
        Join `contact_address` `ca` on ((`ca`.`contact_id` = `co`.`contact_id`)));