--上机作业
use task
select * from dbo.v_student

--4.1.	视图的创建和查询
--删除试图
if exists(select * from sysobjects where name='v_student2' and type='v')
begin
	drop view v_student2
end

--创建试图
create view v_student
as
select s.stuno,s.stuname,c.cno,c.cname,sc.score from student s
	inner join studentcourse sc on s.stuno=sc.stuno
	inner join course c on sc.cno=c.cno

--查询视图
select * from v_student

--使用视图统计
select stuname,avg(score) from v_student group by stuname

--插入
insert into v_student values(2008201,'小丁',205,'网页设计',60)

--修改视图
update v_student set score=80,stuno='20080112' where stuno='20080101'

--修改视图2
alter view v_student 
as
select c1.classname,s.stuno,s.stuname,c.cno,c.cname,sc.score
from classes c1 inner join student s on c1.classno=s.classno
			inner join studentcourse sc on s.stuno=sc.stuno
			inner join course c on sc.cno=c.cno
where sc.score>60 and c.cname='c语言'
with check option

--4.5.	通过视图修改数据的限制
update v_student set score=50 where stuno='20080102'

select * from v_student

--上机文档的作业 安全性这一块
--5.1.	创建登陆帐号banklogin，密码为12345，并设置该帐号登录的默认数据库为bank；
	  --测试使用该帐号能否等录，能否操作数据库 不能
create database bank
sp_addlogin 'banklogin','123456','bank'

--5.2.	为该登录帐号banklogin创建一个数据库用户bankuser；再测试看看能否操作数据库 能
use bank
sp_grantdbaccess 'banklogin','bankuser'

--5.3.	授予bankuser对bank数据库中各个表进行增、删、改、查的权限。测试 能
create table student(
	stu_id int identity(1,1) primary key,
	stu_name varchar(20) not null,
	stu_sex char(2) not null
)

--5.4.	授予bankuser用户对bank数据库的一切操作权限，并测试

--6.1.	建立一个数据库，给这个数据库分配用户，使得此用户只能访问该数据库
	--  ，而不能对其它数据进行操作。

drop database bank