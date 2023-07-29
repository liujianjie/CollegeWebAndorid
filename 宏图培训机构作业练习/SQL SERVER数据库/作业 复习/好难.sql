create database studydb
on primary(
	name=练习,
	filename='E:\宏图作业练习\SQL SERVER数据库\作业 复习\练习.mdf',
	size=3mb,
	maxsize=10mb,
	filegrowth=1mb
)
log on(
	name=练习1,
	filename='E:\宏图作业练习\SQL SERVER数据库\作业 复习\练习1.ldf',
	size=1mb,
	maxsize=10mb,
	filegrowth=1mb

)
--切换
use studydb
--创表
--学生信息表
create table student(
	stuid varchar(32) primary key not null,--学生编号
	stuname varchar(20) not null,--学生姓名
	age int, --年龄
	sex char(2) not null check(sex='男' or sex='女'),--性别
	address varchar(200) --地址
)
--课程表
create table course(
	cid int identity(1,1) primary key not null,--课程编号
	cname varchar(20) not null unique,--课程姓名
	teacherid int not null foreign key references teacher(teacherid)--教师编号
	
)
--成绩表
create table score(
	sid int identity(1,1) primary key not null,--成绩编号
	cid int not null foreign key references course(cid),--课程编号
	stuid varchar(32) not null foreign key references student(stuid),--学生编号
	mark float not null check(mark>0 and mark <100)--分数

)
--教师表
create table teacher(
	teacherid int identity(1,1) primary key not null,--教师编号
	tname varchar(20) not null --教师姓名

)

--建表
		create  table student(
		stuid varchar(20) primary key ,--学生编号
		stuname varchar(10) not null,--学生姓名
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

delete  score 
		--插入数据
		select*from student
		insert into student values('001','张三',18,'男','广东省珠海市')
		insert into student values('002','王五',17,'男','广东省珠海市')
		insert into student values('003','李四',18,'女','广东省珠海市')
		insert into student values('004','赵柳',17,'女','广东省珠海市')
		insert into student values('005','赵柳',18,'女','广东省珠海市')
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
        delete score where cid=1 and stuid='006'

--开始做题目部分 
	--1)	查询 java 课程比 C语言分数高的学生
		select stuname,s1.mark HTML,s2.mark JAVA from student st
			inner join score s1 on st.stuid=s1.stuid and s1.cid=(select cid from course where cname='JAVA')
				inner join score s2 on st.stuid=s2.stuid and s2.cid=(select cid from course where cname='HTML')
					where s1.stuid=s2.stuid and s1.mark<s2.mark
		

	--2)	查询平均分成绩大于 70 分的同学的姓名和平均成绩
		select st.stuname as 姓名,avg(mark)平均分 from student st,score s where st.stuid=s.stuid 
				group by st.stuname having avg(mark)>50--用统计做得有点用
		select st.stuname,
			(select avg(mark) from score where stuid=st.stuid having avg(mark)>55)平均分
			from student st  -- 用子查询做得有点小瑕疵

	--3)	查询所有同学的学号、姓名选课数、总成绩
		select st.stuname,stuid,
			(select sum(mark) from score where stuid=st.stuid)总分,
			(select count(cid) from score where stuid=st.stuid)选课数
			from student st  -- 用子查询做得

	--4)	查询姓“王”的老师的个数
		select * from teacher where tname like '王%'

	--5)	查询没有学过 java 课的学生的学号、姓名
		select st.stuname,st.stuid from student st,score s where st.stuid not In (select stu_no from score where course_no=
			(select course_no from course where course_name='JAVA'))

	--6)	查询学过“C#”课程并且也学过“sql”课程的学生的学号、姓名
		select st.stuname,st.stuid from student st where
			st.stuid in (select stuid from score where cid=(select cid from course where cname='C语言')) 
			and st.stuid in(select stuid from score where cid=(select cid from course where cname='数据库'))

	--7)	查询所有课程的平均分、及格率
		select cname,avg(mark)平均分,((select count(*) from score where mark>60 and cid=c.cid)*1.0 /
			(select count(*) from score where cid=c.cid)*1.0)及格率
			from score s,course c where s.cid=c.cid group by cname,c.cid--错了
	
	--8)	查询所有课程成绩小于 60 分的同学的学号、姓名、性别
		select st.stuid,stuname,sex from student st 
			where stuid not in(select stuid from score where stuid=st.stuid and mark >60) 

	--9)	查询没有学全所有课的同学的学号、姓名、性别
		select stuid,stuname,sex from student where (select count(*) from score where student.stuid=stuid)<3
		select stuid,count(*) from score group by stuid


	--12)	把成绩表中“刘飞”老师教的课的成绩都更改为此课程的平均成绩
		update score set mark=(select avg(mark) from score where cid=(select cid from course where teacherid=(select teacherid from teacher where tname='刘飞')))
		

	--14)	删除学习“李四”老师课的成绩表记录
		select * from course where teacherid=4
		delete from score where cid =(select cid from course where 
			teacherid=(select teacherid from teacher where tname='李四'))

	--16)	查询各科成绩最高和最低的分：以如下形式显示：课程 ID，最高分，最低分
		select c.cid,c.cname,max(mark)最高分,min(mark)最低分
			from course c,score s where c.cid=s.cid group by c.cname,c.cid --分组 真尼玛万精油

	--17)	查询不同老师所教不同课程平均分从高到低显示
		select 
			(select tname from teacher where teacherid in (select teacherid from course where cid in(select cid from score))),
			(select cname from course where cid in (select cid from score)),
			avg(mark)平均分
		from score s group by cid 

		select avg(mark)平均分
			from score s group by cid order by 平均分 desc

	--18)	查询各科成绩前三名的记录:(不考虑成绩并列情况)




	--21)	查询男生、女生人数
		select count(sex)男生人数 from student where sex='男'
		select count(sex)女生人数 from student where sex='女'