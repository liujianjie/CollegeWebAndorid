


--���� �洢���ݵĶ���
--ϵͳ���� ȫ�ֱ���
select @@error,@@language,@@rowcount,@@servername,@@timeticks,@@version

--�Զ������ �ֲ�����
declare @age int --declare���� ������ ��������
declare @name varchar(10) 
select @age=3
set @name='С��'
select @name+'����'+convert(varchar(3),@age)+'����'

--ʹ�ñ���������
declare @age int
set @age=17
select * from student where stu_age=@age

--����ѯ�Ľ����װ��������
declare @id int
declare @name varchar(10)
declare @sex varchar(2)
declare @age int
declare @card varchar(20)
select @id=stu_no,@name=stu_name,@sex=stu_sex,@age=stu_age,@card=stu_card from student where stu_no=1
select cast(@id as varchar(5))+@name+@sex+@card

--���̿������
--use ���õ�ǰ���ݿ�
use T1

--begin end SQL�еĸ������
begin
	select * from student
end

--if  else 
declare @sex varchar(2)
select @sex='��'
if @sex='��'
begin 
	print '��������'
end
else
begin
	print '����Ů��'
end

--while 1+2+3+....+100�ĺ�
declare @i int
declare @sum int
select @i=0
select @sum=0
while @i<100
begin
	select @i=@i+1
	select @sum=@sum+@i	
end
select @sum

--�ж�ID��Ϊ1��ѧ���Ƿ����
declare @age int
select @age=stu_age from student where stu_no=2 

if @age>=18
begin
	print '������'
end
else
begin
	print 'δ����'
end

--goto ��ת����ǩ (���ѧ���������ݣ��ǾͲ�ѯ���� �м���Ƕβ�ѯjop�����Ͳ���ִ����)
if (select count(*) from student)>0
begin
	goto x
end
else
begin
	select * from jop
end
x:select * from score

--case when then else end ѡ��ṹ
use task
select * from student
select stuno,stuname,sex,age,
case classno
when 200801 then '�߶���12����'
else '��һ��13����'
end as '�༶'
from student

--wait
--waitfor time �ȴ�ʱ���
waitfor time '11:05:30'
select * from syslogins

--waitfor delay �ӳ�ʱ��
waitfor delay '00:00:02'
select * from student

--�쳣����  (���� ���������)
set xact_abort on --��try����

begin try
begin tran--���ﴦ����� ��ʼ����
insert into student values('20080207','С��','200802','F',20)
insert into student values('20080208','С��','200802','F','a')
commit tran--���ﴦ����� �ύ����
end try
begin catch
rollback --�ع�
print '������'
end catch

declare @t int
select @t=0
while @t<5
begin
	if @t=4
	begin
		print '����'
		break
	end
	else 
	begin
		print '�Ǻ�'
	end
	select @t=@t+1
end

--û�����ﴦ����� ����ع� �������ȷ������

1��ʲô��������

  һ���߼���Ԫ��t����sql�����

2��T-SQL���м���ע�͵ķ�����
	
  ���֣�1���ǵ���ע�� -- 
	   ��2���Ƕ���ע�� /**/

3��waitfor����к����ã�

  ���������ã�1.�ӳ�ִ��
			 2.�ȴ�ִ��