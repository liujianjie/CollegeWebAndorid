--Ħ���㣨ȡ�ࣩ
mod(2,3)
--�����
select mod(2,3) from dual;

--> < <= >=  <>
select * from emp where comm is not null;
--between and ������ >= and <=
select * from emp 
where hiredate between to_date('1981-1-1','yyyy-MM-dd') and to_date('1982-1-1','yyyy-MM-dd');
--exists
select * from  emp where deptno in(select deptno from dept);

select * from emp a where exists(select null from dept b where b.deptno=a.deptno);

--���ϲ�����
--union����
select * from emp;
select * from emp_bak for update ;
--union ��ȥ���ظ����ݱ���һ��
select * from emp
union 
select * from emp_bak;
--union all ��ȥ�ر�����������
select * from emp
union all
select * from emp_bak;

--intersect����������ֻ��ѯ�ظ�������
select * from emp
intersect
select * from emp_bak;
--minus��ȫȥ���ظ�����,�ӱ�����ݲ���ʾ
select * from emp
minus
select * from emp_bak;

--�ַ������ӷ�
select 'hello ' || 'Oracle' from dual;
