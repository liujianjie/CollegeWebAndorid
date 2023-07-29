create database task
 on primary(
	name=上机作业,
	filename='E:\宏图作业练习\SQL SERVER数据库\1月29日\上机作业.mdf',
	size=3mb,
	maxsize=100mb,
	filegrowth=1mb

)
log on(
	name=上机作业2,
	filename='E:\宏图作业练习\SQL SERVER数据库\1月29日\上机作业.ldf',
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

insert into course values('201','C语言')
insert into course values('202','JAVA')
insert into course values('203','JSP')

alter table student add constraint banjiwaijian foreign key (classno) references classes(classno)
insert into student values('20080101','张三','200801','M',19)
insert into student values('20080102','李四','200801','F',19)
insert into student values('20080201','王五','200802','M',19)

insert into studentcourse values('20080101','201',71)
insert into studentcourse values('20080102','201',80.5)
insert into studentcourse values('20080101','202',65.5)
insert into studentcourse values('20080102','202',56)
insert into studentcourse values('20080101','203',45)

--1.查询同张三在同一个班级的学生（使用子查询实现）
	select * from student where classnO=
		(select classno from student where stuname='张三')

--2.	查询张三的C语言成绩
	select * from studentcourse where stuno=
		(select stuno from student where stuname='张三') and cno=
			(select cno from course where cname='C语言')
--3.	修改张三的C语言成绩为85
	update studentcourse set score=85 where stuno=
		(select stuno from student where stuname='张三') and cno=
			(select cno from course where cname='C语言')
--4.	删除张三的HTML成绩
	delete studentcourse where stuno=
		(select stuno from student where stuname='张三') and cno=
				(select cno from course where cname='JSP')
--5.	查询C语言的最高成绩
	select max(score)分数 from studentcourse where cno=
		(select cno from course where cname='C语言') 

--6.	查询C语言成绩最高的学生的基本信息
	select *from student where stuno in (select stuno from studentcourse where score=
		(select max(score)分数 from studentcourse where cno=
			(select cno from course where cname='C语言')))

							5.	课堂练习
select * from classes
select * from course
select * from student
select * from studentcourse
--5.1.	查询所有学生的姓名、学号及班级名称
	select stuno,stuname,(select classname from classes cs where cs.classno=st.classno) 班级 from student st

--5.2.	查询所有学生各门课程的成绩，列出姓名、班级名、课程名、成绩
	select score,(select stuname from student st where st.stuno=sc.stuno) 姓名,
		(select classname from classes cs where cs.classno=st.classno) 班级,
			(select cname from course ce where sc.cno=ce.cno) 课程名
				 from studentcourse sc,student st,classes cs,course ce
					 where st.stuno=sc.stuno and cs.classno=st.classno and ce.cno=sc.cno

--5.3.	分别使用子查询和连接查询实现：查询ST0801班的C语言平均成绩
	select avg(score) 平均成绩 from studentcourse where cno=(select cno from course where cname='C语言')
		and stuno IN(select stuno from student where classno=(select classno from classes where classname='ST0801'))

--5.4.	查询所有C语言成绩比其所在班级平均成绩高的学生
	select * from studentcourse where cno=(select cno from course where cname='C语言') and score>(	select avg(score) 平均成绩 from studentcourse where cno=(select cno from course where cname='C语言')
		and stuno IN(select stuno from student where classno=(select classno from classes where classname='ST0801')))

--5.5.	查找C语言没有成绩的所有学生的信息（使用exists实现）
	select * from student where stuno not in(select stuno from studentcourse where cno not in(select cno from course where cname='C语言'))

--5.6.	使用SQL将ST0801班的所有学生的信息插入到一个新表StudentST0801中
	select * into studentst0801 from classes where classname='st0801'

--5.7.	查询在Student表中存在，但在StudentST0801表中不存在的学生
	select * from student where classno not in(select classno from studentst0801)
	
--5.8.	删除Student200801班的所有学生
	delete from student where classno not in(select classno from studentst0801)

--5.9.	查询Classes表和StudentST0801表的所有学生合到一个结果集中
	select * from student where classno in(select classno from studentst0801)
	union
	select * from student where classno in(select classno from classes)
--6.1.	用一条SQL语句 查询出每门课都大于80分的学生姓名 
	select stuname from student where stuno  in(select stuno from studentcourse group by stuno having min(score)>80)

--6.2.	查询出所有同名的学生，列出姓名、班级
	select classno,stuname from student where stuname (select stuname from student group by stuname having count(stuname)>1)in

--6.3.	假设每个学生每门课程都应该有成绩，查询出没有成绩的学生及其课程，列出姓名、班级名、课程、成绩 
	select stuname,cname,0 from student a cross join course b  where  not exists (--存在
	select stuname,cname from student s 
	inner join studentcourse s1 on s.stuno=s1.stuno --以外键关联的字段作为条件
	inner join course c on c.cno= s1.cno
	where a.stuno=s.stuno and b.cno=c.cno
)
	select stuname,(select classname from classes cs where cs.classno=st.classno)班级,
		(select cname from course cs where cs.cno=stc.cno)课程
			from student st ,studentcourse stc where not exists (
					select stuname,(select classname from classes cs1 where cs1.classno=st1.classno)班级,
					(select cname from course cs1 where cs1.cno=stc1.cno)课程
					from student st1 ,studentcourse stc1 where stc1.stuno=st1.stuno 
					)
					and stc.stuno=st.stuno 

--6.4.	查询得出以下结果：'
	select stuname,age,sex,
	(select score from studentcourse where cno=201 and s.stuno=stuno) C语言,
	(select score from studentcourse where cno=202 and s.stuno=stuno) JAVA,
	(select score from studentcourse where cno=203 and s.stuno=stuno) JSP

	from student s
 