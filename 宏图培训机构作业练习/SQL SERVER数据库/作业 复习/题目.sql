

		--�������ݿ�
		if exists (select*from sysdatabases where name='studydb')
			drop database studydb

		go
		create database studydb
		on(
			name='studydb_mdf',--�����ݵ��߼���
			filename='E:\ch01\studydb_mdf.mdf',--���ļ���������
			size=5,--���ļ��ĳ�ʼ��С
			maxsize=10,--���ļ�����󴢴�ռ�
			filegrowth=2--���ļ���������
		),
		(
			name='studydb_ndf',--�����ݵ��߼���
			filename='E:\ch01\studydb_ndf.ndf',--���ļ���������
			size=1,--���ļ��ĳ�ʼ��С
			maxsize=10,--���ļ�����󴢴�ռ�
			filegrowth=2--���ļ���������
		)
		log on(
			name='studydb_log',--��־�ļ����߼���
			filename='E:\ch01\studydb.ldf',--��־�ļ���������
			size=1,--��־�ļ��ĳ�ʼ��С
			maxsize=10,--��־�ļ�����󴢴�ռ�
			filegrowth=2--��־�ļ���������
		)
		go
		use studydb
		go


		--����
		--ѧ����Ϣ��
		create  table student(
			stuid varchar(20) primary key ,--ѧ�����
			stuname varchar(10) not null,--ѧ������
			age int ,
			sex char(2) not null,
			address varchar(200)
		)
		--�γ̱�
		create table course(
			cid int primary key identity ,
			cname varchar(20) not null,
			teacherid int not null
		)
		--������
		create table score(
			sid int primary key identity,
			cid int not null,
			stuid varchar(20) not null,
			mark float not null
		)
		--��ʦ��
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

		--��������
		select*from student
		insert into student values('001','����',18,'��','����ʡ������')
		insert into student values('002','����',17,'��','����ʡ������')
		insert into student values('003','����',18,'Ů','����ʡ������')
		insert into student values('004','����',17,'Ů','����ʡ������')
		insert into student values('005','����',18,'Ů','�����˼�')
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
		--1����ѯ java �γ̱� C#�����ߵ�ѧ��
		select * from score 
		select * from course
		--select * from student st where stuid in(  )
		select st.stuid,cname,mark from student st,course c,score s where st.stuid=s.stuid and s.cid=c.cid
		--C#�ķ���
		select stuid, mark from score s  where s.cid in (select cid from course where cname='C#')	
		--JAVA �ķ���	
		select stuid, mark from score s  where s.cid in (select cid from course where cname='JAVA')
	
		select * from student st where stuid in(select stuid from score 
		where (select  mark from score s  where s.cid in (select cid from course where cname='JAVA')and  st.stuid=s.stuid)>
		(select  mark from score s  where s.cid in (select cid from course where cname='C#' and  st.stuid=s.stuid )))


		--2)��ѯƽ���ֳɼ����� 70 �ֵ�ͬѧ��������ƽ���ɼ�
		select stuname,avg(mark) ƽ���� from student st,score s where st.stuid=s.stuid group by stuname
		 having avg(mark) >70  order by ƽ���� desc 

		--3)��ѯ����ͬѧ��ѧ�š�������ѡ�������ܳɼ�
		select st.stuid,stuname,count(*) ѡ���� ,sum(mark) �ܷ� from student st,score s where st.stuid=s.stuid  group by st.stuid,stuname
		
		--4)��ѯ�ա���������ʦ�ĸ���
		select count(*) ������ʦ���� from teacher where tname like '��%'		

		--5)��ѯû��ѧ�� java �ε�ѧ����ѧ�š�����
		select * from score 
		select * from course 
		select stuid,stuname from student where stuid not in(select stuid from score where cid=(select cid from course where cname='JAVA'))
		--6)��ѯѧ����C#���γ̲���Ҳѧ����sql���γ̵�ѧ����ѧ�š�����  
		select stuid,stuname from student where stuid in
		(select stuid from score where cid=(select cid from course where cname='C#')) and 
		stuid in(select stuid from score where cid=(select cid from course where cname='SQL')) 

		--7)��ѯ���пγ̵�ƽ���֡�������(��������/������)
		select cname,avg(mark),(select count(*) from score  where mark >60 and cid=s.cid)*1.0/(select count(*) from score where  cid=s.cid)*1.0) ������ from score s,course  c where s.cid=c.cid group by cname,s.cid

		--8)��ѯ���пγ̶��ɼ�С��60 �ֵ�ͬѧ��ѧ�š��������Ա�
		
		select * from score order by stuid 	

		select st.stuid,stuname,sex from student st where  stuid not in
		(select stuid from score where stuid=st.stuid and mark >60 )
 
		--9)��ѯû��ѧȫ���пε�ͬѧ��ѧ�š��������Ա�
		select stuid,count(*) from score group by stuid 
		select st.stuid,stuname,sex from student st where 
			(select count(*) from score where st.stuid=stuid)<3
		--10)��ѯ������һ�ſ���ѧ��Ϊ��002����ͬѧ��ѧ��ͬ��ͬѧ��ѧ�ź�����
		select cid from score where stuid='002'
		select st.stuid ,stuname from student st where stuid!='002'  and stuid in 
		(select stuid from score where cid = any(select cid from score where stuid='002'))

		--12)�ѳɼ����С����족��ʦ�̵Ŀεĳɼ�������Ϊ�˿γ̵�ƽ���ɼ�

		select tid  from teacher where tname='����'

		select * from course where teacherid =	(select tid  from teacher where tname='����')

		select avg(mark) from score where cid=(select cid from course where teacherid =(select tid  from teacher where tname='����'))
		update score set mark=(select avg(mark) from score where cid=(select cid from course where teacherid =(select tid  from teacher where tname='����')))
		where cid=(select cid from course where teacherid =(select tid  from teacher where tname='����'))

		select * from score  order by stuid

		--13)��ѯ�͡�002���ŵ�ͬѧѧϰ�Ŀγ���ȫ��ͬ������ͬѧѧ�ź�����
		select cid from score where stuid='002'
		select st.stuid,stuname from student st where stuid in
		(select stuid from score where cid  not in(select cid from score where stuid='002'))


		--14)ɾ��ѧϰ�����족��ʦ�εĳɼ����¼
		select * from course where teacherid =	(select tid  from teacher where tname='����')		
		delete from score where cid =(select cid from course where teacherid =	(select tid  from teacher where tname='����'))
		
		--15)��ƽ���ɼ��Ӹߵ�����ʾ����ѧ���ġ�sql������java������c#�����ŵĿγ� �ɼ�����������ʽ��ʾ��ѧ�� ID,sql,java,c#,��Ч�γ���,��Чƽ����
			select stuid,stuname ,
			(select mark from score where st.stuid=stuid and cid=(select cid from course where cname='SQL')) ���ݿ�,
			(select mark from score where st.stuid=stuid and cid=(select cid from course where cname='JAVA')) JAVA,
			(select mark from score where st.stuid=stuid and cid=(select cid from course where cname='C#')) C#,
			(select count(mark) from score where st.stuid=stuid)��Ч�γ���,
			(select avg(mark) from score where st.stuid=stuid )��Чƽ����
		 from student st order by ��Чƽ���� desc
		--16)��ѯ���Ƴɼ���ߺ���͵ķ֣���������ʽ��ʾ���γ� ID����߷֣���ͷ�
			select cid,max(mark) ��߷�,min(mark) ��ͷ� from score group by cid 
		--