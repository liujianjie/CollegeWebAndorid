create database studydb
on primary(
	name=��ϰ,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\��ҵ ��ϰ\��ϰ.mdf',
	size=3mb,
	maxsize=10mb,
	filegrowth=1mb
)
log on(
	name=��ϰ1,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\��ҵ ��ϰ\��ϰ1.ldf',
	size=1mb,
	maxsize=10mb,
	filegrowth=1mb

)
--�л�
use studydb
--����
--ѧ����Ϣ��
create table student(
	stuid varchar(32) primary key not null,--ѧ�����
	stuname varchar(20) not null,--ѧ������
	age int, --����
	sex char(2) not null check(sex='��' or sex='Ů'),--�Ա�
	address varchar(200) --��ַ
)
--�γ̱�
create table course(
	cid int identity(1,1) primary key not null,--�γ̱��
	cname varchar(20) not null unique,--�γ�����
	teacherid int not null foreign key references teacher(teacherid)--��ʦ���
	
)
--�ɼ���
create table score(
	sid int identity(1,1) primary key not null,--�ɼ����
	cid int not null foreign key references course(cid),--�γ̱��
	stuid varchar(32) not null foreign key references student(stuid),--ѧ�����
	mark float not null check(mark>0 and mark <100)--����

)
--��ʦ��
create table teacher(
	teacherid int identity(1,1) primary key not null,--��ʦ���
	tname varchar(20) not null --��ʦ����

)

--����
		create  table student(
		stuid varchar(20) primary key ,--ѧ�����
		stuname varchar(10) not null,--ѧ������
		age int ,
		sex char(2) not null,
		address varchar(200)
		)
		create table course(
		cid int primary key identity ,
		cname varchar(20) not null,
		teacherid int not null
		)

		create table score(
		sid int primary key identity,
		cid int not null,
		stuid varchar(20) not null,
		mark float not null
		)

		create table teacher(
		tid int primary key identity,
		tname varchar(20)
		)


		--Լ��
		--Ϊ student��sex��Ӽ��Լ��,�Ա�������л�Ů
		alter table student add constraint ck_sex check(sex='��' or sex='Ů')
		--Ϊ course�е�cname���ΨһԼ��
		alter table course add constraint UQ_cname unique(cname)
		--Ϊ course�е�teacherid������Լ��
		alter table course add constraint FK_teacherid foreign key(teacherid) references teacher(tid)
		--Ϊ score�е�cid������Լ��
		alter table score add constraint FK_cids foreign key(cid) references course(cid)
		--Ϊ score�е�stuid������Լ��
		alter table score add constraint FK_stuid foreign key(stuid) references student(stuid)

delete  score 
		--��������
		select*from student
		insert into student values('001','����',18,'��','�㶫ʡ�麣��')
		insert into student values('002','����',17,'��','�㶫ʡ�麣��')
		insert into student values('003','����',18,'Ů','�㶫ʡ�麣��')
		insert into student values('004','����',17,'Ů','�㶫ʡ�麣��')
		insert into student values('005','����',18,'Ů','�㶫ʡ�麣��')
		insert into student values('006','�Ž�Ӣ',38,'��','���ܵظ�')

        insert into  teacher values('���»�')
		insert into  teacher values('�ܽ���')
		insert into  teacher values('�Ž�')
		insert into  teacher values('����')
		insert into  teacher values('����')
		insert into  teacher values('����Ӣ')
		insert into  teacher values('����')
		insert into  teacher  values('����')
		select *from  teacher   
        
		insert into course values('C#',1)
		insert into course values('JAVA',2)
		insert into course values('SQL',3)
		select *from course
		
        select *from score
		insert  into score values(1,'001',90)
		insert  into score values(1,'002',70)
		insert  into score values(1,'003',12)
		insert  into score values(1,'004',26)
		insert  into score values(1,'005',38)
		insert  into score values(1,'006',42)
		insert  into score values(2,'001',55)
		insert  into score values(2,'002',63)
		insert  into score values(2,'003',66)
		insert  into score values(2,'004',77)
		insert  into score values(2,'005',88)
		insert  into score values(2,'006',99)
		insert  into score values(3,'001',99)
		insert  into score values(3,'002',99)
		insert  into score values(3,'003',99)
		insert  into score values(3,'004',99)
		insert  into score values(3,'005',99)
		insert  into score values(3,'006',99)
        delete score where cid=1 and stuid='006'

