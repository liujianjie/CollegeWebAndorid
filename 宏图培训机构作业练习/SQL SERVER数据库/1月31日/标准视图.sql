--��ͼ
use T1
--���� 
create view v_student 
as
select * from student

--��ѯ��ͼ
select * from v_student

--ʹ�ã�����Ϊ��ɾ�� �����Ըı�ԭ���ı�
insert into v_student values('С��','Ů',19,'345234234')

--���� with chect option
create view v_student2
as
select * from student where stu_age>18
with check option

select * from v_student2
--��������һ��С��18�������
insert into v_student2 values('С��','Ů',17,'34985233434234')--����

--������ with encryption����
create view v_student3
with encryption
as
select * from student

insert into v_student3 values('С��','Ů',17,'3433434234')--����

select * from v_student3--������ɾ�� �����޸�

--������ͼ������ͼ��
create view v_student4
as
select * from v_student3 where stu_age>18

select * from v_student4

--������ʱ��͹ؼ���
use task

select *,(select classname from classes cs where cs.classno=st.classno) �༶ from student st
select stuno,stuname,cs.classno,sex,age,cs.classname from student st left join classes cs on cs.classno=st.classno

--��ʱ���Ӳ�ѯ������ Ҫ������
create view v_student
as
select stuno,stuname,cs.classno,sex,age,cs.classname from student st left join classes cs on cs.classno=st.classno

create view v_student2
as
select *,(select classname from classes cs where cs.classno=st.classno) �༶ from student st

select * from v_student2
--�������
create view v_student3
as
select * from student s ,(select * from classes) c where  s.classno=c.classno

--order by��ָ���� TOP �� FOR XML������ORDER BY �Ӿ�����ͼ�������������������Ӳ�ѯ�͹��ñ���ʽ����Ч��
create view v_student3
as
select * from student order by age

--��ɾ�����ʱ�� ��ͼ���廹�� ���ǽ���������� 
use T1
select * from v_student

--�޸���ͼ�Ĳ�ѯ���
alter view v_student
as
select * from score


delete from student where stu_no=9

drop view v_student2

