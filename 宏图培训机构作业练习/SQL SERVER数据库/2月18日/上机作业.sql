--�ϻ���ҵ
use task
update emp set joindate=convert(varchar(4),datepart(yy,getdate()))+'-'+
	convert(varchar(4),datepart(mm,getdate()))+'-'+convert(varchar(4),datepart(dd,getdate()))
--1.	��ѯ������Ա����sexΪM����ʾ�ɡ��С�,F��ʾ��Ů
select * from emp
select empid,empname,salary,joindate, 
case sex
when 'M' then '��'
when 'F' then 'Ů'
end as '�Ա�'
from emp

--2.	ѭ��������Ա���Ĺ�����10%��ֱ����߹�������͹��ʵ�����Ϊֹ
declare @a int--��С
declare @b int--���
select @a=min(salary) from emp
select @a=@a*2
while (select max(salary) from emp)<@a
begin
	print 'sdf'
	update emp set salary=salary*1.1
end

--���������� ����ֵ
while false
begin 
	print '����'
end	

--3.	дһ��T-SQL����1-100��Щ��ͬʱ��3��7����
declare @a int
select @a=1
print @a
while @a<100
begin
	if @a%3=0 and @a%7=0
	begin
		print @a
	end
	select @a=@a+1
end

--4.	ʹ��switch case дһ�����ӣ����ݲ�ͬ��ʱ�����ж����磬���磬����
declare @time datetime
select @time=datepart(hh,getdate())
if @time>0 and @time<12
begin
	print '����'
end
else if @time>12 and @time<18
begin
	print '����'
end
else if @time>18 and @time<24
begin
	print '����'
end

--6.1.	ʹ��IF ELSE д��һ��Ӧ�����ӣ���Ҫ������������0��ʾ����Ա��������С��1��ӡû��Ա����
if (select count(*) from emp)>0
begin
	select * from emp
end
else if (select count(*) from emp)<1
begin
	print('û��Ա��')
end	