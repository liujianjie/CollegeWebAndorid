


--变量 存储数据的对象
--系统变量 全局变量
select @@error,@@language,@@rowcount,@@servername,@@timeticks,@@version

--自定义变量 局部变量
declare @age int --declare定义 变量名 数据类型
declare @name varchar(10) 
select @age=3
set @name='小三'
select @name+'今年'+convert(varchar(3),@age)+'岁了'

--使用变量做条件
declare @age int
set @age=17
select * from student where stu_age=@age

--将查询的结果封装到变量中
declare @id int
declare @name varchar(10)
declare @sex varchar(2)
declare @age int
declare @card varchar(20)
select @id=stu_no,@name=stu_name,@sex=stu_sex,@age=stu_age,@card=stu_card from student where stu_no=1
select cast(@id as varchar(5))+@name+@sex+@card

--流程控制语句
--use 设置当前数据库
use T1

--begin end SQL中的复合语句
begin
	select * from student
end

--if  else 
declare @sex varchar(2)
select @sex='男'
if @sex='男'
begin 
	print '我是男人'
end
else
begin
	print '我是女人'
end

--while 1+2+3+....+100的和
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

--判断ID号为1的学生是否成年
declare @age int
select @age=stu_age from student where stu_no=2 

if @age>=18
begin
	print '成年了'
end
else
begin
	print '未成年'
end

--goto 跳转到标签 (如果学生表有数据，那就查询分数 中间的那段查询jop的语句就不会执行了)
if (select count(*) from student)>0
begin
	goto x
end
else
begin
	select * from jop
end
x:select * from score

--case when then else end 选择结构
use task
select * from student
select stuno,stuname,sex,age,
case classno
when 200801 then '高二（12）班'
else '高一（13）班'
end as '班级'
from student

--wait
--waitfor time 等待时间段
waitfor time '11:05:30'
select * from syslogins

--waitfor delay 延迟时间
waitfor delay '00:00:02'
select * from student

--异常处理  (加上 事务处理机制)
set xact_abort on --打开try功能

begin try
begin tran--事物处理机制 开始事物
insert into student values('20080207','小七','200802','F',20)
insert into student values('20080208','小八','200802','F','a')
commit tran--事物处理机制 提交事物
end try
begin catch
rollback --回滚
print '报错了'
end catch

declare @t int
select @t=0
while @t<5
begin
	if @t=4
	begin
		print '哈哈'
		break
	end
	else 
	begin
		print '呵呵'
	end
	select @t=@t+1
end

--没加事物处理机制 不会回滚 并添加正确的数据

1、什么是批处理？

  一个逻辑单元的t——sql语句组

2、T-SQL中有几种注释的方法？
	
  两种：1种是单行注释 -- 
	   第2种是多行注释 /**/

3、waitfor语句有何作用？

  有两种作用：1.延迟执行
			 2.等待执行