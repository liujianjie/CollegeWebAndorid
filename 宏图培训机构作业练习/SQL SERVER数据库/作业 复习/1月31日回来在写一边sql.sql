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
		select st.stuid,stuname from student st 
			inner join score sc1 on sc1.stuid=st.stuid and sc1.cid=(select cid from course where cname='JAVA')
			inner join score sc2 on sc2.stuid=st.stuid and sc2.cid=(select cid from course where cname='c#')
			where sc1.mark>sc2.mark and sc1.stuid=sc2.stuid

	--2) 查询平均分成绩大于70 分的同学的姓名和平均成绩
		select stuname,avg(sc.mark)平均分 from student st left join score sc on st.stuid=sc.stuid group by st.stuname having avg(sc.mark)>70

	--3) 查询所有同学的学号、姓名、选课数、总成绩
		--分组查询不行啊 查不出姓名
		select sc.stuid,count(sc.stuid)选课数,sum(mark)总成绩 from student st 
			inner join score sc on sc.stuid=st.stuid group by sc.stuid

		--只能子查询了
		select st.stuid,st.stuname,
			(select count(sc.stuid) from score sc where sc.stuid=st.stuid)选课数,
				(select sum(mark) from score sc where sc.stuid=st.stuid)总成绩
				from student st

	--4)	查询姓“王”的老师的个数
		select count(tname)个数 from teacher where tname like '王%'

	--5)	查询没有学过 java 课的学生的学号、姓名
		select stuid,stuname from student where stuid not in
			(select stuid from score sc where cid=(select cid from course where cname='html'))

	--6)	查询学过“C#”课程并且也学过“sql”课程的学生的学号、姓名
		select stuid,stuname from student where stuid in
			(select stuid from score sc where cid=(select cid from course where cname='C#')) and
				stuid in (select stuid from score sc where cid=(select cid from course where cname='sql'))

	--7)	查询所有课程的平均分、及格率
		select (select cname from course cs where cs.cid=sc.cid)课程,avg(mark)平均分
					from score sc group by cid--错了
	
	--8)	查询所有课程成绩小于 60 分的同学的学号、姓名、性别
		select stuid,stuname,sex from student st where stuid in
			(select stuid from score sc where sc.stuid=st.stuid and mark<60)


	--9)	查询没有学全所有课的同学的学号、姓名、性别
		select stuid,stuname from student where stuid not in
			(select stuid from score sc where cid=(select cid from course where cname='C#')) and
				stuid in (select stuid from score sc where cid=(select cid from course where cname='sql')) and
				stuid in (select stuid from score sc where cid=(select cid from course where cname='java'))

     --10) 查询至少有一门课与学号为“002”的同学所学相同的同学的学号和姓名
		select stuid,stuname from student where stuid in	
			(select stuid from score where cid in
				(select cid from score where stuid='002'))and stuid!='002'

    --11）查询至少学过学号为“002”同学所有课的其他同学学号和姓名



	--12)把成绩表中“张杰”老师教的课的成绩都更改为此课程的平均成绩
		update score set mark=(select avg(mark) from score where cid=(select cid from course where teacherid='3' group by cid))
		where cid=3


	--13) 查询和“002”号的同学学习的课程完全相同的其他同学学号和姓名	
		select

	--14) 删除学习“张杰”老师课的成绩表记录
		delete from score where cid=(select cid from course where teacherid=(select tid from teacher where tname='张杰'))


	--15) 按平均成绩从高到低显示所有学生的“sql”、“java”、“c#”三门的课程成绩，按如下形式显示：学生ID,sql,java,c#,有效课程数,有效平均分



	--16) 查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
		select cid,max(mark)最高分,min(mark)最低分 from score group by cid
		

	--17) 查询不同老师所教不同课程平均分从高到低显示
		select (select cname from course where),avg(mark) from score sc inner join course cs on cs.cid=sc.cid group by sc.cid


	--18) 查询各科成绩前三名的记录:(不考虑成绩并列情况)


	--19) 查询每门课程被选修的学生数
		

	--20) 查询出只选修了一门课程的全部学生的学号和姓	
		select * from score


	--21) 查询男生、女生人数
		select count(sex)男生人数,(select count(sex) from student where sex='女') 女生人数 from student where sex='男'


	--22) 查询姓“张”的学生名单
		select * from student where stuname like '张%'
	

	--23) 查询同名同性学生名单，并统计同名人数
		
	

	--24) 查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列



	--25) 查询平均成绩大于70的所有学生的学号、姓名和平均成绩



	--26) 检索至少选修两门课程的学生学号



	--27) 查询两门以上不及格课程的同学的学号及其平均成绩



	--28) 检索“java”课程分数小于60，按分数降序排列的同学姓名
		select stuname,sc.mark from student st inner join score sc on sc.stuid=st.stuid
			and cid=(select cid from course where cname='JAVA') and sc.mark<60 order by mark desc


	--29) 删除“002”同学的1课程的成绩
		delete from score where cid=1 and stuid='002'

	--30) 查询不及格的课程，并按课程号从大到小排列
		select cname,mark from course cs inner join score sc on sc.cid=cs.cid where mark<60 order by sc.cid