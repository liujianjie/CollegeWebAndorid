--�л����ݿ�
use ��ϰ

alter table student add stu_age int
--��ʼ
--�ڲ�����
select * from student st inner join course c on st.course_no=c.course_no

--������
select * from student st left join score s on st.score_no=s.score_no

--������
select * from student st right join course s on st.course_no=s.course_no

--ȫ������
select * from student st full join score s on st.score_no=s.score_no

--��������
select * from student cross join course