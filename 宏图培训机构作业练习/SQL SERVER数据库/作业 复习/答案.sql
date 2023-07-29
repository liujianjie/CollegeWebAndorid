		--切换数据库
		use  master
		go

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
         
--1) 查询java 课程比C#分数高的学生
select stuname 姓名 , se1.mark c#成绩,se2.mark java成绩 from 
	student st join score se1 on st.stuid=se1.stuid and se1.cid=1
		join score se2 on st.stuid=se2.stuid and se2.cid=2
			where se2.stuid=se1.stuid and se1.mark<se2.mark

--2) 查询平均分成绩大于70 分的同学的姓名和平均成绩
	Select st.StuId 学生编号,st.stuname 学生姓名,Avg(Mark) as 平均分 From student st
      left join  Score s on s.stuid=st.stuid
		Group By st.StuId,stuname
			Having Avg(Mark)>70

--3) 查询所有同学的学号、姓名、选课数、总成绩

	--4)查询姓“王”的老师的个数
	select  count(*) as 王姓老师个数 from teacher where tname like '王%'
	--5) 查询没有学过java 课的学生的学号、姓名
	select stuid ,stuname from student where stuid Not in(
	  select  st.stuid  from  student st left join score sc on sc.stuid=st.stuid  
		left join course cs on cs.cid=sc.cid where cname ='java')
	--6) 查询学过“C#”课程并且也学过“sql”课程的学生的学号、姓名
      select st.stuname 姓名 , st.stuid 学号 from student st Where 
          (Select Count(*) From score s1 left join
             course cs on cs.cid=s1.cid where  s1.StuId=st.StuId and cs.cname ='C#')>0
			And
			(Select Count(*) From Score s2 left join
              course cs on cs.cid=s2.cid where  s2.StuId=st.StuId and cs.cname ='SQL')>0
     --7) 查询所有课程的平均分、及格率
       Select 课程ID=sc.CId,课程名称=cs.CName,平均成绩=Avg(mark)
		,及格率 =Convert(varchar(10),((Select Count(mark) From Score 
         Where CId=sc.CId And mark>=60)*10000/Count(mark))/100.0)+'%'
		From Score sc
		Inner Join Course cs ON sc.CId=cs.CId
		Where sc.CId like '[123]'
		Group By sc.CId,cs.CName
    --8)查询所有课程成绩小于60 分的同学的学号、姓名、性别
       select stuid,stuname,sex from student st where stuid not in(
        select stuid from score sc where st.stuid=sc.stuid and  mark>60   
        )
    --9)查询没有学全所有课的同学的学号、姓名、性别
         select stuid,stuname,sex from student st 
           where (Select Count(*) From score s1 left join
             course cs on cs.cid=s1.cid where  s1.StuId=st.StuId )<3
     --10) 查询至少有一门课与学号为“002”的同学所学相同的同学的学号和姓名
     select st.stuid,st.stuname from student st where stuid in(
       select Distinct stuid from score where cid in 
         (select cid from score where stuid='002') and stuid!='002')
     --11）查询至少学过学号为“002”同学所有课的其他同学学号和姓名
       select cname from course cs left join score sc on sc.cid=cs.cid 
           left join student st on st.stuid=sc.stuid where st.stuid='002'

     --12)把成绩表中“张杰”老师教的课的成绩都更改为此课程的平均成绩
    --创建测试表	
      update score set mark=(select avg(mark) from score) where cid in (select sc.cid from score sc 
       left join course cs on sc .cid=cs.cid 
          left join teacher tc on tc.tid=cs.teacherid where tc.tname='张杰')
    --13) 查询和“002”号的同学学习的课程完全相同的其他同学学号和姓名
   --14) 删除学习“张杰”老师课的成绩表记录
       delete score where cid in (select sc.cid from score sc 
       left join course cs on sc .cid=cs.cid 
          left join teacher tc on tc.tid=cs.teacherid where tc.tname='张杰')
