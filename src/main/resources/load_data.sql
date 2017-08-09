### student ###
INSERT INTO student(student_id, name, sex, student_type, verify_state) VALUES(3903150326, '李涛江', 1, 0, 0);
INSERT INTO student(student_id, name, sex, student_type, verify_state) VALUES(3903150332, '葛凡', 1, 0, 0);
INSERT INTO student(student_id, name, sex, student_type, verify_state) VALUES(3903150327, '陈铭明', 1, 0, 0);

### signon ###
INSERT INTO signon(student_id, password) VALUE(3903150326,  '3903150326');
INSERT INTO signon(student_id, password) VALUE(3903150332,  '3903150332');
INSERT INTO signon(student_id, password) VALUE(3903150327,  '3903150327');

### teacher ###
INSERT INTO teacher(name, username, password, phone, majors, role) VALUES('罗俊', 'lj', 'lj@software', '15166669999', '软件工程', 0);
INSERT INTO teacher(name, username, password, phone, majors, role) VALUES('史书记', 'sjq', 'sjq@software', '15166889999', '软件工程', 1);