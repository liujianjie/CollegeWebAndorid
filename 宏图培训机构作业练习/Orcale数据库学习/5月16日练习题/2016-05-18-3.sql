select * from dept t

select t.deptno,t.dname from dept t

select * from emp e where e.deptno = 10

select * from emp e where e.job = 'CLERK' OR e.job = 'MANAGER'

select * from emp e where e.deptno between 10 and 30

/**��˹*/
select * from emp e where e.ename like 'J%'

select * from emp e where e.sal <2000 order by e.sal desc

/** location*/
select e.ename,e.sal,t.dname,t.loc from emp e ,dept t where e.deptno = t.deptno and e.job = 'CLERK'


select e.ename, e.sal, e.mgr, ee.ename
  from emp e, emp ee
 where e.sal > 2000
   and e.mgr = ee.empno
   
select *
  from emp ee
 where ee.sal > (select e.sal from emp e where e.ename = 'JONES')

select * from emp e where e.deptno not in (select deptno from dept)

/** distinct ��������ȥ���ظ��ļ�¼*/


select *
  from emp e
 where e.deptno in (select distinct e.deptno
                      from emp e
                     where e.sal < 3000
                       and e.sal > 1000)
 
select * from emp e where e.sal =  (select max(sal) from emp e)

select * from (select * from emp e order by e.sal desc ) ee where rownum = 1

select * from emp e for update

select * from emp e order by e.sal desc

/** ����û�б��Ⲣ�е�����*/


/** rownum r ,sql����Ƕ��*/
select *    
  from (select *
          from (select * from emp )
         where rownum <= 9 order by empno desc)
 where rownum <=5 ;
 
 select * from emp 
 
 
 /** ��ȡ�ڶ��ߵĹ����Ƕ��٣���ditinctȥ���ظ���¼ */
select *
  from (select *
          from (select distinct e.sal from emp e order by e.sal desc)
         where rownum <= 2 order by sal) where rownum =  1

select * from (select *
  from (select distinct e.sal from emp e order by e.sal desc)
 where rownum <= 2
 order by sal ) where rownum = 1


/** ������ʵ��*/
select e.sal,e.ename,rank() over(order by e.sal desc) as ���� from emp e;


/** �������˼·ʵ��*/

select *  
  from emp e
 where e.sal < (select *
                  from (select e.sal from emp e order by e.sal desc) ee
                 where rownum = 1)
 order by e.sal



