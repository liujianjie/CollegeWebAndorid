--1、查询部门人数大于部门平均人数的部门信息。
--查询部门平均人数
select sum(count(*))/count(deptno) from emp group by deptno

select * from dept d,(select deptno,count(deptno) as ct from emp e group by deptno) t
where 
t.deptno = d.deptno
and
t.ct > (select sum(count(*))/count(deptno) from emp group by deptno)


--2、查询拥有最少员工的部门的基本信息。
--最少员工的部门
select count(deptno) as minct,deptno from emp group by deptno order by deptno
       
select * from dept d,
       (select count(deptno) as minct,deptno from emp group by deptno order by deptno) t
where rownum = 1 and d.deptno = t.deptno


-- 老师的
select t.dname
  from (select e.deptno, count(*) emp_count
          from emp e
         group by e.deptno
         order by emp_count) tmp1,
       dept t
 where rownum = 1
   and tmp1.deptno = t.deptno
--3、查询出平均工资最高的部门信息。
--平均工资最高
select avg(sal) as sa,deptno  from emp group by deptno order by sa desc

select * from dept d,
       (select avg(sal) as sa,deptno  from emp group by deptno order by sa desc) t
where d.deptno = t.deptno
and
rownum = 1


--二
select * from dept where deptno=(select deptno from (select deptno,avg(sal)工资 from emp group by deptno 
      order by 工资 desc) where rownum=1)
      
--4、查询出工资比所在部门平均工资高的员工信息。
--部门平均工资
select avg(sal) from emp group by deptno

select * from emp e, (select avg(sal) as sal,deptno from emp group by deptno) d
where e.sal > d.sal and e.deptno = d.deptno

select *
  from emp e,
       (select e.deptno, avg(e.sal) avg_sal
          from emp e
         group by e.deptno
         order by avg(e.sal)) tmp1
 where tmp1.deptno = e.deptno and tmp1.avg_sal < e.sal
--5、查询出没有员工的部门信息。
--is null
select * from dept d left join emp e
on e.deptno = d.deptno 
where e.deptno is null

select * from dept where deptno not in(select deptno from emp)

--6、查询出‘研发部’RESEARCH、‘销售部’sals下的所有员工信息。
select * from emp e, dept d 
where e.deptno = d.deptno
and d.dname = 'RESEARCH' or d.dname = 'sals'

--7、查询出工资在2000-3500之间的男性员工。
select * from emp e
where e.sal between 2000 and 3500 and e.sex ='男'

--8、查询所有员工信息，并显示其工资（如果工资在低于3000，那么显示灰领；如果工资在3000到5000之间，显示白领；如果工资大于5000显示金领）
select 
e.empno,
e.ename,
e.sal,
(
case
when sal > 4000 then '金领'
when sal > 3000 then '白领'
else '灰领'
end 
)
from emp e

--9、将员工表的数据复制到newEmp表中。
create table newEmp as select * from emp
select * from newemp

--10、查询出工资小于研发部最小工资的员工信息。
--研发部最小工资
select min(e.sal)min_wage from emp e, dept d where e.deptno = d.deptno and d.dname = 'RESEARCH'

select * from emp m 
where m.sal <= (select min(e.sal)min_wage from emp e, dept d where e.deptno = d.deptno and d.dname = 'RESEARCH') 


--不好
select sal from emp where deptno in (select deptno from dept where dname='RESEARCH') and
       sal=(select min(sal) from emp where deptno in (select deptno from dept where dname='RESEARCH'))
       

select * from emp 
where 
sal<=(select sal from emp where deptno 
in 
(select deptno from dept where dname='RESEARCH') 
and
sal=(select min(sal) from emp where deptno 
in
(select deptno from dept where dname='RESEARCH')))      
 
