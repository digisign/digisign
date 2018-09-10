create database if not exists digisign;

use digisign;

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


drop table if exists `user`;

create table if not exists `user`(
id bigint(20)  primary key auto_increment,
user_name varchar(50)  not null,
`password` varchar(20)  not null,
email varchar(50)  unique not null,
created_date datetime,
salt varchar(60) not null,
social_id varchar(50) unique,
status_id varchar(20)
);

alter table `user` auto_increment= 100001;

drop table if exists `role`;

create table if not exists `role`(
id bigint(10)  primary key,
role_name varchar(20),
role_desc varchar(30)
);

drop table if exists user_role;

create table if not exists user_role(
user_id bigint(10) ,
role_id bigint(10) ,
foreign key(user_id) references `user`(id),
foreign key(role_id) references `role`(id)
);


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

drop table if exists learner;

create table if not exists learner(
learner_id bigint(10)  primary key auto_increment,
user_id bigint(10) ,
contact_id bigint(10) ,
foreign key(user_id) references user(user_id),
foreign key(contact_id) references contact(contact_id));

alter table learner auto_increment= 400001;

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

drop table if exists requester_user;

create table if not exists requester_user(
requester_id bigint(10)  primary key auto_increment,
user_id bigint(10) ,
contact_id bigint(10) ,
foreign key(user_id) references `user`(user_id),
foreign key(contact_id) references contact(contact_id));

alter table requester_user auto_increment= 700001;

drop table if exists request;

create table if not exists request(
request_id bigint(10)  primary key auto_increment,
requester_id bigint(10) ,
learner_id bigint(10) ,
status_id varchar(20),
foreign key(requester_id) references requester_user(requester_id),
foreign key(learner_id) references learner(learner_id)
);

alter table request auto_increment= 800001;

drop table if exists requester;

create table if not exists requester(
request_id bigint(10) ,
contact_id bigint(10) ,
foreign key(request_id) references request(request_id),
foreign key(contact_id) references contact(contact_id));


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


drop table if exists course;

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

drop table if exists grade;

create table if not exists grade(
grade_id bigint(10)  primary key,
grade_name varchar(20),
description varchar(20));


drop table if exists  subject_marks;

create table if not exists subject_marks
(  `learner_id` bigint(10)  , 
 `subject_id` bigint(10)  ,
course_id bigint(10)  ,
`Year` Year(4),
grade_id bigint(10),  
`marks` bigint(4) ,
foreign key(learner_id) references learner(learner_id),
foreign key(subject_id) references `subject`(subject_id),
foreign key(course_id) references course(course_id),
foreign key(grade_id) references grade(grade_id)
);

drop table if exists course_grade;

create table if not exists course_grade(
course_id bigint(10) ,
grade_id bigint(10),
foreign key(course_id) references course(course_id),
foreign key(grade_id) references grade(grade_id));

drop table if exists credential;

create table if not exists credential(
credential_id bigint(11)  primary key auto_increment,
credential_name varchar(20),
credential_Year date,
course_id bigint(10),
institution_id bigint(10),
foreign key(course_id) references course(course_id),
foreign key(institution_id) references institution(institution_id));

alter table credential auto_increment= 1100001;

drop table if exists  request_credential_list;

create table if not exists request_credential_list(
request_id bigint(10),
credential_id bigint(10),
foreign key(request_id) references request(request_id),
foreign key(credential_id) references credential(credential_id));

drop table if exists learner_credential;

create table if not exists learner_credential(
learner_credential_id bigint(10) primary key auto_increment,
learner_id bigint(10),
credential_id bigint(10),
course_id bigint(10),
grade_id bigint(10),
marks varchar(4),
issued_date date,
foreign key(learner_id) references learner(learner_id),
foreign key(credential_id) references credential(credential_id),
foreign key(course_id) references course(course_id),
foreign key(grade_id) references grade(grade_id));

alter table learner_credential auto_increment= 1200001;

drop table if exists learner_credential_resourse;

create table learner_credential_resourse(
learner_credential_id bigint(10),
resourse_id bigint(10)  primary key,
resourse varchar(20) unique,
foreign key(learner_credential_id) references learner_credential(learner_credential_id));

alter table learner_credential_resourse auto_increment= 1300001;

insert into address_type values('p','permanent');
insert into address_type values('t','temporary');
insert into address_type values('o','office');
insert into address_type values('H','Headoffice');
insert into address_type values('b','branchoffice');

