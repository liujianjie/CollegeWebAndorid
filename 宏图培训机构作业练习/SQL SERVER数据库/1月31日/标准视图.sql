--视图
use T1
--创建 
create view v_student 
as
select * from student

--查询视图
select * from v_student

--使用（可以为曾删改 都可以改变原来的表）
insert into v_student values('小丽','女',19,'345234234')

--参数 with chect option
create view v_student2
as
select * from student where stu_age>18
with check option

select * from v_student2
--试试增加一条小于18岁的数据
insert into v_student2 values('小丽','女',17,'34985233434234')--不行

--参数二 with encryption加密
create view v_student3
with encryption
as
select * from student

insert into v_student3 values('小红','女',17,'3433434234')--不行

select * from v_student3--可以曾删改 不能修改

--基于试图表创建视图表
create view v_student4
as
select * from v_student3 where stu_age>18

select * from v_student4

--试试临时表和关键字
use task

select *,(select classname from classes cs where cs.classno=st.classno) 班级 from student st
select stuno,stuname,cs.classno,sex,age,cs.classname from student st left join classes cs on cs.classno=st.classno

--临时表（子查询）不行 要就链接
create view v_student
as
select stuno,stuname,cs.classno,sex,age,cs.classname from student st left join classes cs on cs.classno=st.classno

create view v_student2
as
select *,(select classname from classes cs where cs.classno=st.classno) 班级 from student st

select * from v_student2
--这个不行
create view v_student3
as
select * from student s ,(select * from classes) c where  s.classno=c.classno

--order by还指定了 TOP 或 FOR XML，否则，ORDER BY 子句在视图、内联函数、派生表、子查询和公用表表达式中无效。
create view v_student3
as
select * from student order by age

--当删除表的时候 视图定义还在 但是结果集不在了 
use T1
select * from v_student

--修改视图的查询结果
alter view v_student
as
select * from score


delete from student where stu_no=9

drop view v_student2

