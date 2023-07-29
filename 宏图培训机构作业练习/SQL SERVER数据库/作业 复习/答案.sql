		--�л����ݿ�
		use  master
		go

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
         
--1) ��ѯjava �γ̱�C#�����ߵ�ѧ��
select stuname ���� , se1.mark c#�ɼ�,se2.mark java�ɼ� from 
	student st join score se1 on st.stuid=se1.stuid and se1.cid=1
		join score se2 on st.stuid=se2.stuid and se2.cid=2
			where se2.stuid=se1.stuid and se1.mark<se2.mark

--2) ��ѯƽ���ֳɼ�����70 �ֵ�ͬѧ��������ƽ���ɼ�
	Select st.StuId ѧ�����,st.stuname ѧ������,Avg(Mark) as ƽ���� From student st
      left join  Score s on s.stuid=st.stuid
		Group By st.StuId,stuname
			Having Avg(Mark)>70

--3) ��ѯ����ͬѧ��ѧ�š�������ѡ�������ܳɼ�

	--4)��ѯ�ա���������ʦ�ĸ���
	select  count(*) as ������ʦ���� from teacher where tname like '��%'
	--5) ��ѯû��ѧ��java �ε�ѧ����ѧ�š�����
	select stuid ,stuname from student where stuid Not in(
	  select  st.stuid  from  student st left join score sc on sc.stuid=st.stuid  
		left join course cs on cs.cid=sc.cid where cname ='java')
	--6) ��ѯѧ����C#���γ̲���Ҳѧ����sql���γ̵�ѧ����ѧ�š�����
      select st.stuname ���� , st.stuid ѧ�� from student st Where 
          (Select Count(*) From score s1 left join
             course cs on cs.cid=s1.cid where  s1.StuId=st.StuId and cs.cname ='C#')>0
			And
			(Select Count(*) From Score s2 left join
              course cs on cs.cid=s2.cid where  s2.StuId=st.StuId and cs.cname ='SQL')>0
     --7) ��ѯ���пγ̵�ƽ���֡�������
       Select �γ�ID=sc.CId,�γ�����=cs.CName,ƽ���ɼ�=Avg(mark)
		,������ =Convert(varchar(10),((Select Count(mark) From Score 
         Where CId=sc.CId And mark>=60)*10000/Count(mark))/100.0)+'%'
		From Score sc
		Inner Join Course cs ON sc.CId=cs.CId
		Where sc.CId like '[123]'
		Group By sc.CId,cs.CName
    --8)��ѯ���пγ̳ɼ�С��60 �ֵ�ͬѧ��ѧ�š��������Ա�
       select stuid,stuname,sex from student st where stuid not in(
        select stuid from score sc where st.stuid=sc.stuid and  mark>60   
        )
    --9)��ѯû��ѧȫ���пε�ͬѧ��ѧ�š��������Ա�
         select stuid,stuname,sex from student st 
           where (Select Count(*) From score s1 left join
             course cs on cs.cid=s1.cid where  s1.StuId=st.StuId )<3
     --10) ��ѯ������һ�ſ���ѧ��Ϊ��002����ͬѧ��ѧ��ͬ��ͬѧ��ѧ�ź�����
     select st.stuid,st.stuname from student st where stuid in(
       select Distinct stuid from score where cid in 
         (select cid from score where stuid='002') and stuid!='002')
     --11����ѯ����ѧ��ѧ��Ϊ��002��ͬѧ���пε�����ͬѧѧ�ź�����
       select cname from course cs left join score sc on sc.cid=cs.cid 
           left join student st on st.stuid=sc.stuid where st.stuid='002'

     --12)�ѳɼ����С��Žܡ���ʦ�̵Ŀεĳɼ�������Ϊ�˿γ̵�ƽ���ɼ�
    --�������Ա�	
      update score set mark=(select avg(mark) from score) where cid in (select sc.cid from score sc 
       left join course cs on sc .cid=cs.cid 
          left join teacher tc on tc.tid=cs.teacherid where tc.tname='�Ž�')
    --13) ��ѯ�͡�002���ŵ�ͬѧѧϰ�Ŀγ���ȫ��ͬ������ͬѧѧ�ź�����
   --14) ɾ��ѧϰ���Žܡ���ʦ�εĳɼ����¼
       delete score where cid in (select sc.cid from score sc 
       left join course cs on sc .cid=cs.cid 
          left join teacher tc on tc.tid=cs.teacherid where tc.tname='�Ž�')
