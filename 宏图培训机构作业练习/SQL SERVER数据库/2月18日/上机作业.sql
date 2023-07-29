--上机作业
use task
update emp set joindate=convert(varchar(4),datepart(yy,getdate()))+'-'+
	convert(varchar(4),datepart(mm,getdate()))+'-'+convert(varchar(4),datepart(dd,getdate()))
--1.	查询出所有员工，sex为M是显示成”男”,F显示成女
select * from emp
select empid,empname,salary,joindate, 
case sex
when 'M' then '男'
when 'F' then '女'
end as '性别'
from emp

--2.	循环将所有员工的工资涨10%，直到最高工资是最低工资的两倍为止
declare @a int--最小
declare @b int--最大
select @a=min(salary) from emp
select @a=@a*2
while (select max(salary) from emp)<@a
begin
	print 'sdf'
	update emp set salary=salary*1.1
end

--不能这样的 布尔值
while false
begin 
	print '哈哈'
end	

--3.	写一段T-SQL计算1-100哪些能同时被3和7整除
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

--4.	使用switch case 写一个例子，根据不同的时间来判断上午，下午，晚上
declare @time datetime
select @time=datepart(hh,getdate())
if @time>0 and @time<12
begin
	print '上午'
end
else if @time>12 and @time<18
begin
	print '下午'
end
else if @time>18 and @time<24
begin
	print '晚上'
end

--6.1.	使用IF ELSE 写出一个应用例子（如要部门人数大于0显示所有员工，人数小于1打印没有员工）
if (select count(*) from emp)>0
begin
	select * from emp
end
else if (select count(*) from emp)<1
begin
	print('没有员工')
end	