--15) 按平均成绩从高到低显示所有学生的“sql”、“java”、“c#”三门的课程成绩，按如下形式显示：学生ID,sql,java,c#,有效课程数,有效平均分
        select stuid,(select mark from score sc inner join course cs on 
		sc.cid=cs.cid  where  sc.StuID=st.StuId And cname='sql') as 数据库,
		(select mark from score sc inner join course cs on 
		sc.cid=cs.cid  where  sc.StuID=st.StuId And cname='java')as java,
		(select mark from score sc inner join course cs on 
		sc.cid=cs.cid  where  sc.StuID=st.StuId And cname='C#' ) as C#,
		(select count(mark) from score sc inner join course cs on
		cs.cid=sc.cid where cname in('SQL','Java','C#') and sc.stuid=st.stuid) as 有效课程数,
        (select avg(mark) from score sc inner join course cs on
		cs.cid=sc.cid where cname in('SQL','Java','C#') and sc.stuid=st.stuid) as 有效平均分
        from score st group by st.stuid
          order by 有效平均分 desc
 

       SELECT stuid as 学生ID         ,(SELECT mark FROM score WHERE score.stuid=t.stuid AND cid=3) AS 'sql'        ,(SELECT mark FROM score WHERE score.stuid=t.stuid AND cid=2) AS 'java'        ,(SELECT mark FROM score WHERE score.stuid=t.stuid AND cid=1) AS 'c#'        ,COUNT(*) AS 有效课程数, AVG(t.mark) AS 平均成绩    FROM score AS t     GROUP BY stuid     ORDER BY avg(t.mark)  desc
--16) 查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
        select cid 课程编号,cname 课程名称,最高分=(select max(mark) from score  sc where sc.cid=cs.cid)
          ,最低分=(select min(mark) from score  sc where sc.cid=cs.cid) 
                from course cs
--17) 查询不同老师所教不同课程平均分从高到低显示
       select cname 课程名称,tname 教师姓名, 平均成绩=(select avg(mark) from score 
           sc  where cid=cs.cid ) from course cs  left join
                teacher tc on tc.tid=cs.teacherid   
                  order by 平均成绩 desc
                 
--18) 查询各科成绩前三名的记录:(不考虑成绩并列情况)
       Select 学号=StuId,课程号=CId,分数=mark
		From 
		(Select Row_Number() Over(order by CId,mark Desc) as i,* From Score) as tmp	--得到一个临时的排名表,其中i表示编号
			Where i In 
			(
				Select Top 3 i From (Select Row_Number() Over(order by CId,mark Desc) as i,* From Score) as t1 Where t1.CId=tmp.CId
			)
--19) 查询每门课程被选修的学生数
      select cs.cname ,count(stuid) 学生数 from score sc  left join course cs on
         cs.cid=sc.cid  group by cs.cname
--20) 查询出只选修了一门课程的全部学生的学号和姓名
    select st.stuid,st.stuname from student st left join 
      score sc on sc.stuid=st.stuid  where (Select Count(*) From score s1 left join
             course cs on cs.cid=s1.cid where  s1.StuId=st.StuId )=1
--21) 查询男生、女生人数
select  男生人数=(select count(*) from student where sex='男'),
女生人数=(select count(*) from student where sex='女')
--22) 查询姓“张”的学生名单
select *  from student where stuname like '张%'
--23) 查询同名同性学生名单，并统计同名人数
     select  Distinct stuname,同名人数=(Select Count(*) From Student s2 Where s2.StuName=st.StuName) 
       from student st where 
     (Select Count(*) From Student s2 Where s2.StuName=st.StuName)>=2
--24) 查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列
select sc.cid 课程编号,cs.cname as课程名称,avg(mark)as 平均分 from
   score sc left join course cs on cs.cid=sc.cid 
       group by sc.cid,cs.cname
      order by avg(mark) asc,sc.cid
--25) 查询平均成绩大于70的所有学生的学号、姓名和平均成绩
       select st.stuid as 学号,st.stuname as 姓名,avg(mark) as 平均分
          from student st left join score sc on sc.stuid=st.stuid 
               group by st.stuid,st.stuname
                    having avg(mark)>70
--26) 检索至少选修两门课程的学生学号
      select  Distinct stuid as 学号 from score sc where
        (select count(*) from score s1 where
           s1.stuid =sc.stuid and cid like '[123]')>=2 
--27) 查询两门以上不及格课程的同学的学号及其平均成绩
		Select StuID as 学号,Avg(mark) as 平均成绩 From Score sc
			Where (Select Count(*) From Score s1 Where s1.StuId=sc.StuId And mark<60)>=2
			  Group By StuId
--28) 检索“java”课程分数小于60，按分数降序排列的同学姓名
		Select st.StuID,st.stuname,sc.mark From student st  left join 
		   Score sc on st.stuid=sc.stuid
		      left join course cs on cs.cid=sc.cid
		          Where cname='java' And mark<60 Order by mark Desc
--29) 删除“002”同学的1课程的成绩
    delete score where stuid='002' and cid=1
--30) 查询不及格的课程，并按课程号从大到小排列
  select cs.cname,sc.mark ,sc.cid from score sc left join 
      course cs on cs.cid=sc.cid where mark<60 order by cid