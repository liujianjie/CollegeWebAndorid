create database task
 on primary(
	name=�ϻ���ҵ,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\1��29��\�ϻ���ҵ.mdf',
	size=3mb,
	maxsize=100mb,
	filegrowth=1mb

)
log on(
	name=�ϻ���ҵ2,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\1��29��\�ϻ���ҵ.ldf',
	size=3mb,
	maxsize=100mb,
	filegrowth=1mb


)
use task
create table classes(
	classno varchar(7) primary key not null,
	classname varchar(7) not null

)
create table course(
	cno varchar(7) primary key not null,
	cname varchar(7) not null

)
create table student(
	stuno varchar(8) primary key not null,
	stuname varchar(8) not null,
	classno varchar(7) not null,
	sex char(2) not null,
	age tinyint not null

)

create table studentcourse(
	stuno varchar(8) foreign key references student(stuno),
	cno	varchar(7) foreign key references course(cno),
	score float
)
insert into classes values('200801','ST0801')
insert into classes values('200802','ST0802')
insert into classes values('200803','ST0803')
delete from classes

insert into course values('201','C����')
insert into course values('202','JAVA')
insert into course values('203','JSP')

alter table student add constraint banjiwaijian foreign key (classno) references classes(classno)
insert into student values('20080101','����','200801','M',19)
insert into student values('20080102','����','200801','F',19)
insert into student values('20080201','����','200802','M',19)

insert into studentcourse values('20080101','201',71)
insert into studentcourse values('20080102','201',80.5)
insert into studentcourse values('20080101','202',65.5)
insert into studentcourse values('20080102','202',56)
insert into studentcourse values('20080101','203',45)

--1.��ѯͬ������ͬһ���༶��ѧ����ʹ���Ӳ�ѯʵ�֣�
	select * from student where classnO=
		(select classno from student where stuname='����')

--2.	��ѯ������C���Գɼ�
	select * from studentcourse where stuno=
		(select stuno from student where stuname='����') and cno=
			(select cno from course where cname='C����')
--3.	�޸�������C���Գɼ�Ϊ85
	update studentcourse set score=85 where stuno=
		(select stuno from student where stuname='����') and cno=
			(select cno from course where cname='C����')
--4.	ɾ��������HTML�ɼ�
	delete studentcourse where stuno=
		(select stuno from student where stuname='����') and cno=
				(select cno from course where cname='JSP')
--5.	��ѯC���Ե���߳ɼ�
	select max(score)���� from studentcourse where cno=
		(select cno from course where cname='C����') 

--6.	��ѯC���Գɼ���ߵ�ѧ���Ļ�����Ϣ
	select *from student where stuno in (select stuno from studentcourse where score=
		(select max(score)���� from studentcourse where cno=
			(select cno from course where cname='C����')))

							5.	������ϰ
select * from classes
select * from course
select * from student
select * from studentcourse
--5.1.	��ѯ����ѧ����������ѧ�ż��༶����
	select stuno,stuname,(select classname from classes cs where cs.classno=st.classno) �༶ from student st

--5.2.	��ѯ����ѧ�����ſγ̵ĳɼ����г��������༶�����γ������ɼ�
	select score,(select stuname from student st where st.stuno=sc.stuno) ����,
		(select classname from classes cs where cs.classno=st.classno) �༶,
			(select cname from course ce where sc.cno=ce.cno) �γ���
				 from studentcourse sc,student st,classes cs,course ce
					 where st.stuno=sc.stuno and cs.classno=st.classno and ce.cno=sc.cno

--5.3.	�ֱ�ʹ���Ӳ�ѯ�����Ӳ�ѯʵ�֣���ѯST0801���C����ƽ���ɼ�
	select avg(score) ƽ���ɼ� from studentcourse where cno=(select cno from course where cname='C����')
		and stuno IN(select stuno from student where classno=(select classno from classes where classname='ST0801'))

--5.4.	��ѯ����C���Գɼ��������ڰ༶ƽ���ɼ��ߵ�ѧ��
	select * from studentcourse where cno=(select cno from course where cname='C����') and score>(	select avg(score) ƽ���ɼ� from studentcourse where cno=(select cno from course where cname='C����')
		and stuno IN(select stuno from student where classno=(select classno from classes where classname='ST0801')))

--5.5.	����C����û�гɼ�������ѧ������Ϣ��ʹ��existsʵ�֣�
	select * from student where stuno not in(select stuno from studentcourse where cno not in(select cno from course where cname='C����'))

--5.6.	ʹ��SQL��ST0801�������ѧ������Ϣ���뵽һ���±�StudentST0801��
	select * into studentst0801 from classes where classname='st0801'

--5.7.	��ѯ��Student���д��ڣ�����StudentST0801���в����ڵ�ѧ��
	select * from student where classno not in(select classno from studentst0801)
	
--5.8.	ɾ��Student200801�������ѧ��
	delete from student where classno not in(select classno from studentst0801)

--5.9.	��ѯClasses���StudentST0801�������ѧ���ϵ�һ���������
	select * from student where classno in(select classno from studentst0801)
	union
	select * from student where classno in(select classno from classes)
--6.1.	��һ��SQL��� ��ѯ��ÿ�ſζ�����80�ֵ�ѧ������ 
	select stuname from student where stuno  in(select stuno from studentcourse group by stuno having min(score)>80)

--6.2.	��ѯ������ͬ����ѧ�����г��������༶
	select classno,stuname from student where stuname (select stuname from student group by stuname having count(stuname)>1)in

--6.3.	����ÿ��ѧ��ÿ�ſγ̶�Ӧ���гɼ�����ѯ��û�гɼ���ѧ������γ̣��г��������༶�����γ̡��ɼ� 
	select stuname,cname,0 from student a cross join course b  where  not exists (--����
	select stuname,cname from student s 
	inner join studentcourse s1 on s.stuno=s1.stuno --������������ֶ���Ϊ����
	inner join course c on c.cno= s1.cno
	where a.stuno=s.stuno and b.cno=c.cno
)
	select stuname,(select classname from classes cs where cs.classno=st.classno)�༶,
		(select cname from course cs where cs.cno=stc.cno)�γ�
			from student st ,studentcourse stc where not exists (
					select stuname,(select classname from classes cs1 where cs1.classno=st1.classno)�༶,
					(select cname from course cs1 where cs1.cno=stc1.cno)�γ�
					from student st1 ,studentcourse stc1 where stc1.stuno=st1.stuno 
					)
					and stc.stuno=st.stuno 

--6.4.	��ѯ�ó����½����'
	select stuname,age,sex,
	(select score from studentcourse where cno=201 and s.stuno=stuno) C����,
	(select score from studentcourse where cno=202 and s.stuno=stuno) JAVA,
	(select score from studentcourse where cno=203 and s.stuno=stuno) JSP

	from student s
 