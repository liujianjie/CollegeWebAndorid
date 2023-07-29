

		--创建数据库
		if exists (select*from sysdatabases where name='studydb')
			drop database studydb

		go
		create database studydb
		on(
			name='studydb_mdf',--主数据的逻辑名
			filename='E:\ch01\studydb_mdf.mdf',--主文件的物理名
			size=5,--主文件的初始大小
			maxsize=10,--主文件的最大储存空间
			filegrowth=2--主文件的增长量
		),
		(
			name='studydb_ndf',--次数据的逻辑名
			filename='E:\ch01\studydb_ndf.ndf',--次文件的物理名
			size=1,--次文件的初始大小
			maxsize=10,--次文件的最大储存空间
			filegrowth=2--次文件的增长量
		)
		log on(
			name='studydb_log',--日志文件的逻辑名
			filename='E:\ch01\studydb.ldf',--日志文件的物理名
			size=1,--日志文件的初始大小
			maxsize=10,--日志文件的最大储存空间
			filegrowth=2--日志文件的增长量
		)
		go
		use studydb
		go


		--建表
		--学生信息表
		create  table student(
			stuid varchar(20) primary key ,--学生编号
			stuname varchar(10) not null,--学生姓名
			age int ,
			sex char(2) not null,
			address varchar(200)
		)
		--课程表
		create table course(
			cid int primary key identity ,
			cname varchar(20) not null,
			teacherid int not null
		)
		--分数表
		create table score(
			sid int primary key identity,
			cid int not null,
			stuid varchar(20) not null,
			mark float not null
		)
		--教师表
		create table teacher(
			tid int primary key identity,
			tname varchar(20)
		)


		--约束
		--为 student中sex添加检查约束,性别必须是男或女
		alter table student add constraint ck_sex check(sex='男' or sex='女')
		--为 course中的cname添加唯一约束
		alter table course add constraint UQ_cname unique(cname)
		--为 course中的teacherid添加外键约束
		alter table course add constraint FK_teacherid foreign key(teacherid) references teacher(tid)
		--为 score中的cid添加外键约束
		alter table score add constraint FK_cids foreign key(cid) references course(cid)
		--为 score中的stuid添加外键约束
		alter table score add constraint FK_stuid foreign key(stuid) references student(stuid)

		--插入数据
		select*from student
		insert into student values('001','张三',18,'男','江西省赣州市')
		insert into student values('002','王五',17,'男','江西省赣州市')
		insert into student values('003','李四',18,'女','江西省赣州市')
		insert into student values('004','赵柳',17,'女','江西省赣州市')
		insert into student values('005','赵柳',18,'女','天上人间')
		insert into student values('006','张金英',38,'男','阴曹地府')

        insert into  teacher values('刘德华')
		insert into  teacher values('周杰伦')
		insert into  teacher values('张杰')
		insert into  teacher values('汪涵')
		insert into  teacher values('何炅')
		insert into  teacher values('刘若英')
		insert into  teacher values('王五')
		insert into  teacher  values('李庆')
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
		--1、查询 java 课程比 C#分数高的学生
		select * from score 
		select * from course
		--select * from student st where stuid in(  )
		select st.stuid,cname,mark from student st,course c,score s where st.stuid=s.stuid and s.cid=c.cid
		--C#的分数
		select stuid, mark from score s  where s.cid in (select cid from course where cname='C#')	
		--JAVA 的分数	
		select stuid, mark from score s  where s.cid in (select cid from course where cname='JAVA')
	
		select * from student st where stuid in(select stuid from score 
		where (select  mark from score s  where s.cid in (select cid from course where cname='JAVA')and  st.stuid=s.stuid)>
		(select  mark from score s  where s.cid in (select cid from course where cname='C#' and  st.stuid=s.stuid )))


		--2)查询平均分成绩大于 70 分的同学的姓名和平均成绩
		select stuname,avg(mark) 平均分 from student st,score s where st.stuid=s.stuid group by stuname
		 having avg(mark) >70  order by 平均分 desc 

		--3)查询所有同学的学号、姓名、选课数、总成绩
		select st.stuid,stuname,count(*) 选课数 ,sum(mark) 总分 from student st,score s where st.stuid=s.stuid  group by st.stuid,stuname
		
		--4)查询姓“王”的老师的个数
		select count(*) 王姓老师个数 from teacher where tname like '王%'		

		--5)查询没有学过 java 课的学生的学号、姓名
		select * from score 
		select * from course 
		select stuid,stuname from student where stuid not in(select stuid from score where cid=(select cid from course where cname='JAVA'))
		--6)查询学过“C#”课程并且也学过“sql”课程的学生的学号、姓名  
		select stuid,stuname from student where stuid in
		(select stuid from score where cid=(select cid from course where cname='C#')) and 
		stuid in(select stuid from score where cid=(select cid from course where cname='SQL')) 

		--7)查询所有课程的平均分、及格率(及格人数/总人数)
		select cname,avg(mark),(select count(*) from score  where mark >60 and cid=s.cid)*1.0/(select count(*) from score where  cid=s.cid)*1.0) 及格率 from score s,course  c where s.cid=c.cid group by cname,s.cid

		--8)查询所有课程都成绩小于60 分的同学的学号、姓名、性别
		
		select * from score order by stuid 	

		select st.stuid,stuname,sex from student st where  stuid not in
		(select stuid from score where stuid=st.stuid and mark >60 )
 
		--9)查询没有学全所有课的同学的学号、姓名、性别
		select stuid,count(*) from score group by stuid 
		select st.stuid,stuname,sex from student st where 
			(select count(*) from score where st.stuid=stuid)<3
		--10)查询至少有一门课与学号为“002”的同学所学相同的同学的学号和姓名
		select cid from score where stuid='002'
		select st.stuid ,stuname from student st where stuid!='002'  and stuid in 
		(select stuid from score where cid = any(select cid from score where stuid='002'))

		--12)把成绩表中“李庆”老师教的课的成绩都更改为此课程的平均成绩

		select tid  from teacher where tname='李庆'

		select * from course where teacherid =	(select tid  from teacher where tname='李庆')

		select avg(mark) from score where cid=(select cid from course where teacherid =(select tid  from teacher where tname='李庆'))
		update score set mark=(select avg(mark) from score where cid=(select cid from course where teacherid =(select tid  from teacher where tname='李庆')))
		where cid=(select cid from course where teacherid =(select tid  from teacher where tname='李庆'))

		select * from score  order by stuid

		--13)查询和“002”号的同学学习的课程完全相同的其他同学学号和姓名
		select cid from score where stuid='002'
		select st.stuid,stuname from student st where stuid in
		(select stuid from score where cid  not in(select cid from score where stuid='002'))


		--14)删除学习“李庆”老师课的成绩表记录
		select * from course where teacherid =	(select tid  from teacher where tname='李庆')		
		delete from score where cid =(select cid from course where teacherid =	(select tid  from teacher where tname='李庆'))
		
		--15)按平均成绩从高到低显示所有学生的“sql”、“java”、“c#”三门的课程 成绩，按如下形式显示：学生 ID,sql,java,c#,有效课程数,有效平均分
			select stuid,stuname ,
			(select mark from score where st.stuid=stuid and cid=(select cid from course where cname='SQL')) 数据库,
			(select mark from score where st.stuid=stuid and cid=(select cid from course where cname='JAVA')) JAVA,
			(select mark from score where st.stuid=stuid and cid=(select cid from course where cname='C#')) C#,
			(select count(mark) from score where st.stuid=stuid)有效课程数,
			(select avg(mark) from score where st.stuid=stuid )有效平均分
		 from student st order by 有效平均分 desc
		--16)查询各科成绩最高和最低的分：以如下形式显示：课程 ID，最高分，最低分
			select cid,max(mark) 最高分,min(mark) 最低分 from score group by cid 
		--