--15) ��ƽ���ɼ��Ӹߵ�����ʾ����ѧ���ġ�sql������java������c#�����ŵĿγ̳ɼ�����������ʽ��ʾ��ѧ��ID,sql,java,c#,��Ч�γ���,��Чƽ����
        select stuid,(select mark from score sc inner join course cs on 
		sc.cid=cs.cid  where  sc.StuID=st.StuId And cname='sql') as ���ݿ�,
		(select mark from score sc inner join course cs on 
		sc.cid=cs.cid  where  sc.StuID=st.StuId And cname='java')as java,
		(select mark from score sc inner join course cs on 
		sc.cid=cs.cid  where  sc.StuID=st.StuId And cname='C#' ) as C#,
		(select count(mark) from score sc inner join course cs on
		cs.cid=sc.cid where cname in('SQL','Java','C#') and sc.stuid=st.stuid) as ��Ч�γ���,
        (select avg(mark) from score sc inner join course cs on
		cs.cid=sc.cid where cname in('SQL','Java','C#') and sc.stuid=st.stuid) as ��Чƽ����
        from score st group by st.stuid
          order by ��Чƽ���� desc
 

       SELECT stuid as ѧ��ID         ,(SELECT mark FROM score WHERE score.stuid=t.stuid AND cid=3) AS 'sql'        ,(SELECT mark FROM score WHERE score.stuid=t.stuid AND cid=2) AS 'java'        ,(SELECT mark FROM score WHERE score.stuid=t.stuid AND cid=1) AS 'c#'        ,COUNT(*) AS ��Ч�γ���, AVG(t.mark) AS ƽ���ɼ�    FROM score AS t     GROUP BY stuid     ORDER BY avg(t.mark)  desc
--16) ��ѯ���Ƴɼ���ߺ���͵ķ֣���������ʽ��ʾ���γ�ID����߷֣���ͷ�
        select cid �γ̱��,cname �γ�����,��߷�=(select max(mark) from score  sc where sc.cid=cs.cid)
          ,��ͷ�=(select min(mark) from score  sc where sc.cid=cs.cid) 
                from course cs
--17) ��ѯ��ͬ��ʦ���̲�ͬ�γ�ƽ���ִӸߵ�����ʾ
       select cname �γ�����,tname ��ʦ����, ƽ���ɼ�=(select avg(mark) from score 
           sc  where cid=cs.cid ) from course cs  left join
                teacher tc on tc.tid=cs.teacherid   
                  order by ƽ���ɼ� desc
                 
--18) ��ѯ���Ƴɼ�ǰ�����ļ�¼:(�����ǳɼ��������)
       Select ѧ��=StuId,�γ̺�=CId,����=mark
		From 
		(Select Row_Number() Over(order by CId,mark Desc) as i,* From Score) as tmp	--�õ�һ����ʱ��������,����i��ʾ���
			Where i In 
			(
				Select Top 3 i From (Select Row_Number() Over(order by CId,mark Desc) as i,* From Score) as t1 Where t1.CId=tmp.CId
			)
--19) ��ѯÿ�ſγ̱�ѡ�޵�ѧ����
      select cs.cname ,count(stuid) ѧ���� from score sc  left join course cs on
         cs.cid=sc.cid  group by cs.cname
--20) ��ѯ��ֻѡ����һ�ſγ̵�ȫ��ѧ����ѧ�ź�����
    select st.stuid,st.stuname from student st left join 
      score sc on sc.stuid=st.stuid  where (Select Count(*) From score s1 left join
             course cs on cs.cid=s1.cid where  s1.StuId=st.StuId )=1
--21) ��ѯ������Ů������
select  ��������=(select count(*) from student where sex='��'),
Ů������=(select count(*) from student where sex='Ů')
--22) ��ѯ�ա��š���ѧ������
select *  from student where stuname like '��%'
--23) ��ѯͬ��ͬ��ѧ����������ͳ��ͬ������
     select  Distinct stuname,ͬ������=(Select Count(*) From Student s2 Where s2.StuName=st.StuName) 
       from student st where 
     (Select Count(*) From Student s2 Where s2.StuName=st.StuName)>=2
--24) ��ѯÿ�ſγ̵�ƽ���ɼ��������ƽ���ɼ��������У�ƽ���ɼ���ͬʱ�����γ̺Ž�������
select sc.cid �γ̱��,cs.cname as�γ�����,avg(mark)as ƽ���� from
   score sc left join course cs on cs.cid=sc.cid 
       group by sc.cid,cs.cname
      order by avg(mark) asc,sc.cid
--25) ��ѯƽ���ɼ�����70������ѧ����ѧ�š�������ƽ���ɼ�
       select st.stuid as ѧ��,st.stuname as ����,avg(mark) as ƽ����
          from student st left join score sc on sc.stuid=st.stuid 
               group by st.stuid,st.stuname
                    having avg(mark)>70
--26) ��������ѡ�����ſγ̵�ѧ��ѧ��
      select  Distinct stuid as ѧ�� from score sc where
        (select count(*) from score s1 where
           s1.stuid =sc.stuid and cid like '[123]')>=2 
--27) ��ѯ�������ϲ�����γ̵�ͬѧ��ѧ�ż���ƽ���ɼ�
		Select StuID as ѧ��,Avg(mark) as ƽ���ɼ� From Score sc
			Where (Select Count(*) From Score s1 Where s1.StuId=sc.StuId And mark<60)>=2
			  Group By StuId
--28) ������java���γ̷���С��60���������������е�ͬѧ����
		Select st.StuID,st.stuname,sc.mark From student st  left join 
		   Score sc on st.stuid=sc.stuid
		      left join course cs on cs.cid=sc.cid
		          Where cname='java' And mark<60 Order by mark Desc
--29) ɾ����002��ͬѧ��1�γ̵ĳɼ�
    delete score where stuid='002' and cid=1
--30) ��ѯ������Ŀγ̣������γ̺ŴӴ�С����
  select cs.cname,sc.mark ,sc.cid from score sc left join 
      course cs on cs.cid=sc.cid where mark<60 order by cid