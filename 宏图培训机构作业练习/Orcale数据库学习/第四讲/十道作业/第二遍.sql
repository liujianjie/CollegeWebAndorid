--1����ѯ�����������ڲ���ƽ�������Ĳ�����Ϣ��
    ��������
    select deptno,count(*)���� from emp group by deptno
    
    ����ƽ������
    select sum(count(*))/count(deptno)ƽ������ from emp group by deptno
    
    ����
    select a.deptno,a.dname,a.loc from dept a,(select deptno,count(*)���� from emp group by deptno) b where
           b.����>(select sum(count(*))/count(deptno)ƽ������ from emp group by deptno) and b.deptno=a.deptno

--2����ѯӵ������Ա���Ĳ��ŵĻ�����Ϣ��
    ����Ա����deptno
    select deptno from (select deptno,count(*)���� from emp group by deptno order by ���� asc)where rownum=1
    
    select * from dept where deptno =
           (select deptno from (select deptno,count(*)���� from emp group by deptno order by ���� asc)
                   where rownum=1)

--3����ѯ��ƽ��������ߵĲ�����Ϣ��
     ����������ߵ�ƽ������
     select * from (select deptno,avg(sal)���� from emp group by deptno order by ���� desc) where rownum=1

     ����
     select * from dept where deptno=(select deptno from (select deptno,avg(sal)���� from emp group by deptno 
            order by ���� desc) where rownum=1)
     

--4����ѯ�����ʱ����ڲ���ƽ�����ʸߵ�Ա����Ϣ��
     ����ƽ������     
     select deptno,avg(sal)���� from emp group by deptno

     --������ �Զ�ƥ��
     select * from emp e,(select deptno,avg(sal)���� from emp group by deptno)b where
            e.sal>b.���� and e.deptno=b.deptno

--5����ѯ��û��Ա���Ĳ�����Ϣ��
     select * from dept where deptno not in(select deptno from emp)

--6����ѯ�� �з��� RESEARCH���������۲� SALES���µ�����Ա����Ϣ��
     select * from dept
     select * from emp where deptno in(select deptno from dept where dname='RESEARCH' or dname='SALES')

--7����ѯ��������2000-3500֮�������Ա����
     select * from emp where sal between 2000 and 3500 and sex='��'

--8����ѯ����Ա����Ϣ������ʾ�乤�ʣ���������ڵ���3000����ô��ʾ���죻���������3000��5000֮�䣬��ʾ���죻������ʴ���5000��ʾ���죩
     select empno,ename,job,(
        case 
        when sal<3000 then '����'
        when sal<5000 and sal>3000 then '����'
        when sal>5000 then '����'
        else 'δ��ȷ'
        end
     )ְλ
      from emp

--9����Ա��������ݸ��Ƶ�newEmp���С�


--10����ѯ������С���з�����С���ʵ�Ա����Ϣ��

