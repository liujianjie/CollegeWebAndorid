select cast(rand() as int)--�����
1��ʲô����������������ȱ�������Щ��
	�Ƕ����ݿ����һ�������е�ֵ�������������ṹ
	�ŵ㣺�����ڴ�ռ�ã��ӿ�����ٶȣ���ǿ�е�Ψһ��
	ȱ�㣺��Ҫ�����Ӳ�̿ռ䣬���и�������ʱ�����ʱ�䣬����ҲҪ��ʱ����

2��˵˵�����������ʶ�������Ľṹ��Ϊʲô��߲�ѯ���ܣ�
	��߲�ѯ���ܣ�����ʱֱ�Ӱ����������У���Ϊ�������Ǵ�С���˳�����еģ������ѯĳһ��
				 �������۰���ң�������һ��������
	�����ṹ:������һ�ֵ��������ݿ�����ṹ,����5�ṩ��ָ��洢�ڱ���ָ���е�����ֵ,Ȼ�����
			ָ�����������������Щָ��
	
3������һ�������������
	��һ������Ϊ�����������ʱ������Ҳ�����ӣ�����ʱ������������֯���ݴ洢�ṹ��������ҳ
		   ����������ҳ��֣���ҳ��ֻ��������������ܣ��Ҹ����˱������ݵĴ洢

4.ȥ������һ��
	--�߼�����������������ԭʼ�����Ϊ���� �ڼ�ȥ-3���������
	select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate()),0))
	select datediff(yy,0,getdate())--��������

    ��������һ��
    select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate())+1,0))
    
5�����µ����һ��
	--�߼�����������������ԭʼ�����Ϊ����ת��Ϊ�·�+1 �ڼ�ȥ-3���������
	select dateadd(ms,-3,dateadd(mm,datediff(mm,0,getdate())+1,0))
	select datediff(mm,0,getdate())
6��ʲô����ͼ����ʲô����
	��ͼ���Ǳ��еĲ�ѯ�����,��ͼ�����sql����������洢����Ϊ�����
	�Թؼ����ݽ��б���	

7��SQL Server���û�����֤���ļ�����Σ�
	���֣���¼��֤��Ȩ����֤

8����¼�����û���ʲô��ϵ����ɫ���û�֮������ʲô��ϵ��
	��¼�����û�1��1,��ɫ���û���Զ�

9�����ݿ��ɫ����������ɫ������
	���ݿ��ɫ���Ǹ��û�����Ľ�ɫ
	��������ɫ���Ǹ���¼������Ľ�ɫ

10��ʲô��������
	����һ���߼���Ԫ��T-sql�����	

11��T-SQL���м���ע�͵ķ�����
	���֣� ���У�-- 
		   ���У�/* */

12��waitfor����к����ã�
	��1���ӳ����ִ��ʱ�� delay
	��2���ȴ����ִ�е�ʱ��� time

13��д��T-SQL��Ա�������1�������ݣ�Ա����Emp�ֶ�����:
	empid,����������
	empname,����������������
	salary,���ʣ�1000-10000���������
	joindate����ְʱ�䣬�������
   �ο���RAND() ����
use t1
CREATE TABLE [dbo].[emp](
	[empid] [int] IDENTITY(1,1) NOT NULL,
	[empname] [varchar](10) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[salary] [float] NOT NULL,
	[joindate] [datetime] NULL
) ON [PRIMARY]
select cast(rand()*10 as int)--������ ����
select cast(rand()*10000 as int)--нˮ
select left('ewfsdf',3)
select substring('sdfsdf',3,1)--��ѯ����
select cast(rand()*100 as int)

declare @name varchar(40)--����
declare @rname int --������ֵ�һ��
declare @rname2 int --������ֵڶ���
declare @rname3 int --������ֵ�����
declare @jname varchar(2) --������ֵ�һ��
declare @jname2 varchar(2) --������ֵڶ���
declare @jname3 varchar(2) --������ֵ�����
declare @salary int--нˮ
declare @year int--���ڵ����
declare @month int--���ڵ��·�
declare @day int --��

select @name='  ����л���������Ӳ���÷������»ƿ���'
while (select count(*) from emp)<20--����Ϊһ��
begin
	select @salary=cast(rand()*10000 as int)--нˮ
	if @salary<1000
	begin
		continue
	end
	select @rname=cast(rand()*10 as int)
	select @rname2=cast(rand()*10 as int)
	select @rname3=cast(rand()*10 as int)
	if @rname=2
	begin
		continue	
	end
	if @rname2=2
	begin
		continue	
	end
	if @rname3=2
	begin
		continue	
	end
	if @rname=0
	begin
		continue	
	end
	if @rname2=0
	begin
		continue	
	end
	if @rname3=0
	begin
		continue	
	end
	if @rname=1 and @rname3=1
	begin
		continue
	end
	if @rname2=1 and @rname3=1
	begin
		continue
	end
	if @rname=1 and @rname2=1
	begin
		continue
	end
	select @jname=substring(@name,@rname,2)
	select @jname2=substring(@name,@rname2,2)
	select @jname3=substring(@name,@rname3,2)--����û��Ͳ������
	--����
	select @year=cast(rand()*10000 as int)
	select @month=cast(rand()*100 as int)
	select @day=cast(rand()*100 as int)
	if @year>2016 
	begin
		continue
	end
	if @year<1990
	begin
		continue
	end
	if @month>12
	begin
		continue
	end
	if @day>31
	begin
		continue
	end
	else if @month=2 and @day>29
	begin
		continue
	end
	insert into emp values(@jname+@jname2+@jname3,@salary,
	convert(varchar(4),@year)+'-'+convert(varchar(4),@month)+'-'+convert(varchar(4),@day))
	print @year
end
insert into emp values('34','34',null)
truncate table emp