--��ʼ����Ŀ���� 
	--1)	��ѯ java �γ̱� C���Է����ߵ�ѧ��
		select stuname,s1.mark HTML,s2.mark JAVA from student st
			inner join score s1 on st.stuid=s1.stuid and s1.cid=(select cid from course where cname='JAVA')
				inner join score s2 on st.stuid=s2.stuid and s2.cid=(select cid from course where cname='HTML')
					where s1.stuid=s2.stuid and s1.mark<s2.mark
		

	--2)	��ѯƽ���ֳɼ����� 70 �ֵ�ͬѧ��������ƽ���ɼ�
		select st.stuname as ����,avg(mark)ƽ���� from student st,score s where st.stuid=s.stuid 
				group by st.stuname having avg(mark)>50--��ͳ�������е���
		select st.stuname,
			(select avg(mark) from score where stuid=st.stuid having avg(mark)>55)ƽ����
			from student st  -- ���Ӳ�ѯ�����е�С覴�

	--3)	��ѯ����ͬѧ��ѧ�š�����ѡ�������ܳɼ�
		select st.stuname,stuid,
			(select sum(mark) from score where stuid=st.stuid)�ܷ�,
			(select count(cid) from score where stuid=st.stuid)ѡ����
			from student st  -- ���Ӳ�ѯ����

	--4)	��ѯ�ա���������ʦ�ĸ���
		select * from teacher where tname like '��%'

	--5)	��ѯû��ѧ�� java �ε�ѧ����ѧ�š�����
		select st.stuname,st.stuid from student st,score s where st.stuid not In (select stu_no from score where course_no=
			(select course_no from course where course_name='JAVA'))

	--6)	��ѯѧ����C#���γ̲���Ҳѧ����sql���γ̵�ѧ����ѧ�š�����
		select st.stuname,st.stuid from student st where
			st.stuid in (select stuid from score where cid=(select cid from course where cname='C����')) 
			and st.stuid in(select stuid from score where cid=(select cid from course where cname='���ݿ�'))

	--7)	��ѯ���пγ̵�ƽ���֡�������
		select cname,avg(mark)ƽ����,((select count(*) from score where mark>60 and cid=c.cid)*1.0 /
			(select count(*) from score where cid=c.cid)*1.0)������
			from score s,course c where s.cid=c.cid group by cname,c.cid--����
	
	--8)	��ѯ���пγ̳ɼ�С�� 60 �ֵ�ͬѧ��ѧ�š��������Ա�
		select st.stuid,stuname,sex from student st 
			where stuid not in(select stuid from score where stuid=st.stuid and mark >60) 

	--9)	��ѯû��ѧȫ���пε�ͬѧ��ѧ�š��������Ա�
		select stuid,stuname,sex from student where (select count(*) from score where student.stuid=stuid)<3
		select stuid,count(*) from score group by stuid


	--12)	�ѳɼ����С����ɡ���ʦ�̵Ŀεĳɼ�������Ϊ�˿γ̵�ƽ���ɼ�
		update score set mark=(select avg(mark) from score where cid=(select cid from course where teacherid=(select teacherid from teacher where tname='����')))
		

	--14)	ɾ��ѧϰ�����ġ���ʦ�εĳɼ����¼
		select * from course where teacherid=4
		delete from score where cid =(select cid from course where 
			teacherid=(select teacherid from teacher where tname='����'))

	--16)	��ѯ���Ƴɼ���ߺ���͵ķ֣���������ʽ��ʾ���γ� ID����߷֣���ͷ�
		select c.cid,c.cname,max(mark)��߷�,min(mark)��ͷ�
			from course c,score s where c.cid=s.cid group by c.cname,c.cid --���� ����������

	--17)	��ѯ��ͬ��ʦ���̲�ͬ�γ�ƽ���ִӸߵ�����ʾ
		select 
			(select tname from teacher where teacherid in (select teacherid from course where cid in(select cid from score))),
			(select cname from course where cid in (select cid from score)),
			avg(mark)ƽ����
		from score s group by cid 

		select avg(mark)ƽ����
			from score s group by cid order by ƽ���� desc

	--18)	��ѯ���Ƴɼ�ǰ�����ļ�¼:(�����ǳɼ��������)




	--21)	��ѯ������Ů������
		select count(sex)�������� from student where sex='��'
		select count(sex)Ů������ from student where sex='Ů'