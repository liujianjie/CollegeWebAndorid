--1、查询部门人数大于部门平均人数的部门信息。
    部门人数
    select deptno,count(*)人数 from emp group by deptno
    
    部门平均人数
    select sum(count(*))/count(deptno)平均人数 from emp group by deptno
    
    所以
    select a.deptno,a.dname,a.loc from dept a,(select deptno,count(*)人数 from emp group by deptno) b where
           b.人数>(select sum(count(*))/count(deptno)平均人数 from emp group by deptno) and b.deptno=a.deptno

--2、查询拥有最少员工的部门的基本信息。
    最少员工的deptno
    select deptno from (select deptno,count(*)人数 from emp group by deptno order by 人数 asc)where rownum=1
    
    select * from dept where deptno =
           (select deptno from (select deptno,count(*)人数 from emp group by deptno order by 人数 asc)
                   where rownum=1)

--3、查询出平均工资最高的部门信息。
     单个部门最高的平均工资
     select * from (select deptno,avg(sal)工资 from emp group by deptno order by 工资 desc) where rownum=1

     所以
     select * from dept where deptno=(select deptno from (select deptno,avg(sal)工资 from emp group by deptno 
            order by 工资 desc) where rownum=1)
     

--4、查询出工资比所在部门平均工资高的员工信息。
     部门平均工资     
     select deptno,avg(sal)工资 from emp group by deptno

     --内连接 自动匹配
     select * from emp e,(select deptno,avg(sal)工资 from emp group by deptno)b where
            e.sal>b.工资 and e.deptno=b.deptno

--5、查询出没有员工的部门信息。
     select * from dept where deptno not in(select deptno from emp)

--6、查询出 研发部 RESEARCH’、‘销售部 SALES’下的所有员工信息。
     select * from dept
     select * from emp where deptno in(select deptno from dept where dname='RESEARCH' or dname='SALES')

--7、查询出工资在2000-3500之间的男性员工。
     select * from emp where sal between 2000 and 3500 and sex='男'

--8、查询所有员工信息，并显示其工资（如果工资在低于3000，那么显示灰领；如果工资在3000到5000之间，显示白领；如果工资大于5000显示金领）
     select empno,ename,job,(
        case 
        when sal<3000 then '灰领'
        when sal<5000 and sal>3000 then '白领'
        when sal>5000 then '金领'
        else '未明确'
        end
     )职位
      from emp

--9、将员工表的数据复制到newEmp表中。


--10、查询出工资小于研发部最小工资的员工信息。

