--�ϻ���ҵ
use task
select * from dbo.v_student

--4.1.	��ͼ�Ĵ����Ͳ�ѯ
--ɾ����ͼ
if exists(select * from sysobjects where name='v_student2' and type='v')
begin
	drop view v_student2
end

--������ͼ
create view v_student
as
select s.stuno,s.stuname,c.cno,c.cname,sc.score from student s
	inner join studentcourse sc on s.stuno=sc.stuno
	inner join course c on sc.cno=c.cno

--��ѯ��ͼ
select * from v_student

--ʹ����ͼͳ��
select stuname,avg(score) from v_student group by stuname

--����
insert into v_student values(2008201,'С��',205,'��ҳ���',60)

--�޸���ͼ
update v_student set score=80,stuno='20080112' where stuno='20080101'

--�޸���ͼ2
alter view v_student 
as
select c1.classname,s.stuno,s.stuname,c.cno,c.cname,sc.score
from classes c1 inner join student s on c1.classno=s.classno
			inner join studentcourse sc on s.stuno=sc.stuno
			inner join course c on sc.cno=c.cno
where sc.score>60 and c.cname='c����'
with check option

--4.5.	ͨ����ͼ�޸����ݵ�����
update v_student set score=50 where stuno='20080102'

select * from v_student

--�ϻ��ĵ�����ҵ ��ȫ����һ��
--5.1.	������½�ʺ�banklogin������Ϊ12345�������ø��ʺŵ�¼��Ĭ�����ݿ�Ϊbank��
	  --����ʹ�ø��ʺ��ܷ��¼���ܷ�������ݿ� ����
create database bank
sp_addlogin 'banklogin','123456','bank'

--5.2.	Ϊ�õ�¼�ʺ�banklogin����һ�����ݿ��û�bankuser���ٲ��Կ����ܷ�������ݿ� ��
use bank
sp_grantdbaccess 'banklogin','bankuser'

--5.3.	����bankuser��bank���ݿ��и������������ɾ���ġ����Ȩ�ޡ����� ��
create table student(
	stu_id int identity(1,1) primary key,
	stu_name varchar(20) not null,
	stu_sex char(2) not null
)

--5.4.	����bankuser�û���bank���ݿ��һ�в���Ȩ�ޣ�������

--6.1.	����һ�����ݿ⣬��������ݿ�����û���ʹ�ô��û�ֻ�ܷ��ʸ����ݿ�
	--  �������ܶ��������ݽ��в�����

drop database bank