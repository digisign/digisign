
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
) ENGINE=InnoDB AUTO_INCREMENT=100002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `role` (
  `role_id` bigint(10) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `role_desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_role` (
  `user_id` bigint(10) DEFAULT NULL,
  `role_id` bigint(10) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


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

alter table course auto_increment= 900001;



drop table if exists `subject`;

create table if not exists `subject`(
subject_id bigint(10)   primary key auto_increment,
subject_name varchar(30) ,
course_id bigint(10) ,
foreign key(course_id) references course(course_id)
);

alter table `subject` add foreign key (course_id) references course(course_id);
                                          
alter table `subject` auto_increment= 1000001;                                          
