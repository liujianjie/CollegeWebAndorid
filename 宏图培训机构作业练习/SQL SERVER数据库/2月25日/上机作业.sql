--�ϻ���ҵ
5.1.	дһ�����̣�����ĳ�����ж����졣
 
5.2.	��дһ��������Ա����н10%�Ĺ��̣���֮������Ѿ���Ӷ�ù�Ա����60���£�����������н2000.
--��2011��Ϊ��׼
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

6.1.	дһ���Զ���ŵĴ洢���̣���:200408010001? 
select cast(rand()*1000000000 as int)
alter procedure up_zdbh
as
select cast(rand()*1000000000 as int) ���
exec up_zdbh

6.2.	��֪�����ݣ�
����  ���   ���� 
����  100   1998/4/8 
����  10    1998/7/4 
��˹  20.5  1999/8/9 
����  10    1999/8/7 
����  30.5  1998/1/1 
����  22.5  2000/8/4 
��˹  30    2001/8/9 
����  2     2002/8/4 
����  14    2000/2/21 
����  52    1999/12/9 
����  33    2005/8/9 
����  20    2007/8/9
����  100	2007/10/21
��д�洢���̣�ͳ��������ÿһ����ܽ��磺
����	1998���ܽ��	1999���ܽ��	������	2007���ܽ��
����	10				62						100
��˹	������������
����������(����Ա����Ϣ)
create table emp2(
	empid int identity(1,1) primary key,
	emp_name varchar(20),
	emp_salary float,
	emp_date datetime
)
insert into emp2 values('����',100,'1998/4/8')
insert into emp2 values('����',10,'1998/7/4 ')
insert into emp2 values('��˹',20.5,'1999/8/9')
insert into emp2 values('����',10,'1999/8/7')
insert into emp2 values('����',30.5,'1998/1/1')
insert into emp2 values('����',22.5,'2000/8/4')
insert into emp2 values('��˹',30,'2001/8/9 ')
insert into emp2 values('����',2,'2002/8/4 ')
insert into emp2 values('����',14,'2000/2/21')
insert into emp2 values('����',52,'1999/12/9 ')
insert into emp2 values('����',33,'2005/8/9 ')
insert into emp2 values('����',20,'2007/8/9')
insert into emp2 values('����',100,'2007/10/21')
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