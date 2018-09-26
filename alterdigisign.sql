SET SQL_SAFE_UPDATES=0;

DELETE  FROM digisign3.institution;

DELETE  FROM digisign3.contact;

DELETE  FROM digisign3.contact_address;

ALTER TABLE digisign3.institution
ADD CONSTRAINT inst_cont UNIQUE (contact_id,institution_name);

ALTER TABLE digisign3.course
ADD CONSTRAINT inst_course UNIQUE (institution_id,course_name);

ALTER TABLE digisign3.subject
ADD CONSTRAINT course_sub UNIQUE (course_id,subject_name);