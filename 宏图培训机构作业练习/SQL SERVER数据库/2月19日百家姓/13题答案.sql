--1��ʲô����������������ȱ�������Щ�� 
/*
	



*/
--ȥ������һ��
select getdate()
select datepart(dd,getdate())

select datepart(mm,getdate())

select dateadd(dd,-datepart(dd,getdate()),getdate())

select dateadd(mm,-datepart(mm,getdate())+1,dateadd(dd,-datepart(dd,getdate()),getdate()))
--��ȡ1900�굽���ڹ��˶�����
select datediff(yy,0,getdate())
--��ȡ�����һ��
select dateadd(yy,datediff(yy,0,getdate()),0)

select dateadd(mi,-20,dateadd(yy,datediff(yy,0,getdate()),0))
--
/*

*/

--���µ����һ��
select getdate()

select datepart(mm,getdate())

select datediff(mm,0,getdate())

select dateadd(mm,datediff(mm,0,getdate())+1,0)

select dateadd(hh,-1,dateadd(mm,datediff(mm,0,getdate())+1,0))







create view v_class as 

select * from class


select * from v_class






--waitfor
--�ӳٶ��
waitfor delay '00:00:20'
select getdate()
--��ʲôʱ���ִ��
waitfor time '09:25:00'
select getdate()
--����10000������
create table Emp1(
	empid int identity(1,1) primary key,
	empname varchar(20), --���
	salary int, --������� 1000-10000֮��
	joindate datetime --��ְ���� ���
)
/**/
declare @i int 
declare @salary int 
declare @day int
declare @month int 
declare @j int
declare @k int 
declare @xing varchar(200)
declare @ming varchar(200)
declare @name varchar(10)
declare @h int 
set @i=1--'������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������'
set @xing='��Ǯ��������֣������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ����������ɷ�����³Τ������ﻨ������Ԭ����ʷ���Ѧ�׺����������ޱϺ���������ʱ�����뿵����Ԫ����ƽ�ƺ���Ҧ��տ��ƽ�ƺ���Ҧ��տ��'
set @ming='��֮��ɽʿ��Ƚ��߮ǧ���µ���������������α�������������ɼƽѩ��橺���ͩ�Ѽ�ʫ����������ع��骺����󲩿�˹ң���ͮ��ΰǿ�������ؽ����»Ծ���������α�������������ɼƽѩ��橺���ͩ�Ѽ�ʫ����������ع��'

while(@i<=150)
begin
	set @j=rand()*100+1
	set @k=rand()*100+1
	set @h=cast(rand()*10 as int) %2+1
	set @name=substring(@xing,@j,1)+substring(@ming,@k,@h)
    set @salary =rand()*10000
	while(@salary<1000)
	begin
		set @salary =rand()*10000
	end
	set @day=rand()*5000--�ص� ʱ�� dateadd(mm,-@month,dateadd(dd,-@day,getdate()))
	set @month=rand()*10--�ص�
	
	insert into emp1 values(@name,@salary,dateadd(mm,-@month,dateadd(dd,-@day,getdate())))
	set @i=@i+1
end 

select dateadd(dd,-rand()*5000,getdate())--13��
select rand()*100
select *  from emp1
  








