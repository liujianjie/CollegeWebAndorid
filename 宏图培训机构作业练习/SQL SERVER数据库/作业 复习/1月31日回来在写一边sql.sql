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
		select st.stuid,stuname from student st 
			inner join score sc1 on sc1.stuid=st.stuid and sc1.cid=(select cid from course where cname='JAVA')
			inner join score sc2 on sc2.stuid=st.stuid and sc2.cid=(select cid from course where cname='c#')
			where sc1.mark>sc2.mark and sc1.stuid=sc2.stuid

	--2) ��ѯƽ���ֳɼ�����70 �ֵ�ͬѧ��������ƽ���ɼ�
		select stuname,avg(sc.mark)ƽ���� from student st left join score sc on st.stuid=sc.stuid group by st.stuname having avg(sc.mark)>70

	--3) ��ѯ����ͬѧ��ѧ�š�������ѡ�������ܳɼ�
		--�����ѯ���а� �鲻������
		select sc.stuid,count(sc.stuid)ѡ����,sum(mark)�ܳɼ� from student st 
			inner join score sc on sc.stuid=st.stuid group by sc.stuid

		--ֻ���Ӳ�ѯ��
		select st.stuid,st.stuname,
			(select count(sc.stuid) from score sc where sc.stuid=st.stuid)ѡ����,
				(select sum(mark) from score sc where sc.stuid=st.stuid)�ܳɼ�
				from student st

	--4)	��ѯ�ա���������ʦ�ĸ���
		select count(tname)���� from teacher where tname like '��%'

	--5)	��ѯû��ѧ�� java �ε�ѧ����ѧ�š�����
		select stuid,stuname from student where stuid not in
			(select stuid from score sc where cid=(select cid from course where cname='html'))

	--6)	��ѯѧ����C#���γ̲���Ҳѧ����sql���γ̵�ѧ����ѧ�š�����
		select stuid,stuname from student where stuid in
			(select stuid from score sc where cid=(select cid from course where cname='C#')) and
				stuid in (select stuid from score sc where cid=(select cid from course where cname='sql'))

	--7)	��ѯ���пγ̵�ƽ���֡�������
		select (select cname from course cs where cs.cid=sc.cid)�γ�,avg(mark)ƽ����
					from score sc group by cid--����
	
	--8)	��ѯ���пγ̳ɼ�С�� 60 �ֵ�ͬѧ��ѧ�š��������Ա�
		select stuid,stuname,sex from student st where stuid in
			(select stuid from score sc where sc.stuid=st.stuid and mark<60)


	--9)	��ѯû��ѧȫ���пε�ͬѧ��ѧ�š��������Ա�
		select stuid,stuname from student where stuid not in
			(select stuid from score sc where cid=(select cid from course where cname='C#')) and
				stuid in (select stuid from score sc where cid=(select cid from course where cname='sql')) and
				stuid in (select stuid from score sc where cid=(select cid from course where cname='java'))

     --10) ��ѯ������һ�ſ���ѧ��Ϊ��002����ͬѧ��ѧ��ͬ��ͬѧ��ѧ�ź�����
		select stuid,stuname from student where stuid in	
			(select stuid from score where cid in
				(select cid from score where stuid='002'))and stuid!='002'

    --11����ѯ����ѧ��ѧ��Ϊ��002��ͬѧ���пε�����ͬѧѧ�ź�����



	--12)�ѳɼ����С��Žܡ���ʦ�̵Ŀεĳɼ�������Ϊ�˿γ̵�ƽ���ɼ�
		update score set mark=(select avg(mark) from score where cid=(select cid from course where teacherid='3' group by cid))
		where cid=3


	--13) ��ѯ�͡�002���ŵ�ͬѧѧϰ�Ŀγ���ȫ��ͬ������ͬѧѧ�ź�����	
		select

	--14) ɾ��ѧϰ���Žܡ���ʦ�εĳɼ����¼
		delete from score where cid=(select cid from course where teacherid=(select tid from teacher where tname='�Ž�'))


	--15) ��ƽ���ɼ��Ӹߵ�����ʾ����ѧ���ġ�sql������java������c#�����ŵĿγ̳ɼ�����������ʽ��ʾ��ѧ��ID,sql,java,c#,��Ч�γ���,��Чƽ����



	--16) ��ѯ���Ƴɼ���ߺ���͵ķ֣���������ʽ��ʾ���γ�ID����߷֣���ͷ�
		select cid,max(mark)��߷�,min(mark)��ͷ� from score group by cid
		

	--17) ��ѯ��ͬ��ʦ���̲�ͬ�γ�ƽ���ִӸߵ�����ʾ
		select (select cname from course where),avg(mark) from score sc inner join course cs on cs.cid=sc.cid group by sc.cid


	--18) ��ѯ���Ƴɼ�ǰ�����ļ�¼:(�����ǳɼ��������)


	--19) ��ѯÿ�ſγ̱�ѡ�޵�ѧ����
		

	--20) ��ѯ��ֻѡ����һ�ſγ̵�ȫ��ѧ����ѧ�ź���	
		select * from score


	--21) ��ѯ������Ů������
		select count(sex)��������,(select count(sex) from student where sex='Ů') Ů������ from student where sex='��'


	--22) ��ѯ�ա��š���ѧ������
		select * from student where stuname like '��%'
	

	--23) ��ѯͬ��ͬ��ѧ����������ͳ��ͬ������
		
	

	--24) ��ѯÿ�ſγ̵�ƽ���ɼ��������ƽ���ɼ��������У�ƽ���ɼ���ͬʱ�����γ̺Ž�������



	--25) ��ѯƽ���ɼ�����70������ѧ����ѧ�š�������ƽ���ɼ�



	--26) ��������ѡ�����ſγ̵�ѧ��ѧ��



	--27) ��ѯ�������ϲ�����γ̵�ͬѧ��ѧ�ż���ƽ���ɼ�



	--28) ������java���γ̷���С��60���������������е�ͬѧ����
		select stuname,sc.mark from student st inner join score sc on sc.stuid=st.stuid
			and cid=(select cid from course where cname='JAVA') and sc.mark<60 order by mark desc


	--29) ɾ����002��ͬѧ��1�γ̵ĳɼ�
		delete from score where cid=1 and stuid='002'

	--30) ��ѯ������Ŀγ̣������γ̺ŴӴ�С����
		select cname,mark from course cs inner join score sc on sc.cid=cs.cid where mark<60 order by sc.cid