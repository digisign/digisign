insert ignore into contact (full_name, mobile_number_1,mobile_number_2,email_id_1,email_id_2) values(?,?,?,?,?)

insert ignore into contact (full_name, mobile_number_1,mobile_number_2,email_id_1,email_id_2) values(MIT College of Engineering,2030273400,2030273677,mitcoe@mitpune.com,null);
insert ignore into contact (full_name, mobile_number_1,mobile_number_2,email_id_1,email_id_2) values(Lovely Professional University,1824404404,18001024431,info@lpu.co. in,admissions@lpu.co.in);
insert ignore into contact (full_name, mobile_number_1,mobile_number_2,email_id_1,email_id_2) values(Banasthali Vidyapith Banasthali,1438228383,1438228787,saditya@banasthali.ac.in,adityashastri@yahoo com);
insert ignore into contact (full_name, mobile_number_1,mobile_number_2,email_id_1,email_id_2) values(Jindal School of Art and Architecture,1304091800,1304091801,info@jsaa.edu.in,null);
insert ignore into contact (full_name, mobile_number_1,mobile_number_2,email_id_1,email_id_2) values(Vellore Institute of echnology,4439931555,4439931003
,admin.chennai@vit.ac.in ,admission.chennai@vit.ac.in);



insert ignore into contact_address ( address_1, address_2, address_3, city, state, postal_code, country, contact_id) values(?,?,?,?,?,?,?,?)

insert ignore into contact_address ( address_1, city, state, postal_code, country, contact_id) values(Survey No  124  Paud Rd  Rambaug Colony  Kothrud,Pune
,Maharashtra,411038,India,1);
insert ignore into contact_address ( address_1, city, state, postal_code, country, contact_id) values(Lovely Professional University  Jalandhar, Jalandhar
,Punjab,144411,India,2);
insert ignore into contact_address ( address_1, city, state, postal_code, country, contact_id) values(Niwai Jodhpuriya Road  Vanasthali,Vanasthali,Rajasthan,304022
,India,3);
insert ignore into contact_address ( address_1, city, state, postal_code, country, contact_id) values(Sonipat Narela Road  Near Jagdishpur,Delhi,NCR,131001,India,4);
insert ignore into contact_address ( address_1, city, state, postal_code, country, contact_id) values(Vandalur Kelambakkam Road,Chennai,Tamil Nadu,600127,India,5);


insert ignore into institution ( contact_id , institution_name) values(?,?)

insert ignore into institution ( contact_id , institution_name) values(1,MIT College of Engineering);
insert ignore into institution ( contact_id , institution_name) values(2,Lovely Professional University);	
insert ignore into institution ( contact_id , institution_name) values(3,Banasthali Vidyapith  Banasthali);
insert ignore into institution ( contact_id , institution_name) values(4,Jindal School of Art and Architecture);
insert ignore into institution ( contact_id , institution_name) values(5,Vellore Institute of Technology);


insert ignore into course (course_name,course_Period,institution_id) values(?,?,?)

insert ignore into course (course_name,course_Period,institution_id) values(B.Tech in Computer Science & Engineering,4 Years,101);
insert ignore into course (course_name,course_Period,institution_id) values( B.Tech in Civil Engineering,4 Years,101);
insert ignore into course (course_name,course_Period,institution_id) values( B.Tech in Electrical Engineering,4 Years,102);
insert ignore into course (course_name,course_Period,institution_id) values( B.Tech in Electronics & Communication Engineering,4 Years,102);
insert ignore into course (course_name,course_Period,institution_id) values( B.Tech in Mechanical Engineering (Automobile/Production),4 Years,103);
insert ignore into course (course_name,course_Period,institution_id) values(  B.Tech (Computer Science Engineering),4 Years,104);
insert ignore into course (course_name,course_Period,institution_id) values(  B.Tech ( B.Tech (Mechanical Engineering)),4 Years,104);	
insert ignore into course (course_name,course_Period,institution_id) values(  Bachelor of Architecture,4 Years,105);	


insert ignore into subject (subject_Name, course_id) values(?,?)

