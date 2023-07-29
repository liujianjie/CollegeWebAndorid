use 练习

select * from 添加约束

--查询多个表
select * from cite2,cite3

--取别名
select a.*,b.cite_name from 添加约束 a,cite b where a.shu_no=b.cite_no 
select top 5 添加约束.*,cite.cite_name from 添加约束,cite where 添加约束.shu_no=cite.cite_no --不取别名

--top查询
select top 5 * from 添加约束 where shu_no in(1,4,5,6,7,7,7,4)
--top百分比查询
select top 50 percent * from 添加约束

--列取别名 列名就会改变
select shu_no 学号,shu_name 姓名 from 添加约束

--加号用法
select (shu_no+shu_id)加号用法 from 添加约束

--去除重复的记录
select distinct shu_age from 添加约束

--排序 正序 和 反序
select * from 添加约束 order by shu_age asc --正序 asc可不加
select * from 添加约束 order by shu_age desc--反序 desc 

--聚合函数
--sum求和函数
select sum(shu_age)总年龄 from 添加约束
select sum(shu_age/5+shu_id/5)总数 from 添加约束

--平均函数 avg
select avg(shu_age)平均年龄 from 添加约束

--max最大值
select max(shu_age)最大值 from 添加约束
select max(shu_id)最大值 from 添加约束--id 是varchar数据类型所以这值没有什么卵用

--最小值min
select min(shu_age)最小值 from 添加约束
select min(shu_id)最小值 from 添加约束

--计数 count(*)
select count(shu_age)多少 from 添加约束
select count(*)多少 from 添加约束

--分组group by
select shu_age,count(shu_age) from 添加约束 group by shu_age
select shu_id,count(shu_id) from 添加约束 group by shu_id

--is null值和is not null不为空值
select * from 添加约束 where shu_age is null
select * from 添加约束 where shu_age is not null

--创表
create table allany(
	allany_no int primary key,
	allany_name varchar(20)

)
create table allany2(
	allany2_no int foreign key references allany(allany_no),
	allany2_name varchar(20) not null,
	allany2_age tinyint not null

)--填表完成
--all 全部 any 任意
--all 全部
select * from allany2 where allany2_no=1 and allany2_age >  all(select allany2_age from allany2 where allany2_no=2)

--any 任意
select * from allany2 where allany2_no=1 and allany2_age >  any(select allany2_age from allany2 where allany2_no=2)
