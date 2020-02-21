DROP TABLE IF EXISTS permission;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS role_permission;

CREATE TABLE permission (
  id INT NOT NULL,
  permission_name VARCHAR(50) NOT NULL
);

CREATE TABLE role (
  id INT NOT NULL,
  role_name VARCHAR(50) NOT NULL
);
 



CREATE TABLE users(
 id INT NOT NULL,
 name VARCHAR(50) NOT NULL,
 last_name VARCHAR(50) ,
 email_id VARCHAR(50)  NOT NULL,
 password VARCHAR(1000) NOT NULL,
 mobile VARCHAR(50) ,
 country VARCHAR(50),
 user_type VARCHAR(50),
 is_two_fa_enabled VARCHAR(1),
 two_fa_code VARCHAR(50),
 two_fa_expire_time VARCHAR(50),
 two_fa_type VARCHAR(50)
);

CREATE TABLE role_permission(
  id INT  NOT NULL,
  role_id int,
  foreign key(role_id) references role(id),
  permission_id int,
  foreign key (permission_id) references permission(id)
  );

CREATE TABLE role_users(
  id INT NOT NULL,
  role_id int,
  foreign key(role_id) references role(id),
  user_id int,
  foreign key (user_id) references users(id)
);



insert into permission (id,permission_name) values (1,'view_permission');
insert into permission (id,permission_name) values (2,'create_role');
insert into permission (id,permission_name) values (3,'edit_role');
insert into permission (id,permission_name) values (4,'view_role');
insert into permission (id,permission_name) values (5,'delete_role');
insert into permission (id,permission_name) values (6,'assign_permissions_to_role');
insert into permission (id,permission_name) values (7,'view_permissions_by_role');
insert into permission (id,permission_name) values (8,'create_users');
insert into permission (id,permission_name) values (9,'edit_users');
insert into permission (id,permission_name) values (10,'view_users');
insert into permission (id,permission_name) values (11,'delete_users');
insert into permission (id,permission_name) values (12,'assign_users_to_role');
insert into permission (id,permission_name) values (13,'view_users_by_role');

INSERT INTO role (ID, ROLE_NAME) VALUES (1, 'ADMINISTRATOR'), (2, 'AUDITOR');

insert into role_permission (id,role_id,permission_id) values (1,1,1);
insert into role_permission (id,role_id,permission_id) values (2,1,2);
insert into role_permission (id,role_id,permission_id) values (3,1,3);
insert into role_permission (id,role_id,permission_id) values (4,1,4);
insert into role_permission (id,role_id,permission_id) values (5,1,5);
insert into role_permission (id,role_id,permission_id) values (6,1,6);
insert into role_permission (id,role_id,permission_id) values (7,1,7);
insert into role_permission (id,role_id,permission_id) values (8,1,8);
insert into role_permission (id,role_id,permission_id) values (9,1,9);
insert into role_permission (id,role_id,permission_id) values (10,1,10);
insert into role_permission (id,role_id,permission_id) values (11,1,11);
insert into role_permission (id,role_id,permission_id) values (12,1,12);
insert into role_permission (id,role_id,permission_id) values (13,1,13);

insert into role_permission (id,role_id,permission_id) values (14,2,4);
insert into role_permission (id,role_id,permission_id) values (15,2,7);
insert into role_permission (id,role_id,permission_id) values (16,2,10);

insert into users(id,name,last_name,email_id,password,mobile,country,user_type,is_two_fa_enabled,two_fa_type) values
(1,'Subhajit','Goswami','subhajitbumba697@gmail.com','$2a$10$H21JxespaON3DuY1/aVtXe8u4jOpaNnkKcBb2AzEqgDNcPYXqVfZC','+447469454579','UK','super_admin','Y','email');
insert into users(id,name,last_name,email_id,password,mobile,country,user_type,is_two_fa_enabled,two_fa_type) values
(2,'Bumba','Goswami','bumba697@gmail.com','$2a$10$H21JxespaON3DuY1/aVtXe8u4jOpaNnkKcBb2AzEqgDNcPYXqVfZC','+917676984200','Ind','admin','Y','sms');

insert into role_users (id,role_id,user_id) values (1,1,1);
insert into role_users (id,role_id,user_id) values (2,2,2);

