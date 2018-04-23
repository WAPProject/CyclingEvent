create table user(
id int primary key auto_increment,
username varchar(64) ,
password varchar(64),
name varchar(64) ,
email varchar(128)
);
INSERT INTO `user` VALUES (1, 'bigdragon', '1', 'yanlong', '1@qq.com');
INSERT INTO `user` VALUES (2, 'michael', '2', 'Jordan', '2@qq.com');
create table ride(
id int primary key auto_increment,
route varchar(128) ,
creatoruserid varchar(64),
status varchar(64),
currentlocation varchar(64),
begindate timestamp
);
INSERT INTO `ride` VALUES (1, 'F to O', '1', 'notstart', NULL, '2018-5-1 01:59:48');
INSERT INTO `ride` VALUES (2, 'Ottumwa to Demoine', '1', 'notstart', NULL, '2018-5-5 02:00:36');
create table user_ride(
id int primary key auto_increment,
userid varchar(64),
rideid varchar(64)
);
INSERT INTO `user_ride` VALUES (1, '1', '1');
INSERT INTO `user_ride` VALUES (2, '2', '1');
