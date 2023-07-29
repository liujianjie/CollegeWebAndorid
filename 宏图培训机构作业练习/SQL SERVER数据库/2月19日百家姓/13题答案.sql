--1、什么是索引？索引的优缺点各有哪些？ 
/*
	



*/
--去年的最后一天
select getdate()
select datepart(dd,getdate())

select datepart(mm,getdate())

select dateadd(dd,-datepart(dd,getdate()),getdate())

select dateadd(mm,-datepart(mm,getdate())+1,dateadd(dd,-datepart(dd,getdate()),getdate()))
--获取1900年到现在过了多少年
select datediff(yy,0,getdate())
--获取今年第一天
select dateadd(yy,datediff(yy,0,getdate()),0)

select dateadd(mi,-20,dateadd(yy,datediff(yy,0,getdate()),0))
--
/*

*/

--本月的最后一天
select getdate()

select datepart(mm,getdate())

select datediff(mm,0,getdate())

select dateadd(mm,datediff(mm,0,getdate())+1,0)

select dateadd(hh,-1,dateadd(mm,datediff(mm,0,getdate())+1,0))







create view v_class as 

select * from class


select * from v_class






--waitfor
--延迟多久
waitfor delay '00:00:20'
select getdate()
--到什么时间点执行
waitfor time '09:25:00'
select getdate()
--插入10000条数据
create table Emp1(
	empid int identity(1,1) primary key,
	empname varchar(20), --随机
	salary int, --工资随机 1000-10000之间
	joindate datetime --入职日期 随机
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
set @i=1--'刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘许刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘许刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘许刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘刘许刘'
set @xing='赵钱孙李周吴郑王冯陈楮卫蒋沈韩杨朱秦许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐岑薛雷贺倪汤滕殷罗毕郝邬安常乐时傅卞齐康伍余元顾孟平黄和萧姚邵湛汪平黄和萧姚邵湛汪'
set @ming='子之川山士久冉羽弋千天月丹可宜雨欣淇晓海涛滨琪琦豪杰轩延杉平雪怡姗涵婷桐佳嘉诗菲绮韵舒熙瑜毓煜楠涵洛珞博凯斯遥睿琳彤婕妤伟强力明鸣曦洁涛勇辉静欣淇晓海涛滨琪琦豪杰轩延杉平雪怡姗涵婷桐佳嘉诗菲绮韵舒熙瑜毓煜'

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
	set @day=rand()*5000--重点 时间 dateadd(mm,-@month,dateadd(dd,-@day,getdate()))
	set @month=rand()*10--重点
	
	insert into emp1 values(@name,@salary,dateadd(mm,-@month,dateadd(dd,-@day,getdate())))
	set @i=@i+1
end 

select dateadd(dd,-rand()*5000,getdate())--13年
select rand()*100
select *  from emp1
  








