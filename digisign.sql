Create database if not exists digisign;
use digisign;

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
) ;


alter table `user` auto_increment= 100001;



CREATE TABLE `role` (
  `role_id` bigint(10) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `role_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ;

CREATE TABLE `user_role` (
  `user_id` bigint(10) DEFAULT NULL,
  `role_id` bigint(10) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ;


drop table if exists contact;

create table if not exists contact(
contact_id bigint(10)  primary key auto_increment,
full_name varchar(500) ,
first_name varchar(20) ,
last_name varchar(20) ,
dob date,
mobile_number_1 varchar(20)unique,
mobile_number_2 varchar(20)unique,
email_id_1 varchar(50)unique,
email_id_2 varchar(50)unique);

alter table contact auto_increment= 200001;

drop table if exists  address_type;

create table if not exists address_type(
address_type varchar(2)  primary key,
address_type_desc varchar(15)
);

 drop table if exists contact_address;

create table if not exists contact_address(
address_id bigint(10)  primary key auto_increment,
contact_id bigint(10) ,
address_type varchar(2),
address_1 varchar(500),
address_2 varchar(500),
address_3 varchar(500),
city varchar(50),
state varchar(50),
country varchar(20),
postal_code bigint(11) ,
 foreign key(contact_id) references contact(contact_id),
foreign key(address_type) references address_type(address_type)
);

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
) ;


 alter table `learner`  auto_increment= 400001;


drop table if exists institution;

create table if not exists institution(
institution_id bigint(10)  primary key auto_increment,
contact_id bigint(10) ,
parent_institution_id bigint(10),
institution_name varchar(500),
foreign key(contact_id) references contact(contact_id),
foreign key(parent_institution_id) references institution(institution_id));

alter table institution auto_increment= 500001;

drop table if exists institution_user;

create table if not exists institution_user(
institution_user_id bigint(10) ,
institution_id bigint(10) ,
user_id bigint(10) ,
contact_id bigint(10),
primary key(institution_id,institution_user_id),
foreign key(user_id) references `user`(user_id),
foreign key(contact_id) references contact(contact_id));

alter table institution_user auto_increment=600001;

create table if not exists course(
course_id bigint(10)  primary key auto_increment,
course_name varchar(200) ,
short_name varchar(10),
description varchar(100),
institution_id bigint(10) ,
course_period varchar(4) ,
foreign key(institution_id) references institution(institution_id));

alter table course auto_increment= 700001;



drop table if exists `subject`;

create table if not exists `subject`(
subject_id bigint(10)   primary key auto_increment,
subject_name varchar(30) ,
course_id bigint(10) ,
foreign key(course_id) references course(course_id)
);
                                          
alter table `subject` auto_increment= 800001;   


CREATE TABLE `status` (
  `status_id` bigint(10) NOT NULL,
  `status_name` varchar(20) DEFAULT NULL,
  `status_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
);



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
) ;


alter table credential auto_increment= 900001;   

drop table if exists grade;

create table if not exists grade(
grade_id bigint(10)  primary key auto_increment,
grade_name varchar(20),
description varchar(20));



CREATE TABLE `learner_credential` (
  `learner_credential_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `learner_id` bigint(10) DEFAULT NULL,
  `credential_id` bigint(10) DEFAULT NULL,
  `course_id` bigint(10) DEFAULT NULL,
  `grade_id` bigint(10) DEFAULT NULL,
 `marks_obtained` varchar(10) DEFAULT NULL,
   total_marks varchar(10) DEFAULT NULL, 
  marks_type_id bigint(10) DEFAULT NULL,
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
) ;

alter table `learner_credential` auto_increment= 1000001;   

create table marks_type(
marks_type_id bigint(10)  PRIMARY KEY AUTO_INCREMENT,
type_desc  varchar(20)
 );

 CREATE TABLE `learner_credential_resourse` (
  `learner_credential_id` bigint(10) DEFAULT NULL,
  `resource_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(100) NOT NULL,
  `file_type` varchar(45) DEFAULT NULL,
  `thumbnail_path` varchar(45) NOT NULL,
  `status_id` bigint(20) DEFAULT NULL,
    created_date datetime,
  updated_date datetime,
  PRIMARY KEY (`resource_id`),
  UNIQUE KEY `resourse` (`file_path`),
  KEY `learner_credential_id` (`learner_credential_id`),
  KEY `learner_credential_resourse_ibfk_2_idx` (`status_id`),
  CONSTRAINT `learner_credential_resourse_ibfk_1` FOREIGN KEY (`learner_credential_id`) REFERENCES `learner_credential` (`learner_credential_id`),
  CONSTRAINT `learner_credential_resourse_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
);


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
