--创建数据库
create database student
on primary(
	name=student,
	filename='E:\宏图作业练习\SQL SERVER数据库\10.11复习\student.mdf',
	size=3mb,
	maxsize=10mb,
	filegrowth=1mb
)
log on(
	name=student1,
	filename='E:\宏图作业练习\SQL SERVER数据库\10.11复习\student1.ldf',
	size=3mb,
	maxsize=10mb,
	filegrowth=1mb
)
--表
use student
create table wan1(
	wan1_no int identity(1,1) primary key not null,--自动增长
	wan1_name varchar(20) not null,
	wan1_sex char(2) check(wan1_sex='男' or wan1_sex='女'),
	wan1_age tinyint check(wan1_age>=0 and wan1_age<=100),
	wan1_id varchar(18) not null unique,
	wan1_nub varchar(11) not null unique,
	wan1_hh uniqueidentifier default newid() --全球唯一标识列
	wan1_name1 varchar(20) not null foreign key references wan(wan_name) --引用 好像没什么卵用 只是关联 要一样 不能自动打上去
)
--修改表
--添加
alter table wan1 add wan_level int default 1
--修改
alter table wan1 alter column wan1_name int
--删除表的某个字段
alter table wan1 drop column wan1_name
--添加
alter table wan1 add wan1_name varchar(20) not null
--删除表
drop table wan1