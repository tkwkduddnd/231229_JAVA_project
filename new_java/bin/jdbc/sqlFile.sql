create user 'javaUser'@'localhost' identified by 'mysql';

create database javadb;

grant all privileges on javadb.* to 'javaUser'@'localhost' with
grant option;

flush privileges;

create table product(
pno int not null auto_increment,
pname varchar(50) not null,
price int not null default 0,
regdate datetime default now(),
madeby text,
primary key(pno));