--上机作业
5.1.	写一个过程，计算某个月有多少天。
 
5.2.	编写一个给所有员工加薪10%的过程，这之后，如果已经雇佣该雇员超过60个月，则给他额外加薪2000.
--以2011年为标准
select datediff(mm,'2011-1-1',(select joindate from emp where empid=1))

create procedure up_yungong
as
update emp set salary=salary*1.1
declare @i int
set @i=0
while @i<(select count(*) from emp)
begin
	if datediff(mm,'2011-1-1',(select joindate from emp where empid=@i))>60
	begin
		print '2343'
		update emp set salary=salary+2000 where empid=@i
	end
	set @i=@i+1
end

exec up_yungong

6.1.	写一个自动编号的存储过程，如:200408010001? 
select cast(rand()*1000000000 as int)
alter procedure up_zdbh
as
select cast(rand()*1000000000 as int) 编号
exec up_zdbh

6.2.	已知表数据：
姓名  金额   日期 
张三  100   1998/4/8 
张三  10    1998/7/4 
里斯  20.5  1999/8/9 
张三  10    1999/8/7 
王五  30.5  1998/1/1 
刘二  22.5  2000/8/4 
里斯  30    2001/8/9 
赵毅  2     2002/8/4 
王五  14    2000/2/21 
张三  52    1999/12/9 
王八  33    2005/8/9 
刘二  20    2007/8/9
张三  100	2007/10/21
编写存储过程，统计所有人每一年的总金额，如：
姓名	1998年总金额	1999年总金额	。。。	2007年总金额
张三	10				62						100
里斯	。。。。。。
。。。。。(所有员工信息)
create table emp2(
	empid int identity(1,1) primary key,
	emp_name varchar(20),
	emp_salary float,
	emp_date datetime
)
insert into emp2 values('张三',100,'1998/4/8')
insert into emp2 values('张三',10,'1998/7/4 ')
insert into emp2 values('里斯',20.5,'1999/8/9')
insert into emp2 values('张三',10,'1999/8/7')
insert into emp2 values('王五',30.5,'1998/1/1')
insert into emp2 values('刘二',22.5,'2000/8/4')
insert into emp2 values('里斯',30,'2001/8/9 ')
insert into emp2 values('赵毅',2,'2002/8/4 ')
insert into emp2 values('王五',14,'2000/2/21')
insert into emp2 values('张三',52,'1999/12/9 ')
insert into emp2 values('王八',33,'2005/8/9 ')
insert into emp2 values('刘二',20,'2007/8/9')
insert into emp2 values('张三',100,'2007/10/21')
truncate table emp2

create procedure up_emp2
as
select emp_name,
(select sum(emp_salary) from emp2 e where year(emp_date)=1998 and e.emp_name=em.emp_name),
(select sum(emp_salary) from emp2 e where year(emp_date)=1999 and e.emp_name=em.emp_name),
(select sum(emp_salary) from emp2 e where year(emp_date)=2000 and e.emp_name=em.emp_name),
(select sum(emp_salary) from emp2 e where year(emp_date)=2001 and e.emp_name=em.emp_name),
(select sum(emp_salary) from emp2 e where year(emp_date)=2002 and e.emp_name=em.emp_name),
(select sum(emp_salary) from emp2 e where year(emp_date)=2005 and e.emp_name=em.emp_name),
(select sum(emp_salary) from emp2 e where year(emp_date)=2007 and e.emp_name=em.emp_name)

from emp2 em group by emp_name

exec up_emp2