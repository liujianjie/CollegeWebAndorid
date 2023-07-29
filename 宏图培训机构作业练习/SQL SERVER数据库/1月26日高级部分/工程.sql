--数据库
create database T1
on primary(
	name=高级部分T1,
	filename='E:\宏图作业练习\SQL SERVER数据库\高级部分的数据库\高级部分T1.mdf',
	size=3mb,
	maxsize=100mb,
	filegrowth=1mb	
)
log on(
	name=高级部分TT1,
	filename='E:\宏图作业练习\SQL SERVER数据库\高级部分的数据库\高级部分TT1.ldf',
	size=3mb,
	maxsize=100mb,
	filegrowth=1mb		

)
use T1
--表
create table gongcheng(
	工程号 char(2) primary key not null,
	工程名称 varchar(20) not null

)

create table worker(
	职工号 int primary key not null,
	姓名 varchar(20) not null

)

create table jop(
	职工号 int primary key not null,
	职务 varchar(20) not null

)

create table moneys(
	职务 varchar(20) primary key not null,
	小时工资率 int not null
)

create table main(
	编号 int primary key identity(1,1) not null,
	工程 char(2) not null references gongcheng(工程号),
	职工号 int not null references worker(职工号),
	工时 int not null
)
alter table jop drop column 职工号
alter table jop drop PK__jop__00551192 
drop table moneys

alter table worker add 职务 varchar(20)
alter table jop add 职务编号 varchar(20)
alter table jop add 小时工资率 int
alter table jop add constraint pkzhiwu primary key (职务编号)
alter table worker add constraint YINYONG foreign key (职务) references jop(职务编号)