--1����ѯ�����������ڲ���ƽ�������Ĳ�����Ϣ��
--��ѯ����ƽ������
select sum(count(*))/count(deptno) from emp group by deptno

select * from dept d,(select deptno,count(deptno) as ct from emp e group by deptno) t
where 
t.deptno = d.deptno
and
t.ct > (select sum(count(*))/count(deptno) from emp group by deptno)


--2����ѯӵ������Ա���Ĳ��ŵĻ�����Ϣ��
--����Ա���Ĳ���
select count(deptno) as minct,deptno from emp group by deptno order by deptno
       
select * from dept d,
       (select count(deptno) as minct,deptno from emp group by deptno order by deptno) t
where rownum = 1 and d.deptno = t.deptno


-- ��ʦ��
select t.dname
  from (select e.deptno, count(*) emp_count
          from emp e
         group by e.deptno
         order by emp_count) tmp1,
       dept t
 where rownum = 1
   and tmp1.deptno = t.deptno
--3����ѯ��ƽ��������ߵĲ�����Ϣ��
--ƽ���������
select avg(sal) as sa,deptno  from emp group by deptno order by sa desc

select * from dept d,
       (select avg(sal) as sa,deptno  from emp group by deptno order by sa desc) t
where d.deptno = t.deptno
and
rownum = 1


--��
select * from dept where deptno=(select deptno from (select deptno,avg(sal)���� from emp group by deptno 
      order by ���� desc) where rownum=1)
      
--4����ѯ�����ʱ����ڲ���ƽ�����ʸߵ�Ա����Ϣ��
--����ƽ������
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
--5����ѯ��û��Ա���Ĳ�����Ϣ��
--is null
select * from dept d left join emp e
on e.deptno = d.deptno 
where e.deptno is null

select * from dept where deptno not in(select deptno from emp)

--6����ѯ�����з�����RESEARCH�������۲���sals�µ�����Ա����Ϣ��
select * from emp e, dept d 
where e.deptno = d.deptno
and d.dname = 'RESEARCH' or d.dname = 'sals'

--7����ѯ��������2000-3500֮�������Ա����
select * from emp e
where e.sal between 2000 and 3500 and e.sex ='��'

--8����ѯ����Ա����Ϣ������ʾ�乤�ʣ���������ڵ���3000����ô��ʾ���죻���������3000��5000֮�䣬��ʾ���죻������ʴ���5000��ʾ���죩
select 
e.empno,
e.ename,
e.sal,
(
case
when sal > 4000 then '����'
when sal > 3000 then '����'
else '����'
end 
)
from emp e

--9����Ա��������ݸ��Ƶ�newEmp���С�
create table newEmp as select * from emp
select * from newemp

--10����ѯ������С���з�����С���ʵ�Ա����Ϣ��
--�з�����С����
select min(e.sal)min_wage from emp e, dept d where e.deptno = d.deptno and d.dname = 'RESEARCH'

select * from emp m 
where m.sal <= (select min(e.sal)min_wage from emp e, dept d where e.deptno = d.deptno and d.dname = 'RESEARCH') 


--����
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
 
