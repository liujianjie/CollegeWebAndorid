select cast(rand() as int)--随机数
1、什么是索引？索引的优缺点各有哪些？
	是对数据库表中一个或多个列的值进行排序的物理结构
	优点：减少内存占用，加快访问速度，加强行的唯一性
	缺点：需要更多的硬盘空间，进行更改数据时需更多时间，索引也要及时更新

2、说说你对索引的认识（索引的结构，为什么提高查询性能）
	提高查询性能：排列时直接按照索引排列，因为索引就是从小大的顺序排列的，如果查询某一行
				 索引会折半查找，而不是一个个检索
	索引结构:索引是一种单独的数据库物理结构,索引5提供来指向存储在表中指定列的数据值,然后根据
			指定的排序次序排列这些指针
	
3、索引一定能提高性能吗？
	不一定，因为如果增加数据时，索引也会增加，而这时索引会重新组织数据存储结构，若索引页
		   已满则会进行页拆分，而页拆分会让索引降低性能，且割离了表中数据的存储

4.去年的最后一天
	--逻辑就是先算出今年距离原始的年份为多少 在减去-3毫秒就是了
	select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate()),0))
	select datediff(yy,0,getdate())--相差多少年

    今年的最后一天
    select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate())+1,0))
    
5、本月的最后一天
	--逻辑就是先算出今年距离原始的年份为多少转换为月份+1 在减去-3毫秒就是了
	select dateadd(ms,-3,dateadd(mm,datediff(mm,0,getdate())+1,0))
	select datediff(mm,0,getdate())
6、什么是视图，有什么作用
	试图就是表中的查询结果集,试图表根据sql语句查出并不存储数据为虚拟表，
	对关键数据进行保护	

7、SQL Server对用户的验证分哪几个层次？
	两种：登录验证，权限验证

8、登录名和用户是什么关系？角色和用户之间又是什么关系？
	登录名与用户1对1,角色与用户多对多

9、数据库角色、服务器角色的区别
	数据库角色：是给用户分配的角色
	服务器角色：是给登录名分配的角色

10、什么是批处理？
	进入一组逻辑单元的T-sql语句组	

11、T-SQL中有几种注释的方法？
	两种： 单行：-- 
		   多行：/* */

12、waitfor语句有何作用？
	（1）延迟语句执行时间 delay
	（2）等待语句执行的时间点 time

13、写段T-SQL往员工表插入1万条数据，员工表Emp字段如下:
	empid,主键。自增
	empname,姓名，最好是随机的
	salary,工资，1000-10000，随机生成
	joindate，入职时间，随机生成
   参考：RAND() 函数
use t1
CREATE TABLE [dbo].[emp](
	[empid] [int] IDENTITY(1,1) NOT NULL,
	[empname] [varchar](10) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[salary] [float] NOT NULL,
	[joindate] [datetime] NULL
) ON [PRIMARY]
select cast(rand()*10 as int)--单个数 名字
select cast(rand()*10000 as int)--薪水
select left('ewfsdf',3)
select substring('sdfsdf',3,1)--查询姓名
select cast(rand()*100 as int)

declare @name varchar(40)--名字
declare @rname int --随机名字第一个
declare @rname2 int --随机名字第二个
declare @rname3 int --随机名字第三个
declare @jname varchar(2) --随机名字第一个
declare @jname2 varchar(2) --随机名字第二个
declare @jname3 varchar(2) --随机名字第三个
declare @salary int--薪水
declare @year int--日期的年份
declare @month int--日期的月份
declare @day int --日

select @name='  刘夏谢蓝宝王老钟财美梅清杰龙陈黄康玉'
while (select count(*) from emp)<20--可以为一万
begin
	select @salary=cast(rand()*10000 as int)--薪水
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
	select @jname3=substring(@name,@rname3,2)--以上没错就差添加了
	--日期
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
