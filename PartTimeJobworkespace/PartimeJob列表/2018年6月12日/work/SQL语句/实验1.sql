BEGIN
create database 学生1
on primary(
	name = '学生1',
	filename = 'E:\学生1_log.mdf',
	size = 5mb,
	maxsize = 100mb,
	filegrowth = 1mb
	
)
log on(
	name = '学生1_log', 
	filename = 'E:\学生1_log.ldf',                     
	size = 2mb,                         
	maxsize = 100mb,          
	filegrowth = 10%           

)
END

USE 学生1
GO

--内容1
create table test1 (
	id int identity(1,1), 
	lname varchar(20),
	fname varchar(20),
	constraint uk_test1_1 unique(lname,fname)
);
insert into test1(lname,fname) values('kong', 'sales'); 

insert into test1 values(1,'kong', 'sales');

insert into test1 values(1,'kong', 'sales');

insert into test1 values(1,'kong', 'saless');

select * from test1 where lname like 'k%';

alter table test1 add constraint pk_test1 primary key(id); 

insert into test1 values(1,'zhang','sales');


--内容2


create table test2 (
	rid int,
	name varchar(20),
	constraint fk_test2_1 foreign key(rid) references test1(id),
	constraint fk_test2_2 check (name like 'k%'),
);


insert into test2 values(2, 'kong'); 

insert into test2 values (1, 'kong'); 

select * from test1;

delete test1;

drop table test2