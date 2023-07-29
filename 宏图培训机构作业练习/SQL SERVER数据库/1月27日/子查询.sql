use T1

--compute�Ӿ� ��ۺϺ���һ��ʹ��
select * from main  compute sum(��ʱ) 
--ѧ����
create table student(
	stu_no int primary key identity(1,1) not null,
	stu_name varchar(20),
	stu_sex char(2),
	stu_age tinyint
)  

create table couser(
	cou_no int primary key identity(1,1) not null,
	cou_name varchar(20)
)

create table score(
	sco_id int primary key identity(1,1) not null,
	stu_no int foreign key references student(stu_no),
	cou_no int foreign key references couser(cou_no),
	score float
)
insert into student values('����','��',17)
insert into student values('��˼˼','Ů',20)
insert into student values('������','Ů',17)
insert into student values('���','��',19)
insert into student values('����','��',16)

insert into couser values('JAVA')
insert into couser values('C����')
insert into couser values('HTML')
insert into couser values('SQL')

insert into score values(1,1,66.6)
insert into score values(1,2,77)
insert into score values(1,3,56)
insert into score values(1,4,65)

insert into score values(2,1,65)
insert into score values(2,2,77)
insert into score values(2,3,86)
insert into score values(2,4,98)

insert into score values(3,1,78)
insert into score values(3,2,67)
insert into score values(3,3,65)
insert into score values(3,4,45)

insert into score values(4,1,64)
insert into score values(4,2,76)
insert into score values(4,3,75)
insert into score values(4,4,34)

--�Ӳ�ѯ ��ѯ��ѧ��java�γ̵�ѧ����Ϣ
select * from student where stu_no in
	(select stu_no from score where cou_no in
		(select cou_no from couser where cou_name='C����'))

--�Ӳ�ѯ ��ѯû��ѧ��java�γ̵�ѧ����Ϣ
select * from student where stu_no not in
	(select stu_no from score where cou_no in
		(select cou_no from couser where cou_name='C����'))

--�Ӳ�ѯ�ڶ�����������ɵ���һ��
--��ѯѧ�ţ��������ܷ�
select st.stu_no,st.stu_name,
	(select sum(score) from score sc where sc.stu_no=st.stu_no) �ܷ� from student st

--ɾ��û��ѧ��java������ʹ���19��


select * from student
-- ���ӣ�������(inner join )   �����ӣ������ӣ������ӣ��������ӣ�ȫ����
--��ѯjava�ɼ���C���Գɼ�Ҫ�ߵ�ͬѧ��Ϣ
select * ,s1.score C����,s2.score JAVA from student st
	inner join score s1 on st.stu_no=s1.stu_no and s1.cou_no in(select cou_no from couser where cou_name='JAVA')
		inner join score s2 on st.stu_no=s2.stu_no and s2.cou_no in(select cou_no from couser where cou_name='C����')
			 where s1.stu_no=s2.stu_no and s1.score<s2.score

--������
--��
select * from student st left join score sc on st.stu_no=sc.stu_no 

--��
select * from student st right join score sc on st.stu_no=sc.stu_no 

--ȫ
select * from student st full join score sc on st.stu_no=sc.stu_no 

--����(���϶���)
select * from student st cross join score sc where st.stu_no=sc.stu_no 

--����
select * into bscore from score

delete from bscore

insert into bscore values(2,1,34)
insert into bscore values(2,2,45)
insert into bscore values(2,3,23)
insert into bscore values(2,4,67)

select * from score 
union
select * from bscore order by stu_no