create table board(
bno int not null auto_increment,
title varchar(50) not null,
writer varchar(30) not null,
content text,
regdate datetime default now(),
moddate datetime default now(),
primary key(bno));