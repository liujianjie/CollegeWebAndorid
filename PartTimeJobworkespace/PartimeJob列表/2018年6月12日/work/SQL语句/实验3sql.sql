--实验内容1）
USE 学生管理
GO

IF exists (select name from sysobjects   where id=object_id(N'[SC]') )
DROP TABLE SC
GO

IF exists (select name from sysobjects   where id=object_id(N'[S]') )
DROP TABLE S
GO

IF exists (select name from sysobjects   where id=object_id(N'[C]' ) )
DROP TABLE C 
GO

--学生关系表
create table S(
	Sno int not null,
	Sname varchar(50) not null,
	Ssex varchar(2)  not null,
	Sage tinyint  not null,
	sdept varchar(50) not null,
	constraint pk_S primary key(Sno),
	constraint ck_S check (Ssex = '男' or Ssex = '女')
)
go

--课程关系表C
create table C(
	Cno smallint not null,
	Cname varchar(50) not null ,
	Cpno varchar(50),
	Ccredit tinyint  not null
	constraint pk_C  primary key(Cno),
	constraint uk_C unique(Cname)
)
go
--学生-课程表SC
create table SC(
	Sno int not null,
	Cno smallint not null,
	grade float  not null,
	constraint fk_SC_1 foreign key(Sno) references S(Sno), 
	constraint fk_SC_2 foreign key(Cno) references C(Cno)
)
go
--实验内容2
insert into S values(40,'张','女',19,'管理工程系'); 
insert into S values(41,'周小五','男',20,'信息工程系');
insert into S values(42,'王小六','男',21,'食品系'); 
insert into S values(43,'燕小七','女',22,'法学系');

insert into C values(01,'C语言','',10);
insert into C values(02,'JAVA语言程序设计（一）','C语言',10);
insert into C values(03,'C++程序设计','JAVA语言程序设计（一）',10);
insert into C values(04,'数据库技术及应用','C++程序设计',10);
insert into C values(05,'管理信息系统','数据库技术及应用',10);

insert into SC values(40,01,86);
insert into SC values(40,02,90);
insert into SC values(40,03,80);
insert into SC values(40,04,70);
insert into SC values(40,05,90);
insert into SC values(43,01,80);
insert into SC values(43,02,90);
insert into SC values(43,03,80);
insert into SC values(43,04,90);
insert into SC values(43,05,70);

select * from S;select * FROM C; select * from SC

--内容3）在表 S 上增加“出生日期”属性列；

alter table S add Sborn Smalldatetime;

select * from S

--内容4

alter table S drop column Sage;

select * from S;

--内容5

drop table SC;

SELECT * FROM SC;