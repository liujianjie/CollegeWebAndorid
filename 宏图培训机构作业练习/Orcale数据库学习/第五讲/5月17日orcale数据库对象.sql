--��ҳ���Ĵ��� ��sql�Ĳ�һ�� ��Ϊorcale�����topû�� ������rownum����
select * from emp

select * from(select rownum r,e.* from emp e where rownum<=10) where r>5

int pagecount=5;
int currpage=1;
select * from(select rownum r,e.* from emp e where rownum<=pagecount*currpage) where r>(currpage-1)*pagecount

--��ͼ
select * from newemp
insert into newemp select * from newemp

--������ͨ��ͼ
create or replace view newemp_view
as
select * from newemp

--������û��Ȩ�޵� Ҫ��������и��� Ҫ��¼����Ա
��Ȩ:grant create view to scott;
����:revoke create view from scott;

--�鿴��ͼ
select * from newemp_view

--�鿴����û����е���ͼ
select * from user_views

--����ͼ��һЩ������ Լ�� ����ͼ�Ĳ������Ƕ�ԭ��Ĳ���
insert into newemp_view values(7935,'JACK','CLERK',7768,'21/4��/1988',4000.00,'',20,'��');

--����
create or replace view newemp_view2
as
select * from newemp where sal>2500

select * from newemp_view2
--������ݿ����������ͼ����û��
insert into newemp_view2 values(7936,'rows','CLERK',7768,'21/4��/1988',1000.00,'',20,'Ů');

select * from newemp for update--ֻ�л�����

--������ͼ
create or replace view newemp_view3
as
select * from newemp where sal>2500 with check option

select * from newemp_view3

--�����������
insert into newemp_view3 values(7936,'rows','CLERK',7768,'21/4��/1988',1000.00,'',20,'Ů');

--���������ͼ create or replace ��˼�������ͼ�����򸲸� ����������򴴽� 
create view student1
as
select s.stu_id,s.stu_name,s.stu_age,c.cno,cname from student s inner join classes c on s.cno=c.cno

select * from classes
select * from student
select * from student1

--�������ɾ��

insert into student1 values(8,'����',17,1002,'��ͼ15��1��')

delete from student1 

update student1 set cno=1002 where stu_id=2

--ɾ����ͼ
drop view student1

--ע�⣺��ͼ�������ظ�����

--����
������ͨ��������Ψһ������
create index index_mgr on newemp(mgr)

����Ψһ����(�Զ������м���ΨһԼ��)
select * from newemp

create unique index index_ename on newemp(ename)
insert into newemp values(7937,'rows','CLERK',7768,'21/4��/1988',1000.00,'',20,'Ů');--��ͼӲ�����

����λͼ����
create bitmap index index_job on newemp(job)

--ɾ������
drop index INDEX_MGR --�ִ�Сд

--ͬ���
��������ͬ��� �����Ļ���DBA������orcalϵͳ�� ���ǲ�������
create public synonym emp for scott.emp;

����˽��ͬ��ʣ�ֻ���ɴ������Լ����ʣ�
create synonym yuangong for emp;

select * from yuangong
select * from emp

insert into emp values(7937,'rows','CLERK',7768,'21/4��/1988',1000.00,'',20,'Ů');
delete from yuangong where empno=7937
--��ɾ�Ļ���Ӱ��

--����
��������
create sequence seq1_name
increment by 1
start with 1

--��ѯ��һ��ֵ ���Ҹı�
select SEQ1_NAME.nextval from dual

--��ѯ��ǰֵ ����
select SEQ1_NAME.currval from dual

--ʹ��
create table testsequence(
       t_id integer,
       t_name varchar2(100),
       t_age number(3)

)
insert into testsequence values(SEQ1_NAME.currval,'����',19);
insert into testsequence values(SEQ1_NAME.nextval,'����',19);
select * from testsequence

--�����ݼ�����
create sequence seq2_name
increment by -1
start with 10
maxvalue 10
minvalue 1

--��ѯ��һ��ֵ ���Ҹı�
select seq2_name.nextval from dual

--��ѯ��ǰֵ ����
select SEQ1_NAME.currval from dual

--ɾ������
drop sequence seq2_name
