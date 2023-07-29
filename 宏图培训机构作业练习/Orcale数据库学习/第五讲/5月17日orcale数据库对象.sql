--分页核心代码 与sql的不一样 因为orcale这里的top没用 而是用rownum代替
select * from emp

select * from(select rownum r,e.* from emp e where rownum<=10) where r>5

int pagecount=5;
int currpage=1;
select * from(select rownum r,e.* from emp e where rownum<=pagecount*currpage) where r>(currpage-1)*pagecount

--视图
select * from newemp
insert into newemp select * from newemp

--创建普通视图
create or replace view newemp_view
as
select * from newemp

--上面是没有权限的 要在命令窗口中赋予 要登录管理员
授权:grant create view to scott;
回收:revoke create view from scott;

--查看视图
select * from newemp_view

--查看这个用户所有的视图
select * from user_views

--对视图的一些操作和 约束 对视图的操作就是对原表的操作
insert into newemp_view values(7935,'JACK','CLERK',7768,'21/4月/1988',4000.00,'',20,'男');

--条件
create or replace view newemp_view2
as
select * from newemp where sal>2500

select * from newemp_view2
--添加数据看看基表和视图都有没有
insert into newemp_view2 values(7936,'rows','CLERK',7768,'21/4月/1988',1000.00,'',20,'女');

select * from newemp for update--只有基表有

--条件视图
create or replace view newemp_view3
as
select * from newemp where sal>2500 with check option

select * from newemp_view3

--添加数据试试
insert into newemp_view3 values(7936,'rows','CLERK',7768,'21/4月/1988',1000.00,'',20,'女');

--多表连接视图 create or replace 意思是如果视图存在则覆盖 如果不存在则创建 
create view student1
as
select s.stu_id,s.stu_name,s.stu_age,c.cno,cname from student s inner join classes c on s.cno=c.cno

select * from classes
select * from student
select * from student1

--多表不能增删改

insert into student1 values(8,'李四',17,1002,'宏图15春1班')

delete from student1 

update student1 set cno=1002 where stu_id=2

--删除视图
drop view student1

--注意：视图不能有重复的列

--索引
创建普通索引（不唯一索引）
create index index_mgr on newemp(mgr)

创建唯一索引(自动给该列加上唯一约束)
select * from newemp

create unique index index_ename on newemp(ename)
insert into newemp values(7937,'rows','CLERK',7768,'21/4月/1988',1000.00,'',20,'女');--这就加不上了

创建位图索引
create bitmap index index_job on newemp(job)

--删除索引
drop index INDEX_MGR --分大小写

--同义词
创建公共同义词 公共的话由DBA创建在orcal系统中 我们并看不到
create public synonym emp for scott.emp;

创建私有同义词（只能由创建者自己访问）
create synonym yuangong for emp;

select * from yuangong
select * from emp

insert into emp values(7937,'rows','CLERK',7768,'21/4月/1988',1000.00,'',20,'女');
delete from yuangong where empno=7937
--增删改互相影响

--序列
创建序列
create sequence seq1_name
increment by 1
start with 1

--查询下一个值 并且改变
select SEQ1_NAME.nextval from dual

--查询当前值 不变
select SEQ1_NAME.currval from dual

--使用
create table testsequence(
       t_id integer,
       t_name varchar2(100),
       t_age number(3)

)
insert into testsequence values(SEQ1_NAME.currval,'张三',19);
insert into testsequence values(SEQ1_NAME.nextval,'张三',19);
select * from testsequence

--创建递减序列
create sequence seq2_name
increment by -1
start with 10
maxvalue 10
minvalue 1

--查询下一个值 并且改变
select seq2_name.nextval from dual

--查询当前值 不变
select SEQ1_NAME.currval from dual

--删除序列
drop sequence seq2_name
