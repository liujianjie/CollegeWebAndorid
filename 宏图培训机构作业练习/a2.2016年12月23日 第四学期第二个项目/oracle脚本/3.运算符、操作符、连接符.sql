--摩运算（取余）
mod(2,3)
--虚拟表
select mod(2,3) from dual;

--> < <= >=  <>
select * from emp where comm is not null;
--between and 类似于 >= and <=
select * from emp 
where hiredate between to_date('1981-1-1','yyyy-MM-dd') and to_date('1982-1-1','yyyy-MM-dd');
--exists
select * from  emp where deptno in(select deptno from dept);

select * from emp a where exists(select null from dept b where b.deptno=a.deptno);

--集合操作符
--union联合
select * from emp;
select * from emp_bak for update ;
--union 会去除重复数据保留一条
select * from emp
union 
select * from emp_bak;
--union all 不去重保留所有数据
select * from emp
union all
select * from emp_bak;

--intersect（交集），只查询重复的数据
select * from emp
intersect
select * from emp_bak;
--minus完全去除重复数据,从表的数据不显示
select * from emp
minus
select * from emp_bak;

--字符串连接符
select 'hello ' || 'Oracle' from dual;
