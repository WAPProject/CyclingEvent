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
begindate timestamp,
banner varchar(64)
);
INSERT INTO `ride` VALUES (1, 'F to O', '1', 'flag', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (2, 'Ottumwa to Demoine', '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (9, '123', '1', 'end', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (10, 'michael s 2 ride', '2', 'flag', NULL, '2018-4-24 13:49:31', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (11, '22222 ride', '1', 'flag', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (12, 'asd', '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (13, NULL, '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (14, NULL, '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (15, '123123', '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (16, '123123', '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (17, '123123', '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (18, '213123123', '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');
INSERT INTO `ride` VALUES (19, '到让2', '1', 'notstart', NULL, '2018-4-24 12:35:56', 'http://albert6.com:9999/uploadfile/48200205a5d54b5ba02c88219b095277.png');

create table user_ride(
id int primary key auto_increment,
userid varchar(64),
rideid varchar(64)
);
INSERT INTO `user_ride` VALUES (1, '1', '1');
INSERT INTO `user_ride` VALUES (2, '2', '1');