insert ignore into subject (subject_Name, course_id) values(Mathematics-I,101);
insert ignore into subject (subject_Name, course_id) values(Modern Physics/General Chemistry,101);
insert ignore into subject (subject_Name, course_id) values(Basic Electrical Engineering/Basic Electronics Engineering,101);
insert ignore into subject (subject_Name, course_id) values(Computer System & Programming in C/Engineering Mechanics,101);
insert ignore into subject (subject_Name, course_id) values(Environmental Science/Sociology and Psychology,102);
insert ignore into subject (subject_Name, course_id) values(Computer System & Programming Lab/ Engineering Mechanics Lab,102);
insert ignore into subject (subject_Name, course_id) values(Electrical Engineering Lab/ Electronics Engineering Lab,102);
insert ignore into subject (subject_Name, course_id) values(Computer Aided  EngineeringGraphics Lab/ Product Realization through Manufacturing,103);
insert ignore into subject (subject_Name, course_id) values(Modern Physics Lab/ General Chemistry Lab,103);
insert ignore into subject (subject_Name, course_id) values(Life Skill (Communication Skill),103);
insert ignore into subject (subject_Name, course_id) values(Mathematics-II,104);
insert ignore into subject (subject_Name, course_id) values(Modern Physics/General Chemistry,104);
insert ignore into subject (subject_Name, course_id) values(Basic Electrical Engineering/Basic Electronics Engineering,104);
insert ignore into subject (subject_Name, course_id) values(Computer System & Programming in C/Engineering Mechanics,105);
insert ignore into subject (subject_Name, course_id) values(Environmental Science/Sociology and Psychology,105);

insert into grade  values(1,'a','outstanding');
insert into grade  values(2,'b','excellent');
insert into grade  values(3,'c','good');
insert into grade  values(4,'d','average');
insert into grade  values(5,'e','accepted');
insert into grade  values(6,'f','satisfactory');

insert into course_grade (course_id,grade_id) values (101,1);
insert into course_grade (course_id,grade_id) values (101,2);
insert into course_grade (course_id,grade_id) values (101,3);
insert into course_grade (course_id,grade_id) values (101,4);
insert into course_grade (course_id,grade_id) values (101,5);
insert into course_grade (course_id,grade_id) values (101,6);
insert into course_grade (course_id,grade_id) values (102,1);
insert into course_grade (course_id,grade_id) values (102,2);
insert into course_grade (course_id,grade_id) values (102,3);
insert into course_grade (course_id,grade_id) values (102,4);
insert into course_grade (course_id,grade_id) values (102,5);
insert into course_grade (course_id,grade_id) values (102,6);
insert into course_grade (course_id,grade_id) values (103,1);
insert into course_grade (course_id,grade_id) values (103,2);
insert into course_grade (course_id,grade_id) values (103,3);
insert into course_grade (course_id,grade_id) values (103,4);
insert into course_grade (course_id,grade_id) values (103,5);
insert into course_grade (course_id,grade_id) values (103,1);
insert into course_grade (course_id,grade_id) values (103,2);
insert into course_grade (course_id,grade_id) values (103,3);
insert into course_grade (course_id,grade_id) values (103,4);
insert into course_grade (course_id,grade_id) values (103,5);
insert into course_grade (course_id,grade_id) values (103,6);
insert into course_grade (course_id,grade_id) values (104,1);
insert into course_grade (course_id,grade_id) values (104,2);
insert into course_grade (course_id,grade_id) values (104,3);
insert into course_grade (course_id,grade_id) values (104,4);
insert into course_grade (course_id,grade_id) values (104,5);
insert into course_grade (course_id,grade_id) values (104,6);
insert into course_grade (course_id,grade_id) values (105,1);
insert into course_grade (course_id,grade_id) values (105,2);
insert into course_grade (course_id,grade_id) values (105,3);
insert into course_grade (course_id,grade_id) values (105,4);
insert into course_grade (course_id,grade_id) values (105,5);
insert into course_grade (course_id,grade_id) values (105,6);


































