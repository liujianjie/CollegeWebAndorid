--getdate()
select getdate() 时间

--日期增减
select dateadd(yy,3,getdate())

--计算相差多少
select datediff(mm,'2008-8-5','2008-5-4')

--指定日期的返回
select datename(yy,getdate()) 年--1

select datepart(yy,getdate()) 年--2

--部分日期 同 datename 和 datepart
select year(getdate())

--日期用datetime数据类型装载
use T1
create table 第三章(
	work_no int identity(1,1) primary key,
	work_name varchar(10) not null,
	work_time datetime not null
)
insert into 第三章 values('张三',getdate())
insert into 第三章 values('李四',getdate())
select * from 第三章

--查出年月日  
select work_no,work_name,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) 进厂时间
			from 第三章

--排名函数 rank() over b=不连续的排名
select *,rank() over(order by score) as 排名 from  score order by score 

--同 rank（） over 的 dense_rank 连续的排名
select *,dense_rank() over(order by score) as 排名 from  score order by score

--数据类型转换的函数
select cast(1 as float) /2 呵呵

--数学函数
--绝对值
select abs(-1)

--随机数
select rand()

--派
select pi()

--幂函数
select power(2,3)

--开更好
select sqrt(2)

--平方
select square(2)

--精确n为小数
select round(3.132,2)

--符号函数

select sign(pi()/2)

--字符串函数
--字符创长度
select len('32e32')

--截取
select left('232',2),right('232',1) 
select substring('administrator',2,4)

--ascall玛值
select ascii('2')

--数字装成字符
select char(68)

--反转
select reverse('hhdfds')

--小写
select lower('ADFf')

--大写
select upper('sdfsdf')

--黄字母
select replace('sdf','s','d')

--去空格
select ltrim('           dss')
select rtrim('           dss             ')
select ltrim(rtrim('       sd            '))


--课后作业吧 查询同年同月同日生的人 
--我就查询进厂时间一样的人吧
delete from 第三章 
truncate table 第三章
insert into 第三章 values('小三','2016-01-30')
insert into 第三章 values('小四','2016-02-10')
insert into 第三章 values('小小','2016-01-30')
insert into 第三章 values('小五','2016-02-10')
insert into 第三章 values('小六','2016-04-30')
insert into 第三章 values('小柒','2016-06-30')
insert into 第三章 values('小染','2016-01-30')
insert into 第三章 values('小红','2016-02-10')
insert into 第三章 values('小明','2016-01-30')
insert into 第三章 values('小花','2016-01-30')

select * from 第三章

--分组
select work_no,work_name,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) 进厂时间 from 第三章
			order by 进厂时间

--
select work_time,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) 进厂时间 from 第三章 group by work_time

select work_no,work_time,work_name from 第三章 where work_time in
		(select work_time from 第三章 group by work_time having count(work_time)>1) order by work_time
 





















--查询规定日期 如 2016 1 30
select work_no,work_name,cast(year(work_time) as varchar(5))+'-'+ cast(month(work_time) as varchar(5)) +'-'+
		cast(day(work_time) as varchar(6)) 进厂时间 from 第三章
			where year(work_time)='2016' and month(work_time)='1' and day(work_time)='30'