insert into grade  values(1,'a','outstanding');
insert into grade  values(2,'b','excellent');
insert into grade  values(3,'c','good');
insert into grade  values(4,'d','average');
insert into grade  values(5,'e','accepted');
insert into grade  values(6,'f','satisfactory');

insert into `role` values (1,'learner','student');
insert into `role` values (2,'institute admin','credential issuing authority');
insert into `role` values (3,'requester','requesting for credential');


create VieW institution_course_subject as
select ins.institution_id,ins.institution_name,co.course_id,co.course_name,co.course_period,sb.subject_id,sb.subject_name from institution as ins
join course as co on ins.institution_id=co.institution_id join `subject` as sb on co.course_id=sb.course_id;

select * from institution_course_subject;

create VieW `institution_contact` as
    select 
        `it`.`institution_id` as `institution_id`,
        `it`.`institution_name` as `institution_name`,
        `co`.`contact_id` as `contact_id`,
        `co`.`mobile_number_1` as `mobile_number`,
        `co`.`email_id_1` as `email_id`,
        `ca`.`address_id` as `address_id`,
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
        
       
	create VieW `institution_course_details` as
    select 
        `iu`.`user_id` as `institution_user_id`,
        `iu`.`institution_id` as `institution_id`,
        `it`.`institution_name` as `institution_name`,
        `co`.`course_id` as `course_id`,
        `co`.`course_name` as `course_name`,
        `co`.`course_period` as `course_period`,
        `sb`.`subject_id` as `subject_id`,
        `sb`.`subject_name` as `subject_name`
    from
        (((`institution_user` `iu`
        Join `contact` `cn` on ((`iu`.`contact_id` = `cn`.`contact_id`)))
        Join `institution` `it` on ((`it`.`contact_id` = `cn`.`contact_id`)))
        Join `course` `co` on ((`it`.`institution_id` = `co`.`institution_id`)))
        Join `subject` `sb` on ((`sb`.`course_id` = `co`.`course_id`));
        
        create VieW `institution_user_details` as
    select 
        `iu`.`user_id` as `user_id`,
        `co`.`contact_id` as `contact_id`,
        `iu`.`institution_id` as `institution_id`,
        `it`.`institution_name` as `institution_name`,
        `iu`.`institution_user_id` as `institution_user_id`,
        `co`.`full_name` as `institution_username`,
        `co`.`mobile_number_2` as `institution_user_mobile_number`,
        `co`.`email_id_2` as `institution_user_email_id`,
        `ca`.`address_id` as `institution_address_id`,
        `ca`.`address_type` as `address_type`,
        `ca`.`address_1` as `institution_address`,
        `ca`.`city` as `city`,
        `ca`.`state` as `state`,
        `ca`.`country` as `country`,
        `ca`.`postal_code` as `postal_code`
    from
        (((`institution_user` `iu`
        Join `contact` `co` on ((`iu`.`contact_id` = `co`.`contact_id`)))
        Join `institution` `it` on ((`it`.`contact_id` = `co`.`contact_id`)))
        Join `contact_address` `ca` on ((`co`.`contact_id` = `ca`.`contact_id`)));
        
        
        create VieW `learner_marks` as
    select 
        `ln`.`learner_id` as `learner_id`,
        `cn`.`full_name` as `learner_name`,
        `lc`.`learner_credential_id` as `learner_credential_id`,
        `lc`.`course_id` as `course_id`,
        `co`.`course_name` as `course_name`,
        `co`.`course_period` as `course_period`,
        `sb`.`subject_id` as `subject_id`,
        `sb`.`subject_name` as `subject_name`,
        `lc`.`grade_id` as `grade_id`,
        `lc`.`marks` as `marks`,
        `sm`.`Year` as `year`
    from
        (((((`learner` `ln`
        Join `contact` `cn` on ((`ln`.`contact_id` = `cn`.`contact_id`)))
        Join `learner_credential` `lc` on ((`lc`.`learner_id` = `ln`.`learner_id`)))
        Join `course` `co` on ((`lc`.`course_id` = `co`.`course_id`)))
        Join `subject` `sb` on ((`co`.`course_id` = `sb`.`course_id`)))
        Join `subject_marks` `sm` on ((`sb`.`subject_id` = `sm`.`subject_id`)));
        
        create VieW `learner_user_details` as
    select 
        `us`.`user_id` as `user_id`,
        `co`.`contact_id` as `contact_id`,
        `lr`.`learner_id` as `learner_id`,
        `co`.`full_name` as `learner_name`,
        `co`.`dob` as `dob`,
        `co`.`mobile_number_1` as `mobile_number_1`,
        `co`.`email_id_1` as `email_id_1`,
        `ca`.`address_id` as `address_id`,
        `ca`.`address_type` as `address_type`,
        `ca`.`address_1` as `address_1`,
        `ca`.`city` as `city`,
        `ca`.`state` as `state`,
        `ca`.`country` as `country`,
        `ca`.`postal_code` as `postal_code`
    from
        (((`user` `us`
        Join `learner` `lr` on ((`us`.`user_id` = `lr`.`user_id`)))
        Join `contact` `co` on ((`lr`.`contact_id` = `co`.`contact_id`)))
        Join `contact_address` `ca` on ((`co`.`contact_id` = `ca`.`contact_id`)));
        
        create VieW `requester_credential` as
    select 
        `rt`.`requester_id` as `requester_id`,
        `co`.`full_name` as `requester_name`,
        `ru`.`request_id` as `request_id`,
        `ru`.`learner_id` as `learner_id`,
        `cr`.`institution_id` as `institution_id`,
        `it`.`institution_name` as `institution_name`,
        `cr`.`credential_id` as `credential_id`,
        `cr`.`credential_name` as `credential_name`,
        `cr`.`credential_Year` as `credential_year`,
        `cr`.`course_id` as `course_id`,
        `lc`.`grade_id` as `grade_id`,
        `lc`.`marks` as `total_marks`,
        `lc`.`issued_date` as `issued_date`
    from
        (((((`requester_user` `rt`
        Join `contact` `co` on ((`rt`.`contact_id` = `co`.`contact_id`)))
        Join `request` `ru` on ((`ru`.`requester_id` = `rt`.`requester_id`)))
        Join `learner_credential` `lc` on ((`lc`.`learner_id` = `ru`.`learner_id`)))
        Join `credential` `cr` on ((`cr`.`course_id` = `lc`.`course_id`)))
        Join `institution` `it` on ((`it`.`institution_id` = `cr`.`institution_id`)));
        
        create VieW `requester_user_details` as
    select 
        `us`.`user_id` as `user_id`,
        `ru`.`contact_id` as `contact_id`,
        `ru`.`requester_id` as `requester_id`,
        `co`.`full_name` as `requester_name`,
        `co`.`mobile_number_1` as `mobile_number_1`,
        `co`.`email_id_1` as `email_id_1`,
        `ca`.`address_id` as `address_id`,
        `ca`.`address_type` as `address_type`,
        `ca`.`address_1` as `address_1`,
        `ca`.`city` as `city`,
        `ca`.`state` as `state`,
        `ca`.`country` as `country`,
        `ca`.`postal_code` as `postal_code`
    from
        (((`requester_user` `ru`
        Join `user` `us` on ((`ru`.`user_id` = `us`.`user_id`)))
        Join `contact` `co` on ((`ru`.`contact_id` = `co`.`contact_id`)))
        Join `contact_address` `ca` on ((`co`.`contact_id` = `ca`.`contact_id`)));
        
        
        
        
        create VieW `institutecontactaddress` as
    select 
        `it`.`institution_id` as `institution_id`,
        `it`.`institution_name` as `institution_name`,
        `co`.`contact_id` as `contact_id`,
        `co`.`mobile_number_1` as `mobile_number_1`,
        `co`.`mobile_number_2` as `mobile_number_2`,
        `co`.`email_id_1` as `email_id_1`,
        `co`.`email_id_2` as `email_id_2`,
        `ca`.`address_1` as `address_1`,
        `ca`.`address_2` as `address_2`,
        `ca`.`address_3` as `address_3`,
        `ca`.`city` as `city`,
        `ca`.`state` as `state`,
        `ca`.`country` as `country`,
        `ca`.`postal_code` as `postal_code`
    from
        ((`institution` `it`
        Join `contact` `co` on ((`it`.`contact_id` = `co`.`contact_id`)))
        Join `contact_address` `ca` on ((`ca`.`contact_id` = `co`.`contact_id`)))
        
        
        
