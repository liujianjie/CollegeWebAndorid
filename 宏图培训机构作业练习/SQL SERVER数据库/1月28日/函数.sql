--getdate()
select getdate() ʱ��

--��������
select dateadd(yy,3,getdate())

--����������
select datediff(mm,'2008-8-5','2008-5-4')

--ָ�����ڵķ���
select datename(yy,getdate()) ��--1

select datepart(yy,getdate()) ��--2

--�������� ͬ datename �� datepart
select year(getdate())

--������datetime��������װ��
use T1
create table ������(
	work_no int identity(1,1) primary key,
	work_name varchar(10) not null,
	work_time datetime not null
)
insert into ������ values('����',getdate())
insert into ������ values('����',getdate())
select * from ������

--���������  
select work_no,work_name,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) ����ʱ��
			from ������

--�������� rank() over b=������������
select *,rank() over(order by score) as ���� from  score order by score 

--ͬ rank���� over �� dense_rank ����������
select *,dense_rank() over(order by score) as ���� from  score order by score

--��������ת���ĺ���
select cast(1 as float) /2 �Ǻ�

--��ѧ����
--����ֵ
select abs(-1)

--�����
select rand()

--��
select pi()

--�ݺ���
select power(2,3)

--������
select sqrt(2)

--ƽ��
select square(2)

--��ȷnΪС��
select round(3.132,2)

--���ź���

select sign(pi()/2)

--�ַ�������
--�ַ�������
select len('32e32')

--��ȡ
select left('232',2),right('232',1) 
select substring('administrator',2,4)

--ascall��ֵ
select ascii('2')

--����װ���ַ�
select char(68)

--��ת
select reverse('hhdfds')

--Сд
select lower('ADFf')

--��д
select upper('sdfsdf')

--����ĸ
select replace('sdf','s','d')

--ȥ�ո�
select ltrim('           dss')
select rtrim('           dss             ')
select ltrim(rtrim('       sd            '))


--�κ���ҵ�� ��ѯͬ��ͬ��ͬ�������� 
--�ҾͲ�ѯ����ʱ��һ�����˰�
delete from ������ 
truncate table ������
insert into ������ values('С��','2016-01-30')
insert into ������ values('С��','2016-02-10')
insert into ������ values('СС','2016-01-30')
insert into ������ values('С��','2016-02-10')
insert into ������ values('С��','2016-04-30')
insert into ������ values('С��','2016-06-30')
insert into ������ values('СȾ','2016-01-30')
insert into ������ values('С��','2016-02-10')
insert into ������ values('С��','2016-01-30')
insert into ������ values('С��','2016-01-30')

select * from ������

--����
select work_no,work_name,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) ����ʱ�� from ������
			order by ����ʱ��

--
select work_time,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) ����ʱ�� from ������ group by work_time

select work_no,work_time,work_name from ������ where work_time in
		(select work_time from ������ group by work_time having count(work_time)>1) order by work_time
 





















--��ѯ�涨���� �� 2016 1 30
select work_no,work_name,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) ����ʱ�� from ������
			where year(work_time)='2016' and month(work_time)='1' and day(work_time)='30'