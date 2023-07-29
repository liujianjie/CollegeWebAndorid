use T1

--compute子句 与聚合函数一起使用
select * from main  compute sum(工时) 
--学生表
create table student(
	stu_no int primary key identity(1,1) not null,
	stu_name varchar(20),
	stu_sex char(2),
	stu_age tinyint
)  

create table couser(
	cou_no int primary key identity(1,1) not null,
	cou_name varchar(20)
)

create table score(
	sco_id int primary key identity(1,1) not null,
	stu_no int foreign key references student(stu_no),
	cou_no int foreign key references couser(cou_no),
	score float
)
insert into student values('张三','男',17)
insert into student values('李思思','女',20)
insert into student values('张曼曼','女',17)
insert into student values('吴昊','男',19)
insert into student values('刘浩','男',16)

insert into couser values('JAVA')
insert into couser values('C语言')
insert into couser values('HTML')
insert into couser values('SQL')

insert into score values(1,1,66.6)
insert into score values(1,2,77)
insert into score values(1,3,56)
insert into score values(1,4,65)

insert into score values(2,1,65)
insert into score values(2,2,77)
insert into score values(2,3,86)
insert into score values(2,4,98)

insert into score values(3,1,78)
insert into score values(3,2,67)
insert into score values(3,3,65)
insert into score values(3,4,45)

insert into score values(4,1,64)
insert into score values(4,2,76)
insert into score values(4,3,75)
insert into score values(4,4,34)

--子查询 查询有学过java课程的学生信息
select * from student where stu_no in
	(select stu_no from score where cou_no in
		(select cou_no from couser where cou_name='C语言'))

--子查询 查询没有学过java课程的学生信息
select * from student where stu_no not in
	(select stu_no from score where cou_no in
		(select cou_no from couser where cou_name='C语言'))

--子查询第二种情况，当成单独一列
--查询学号，姓名，总分
select st.stu_no,st.stu_name,
	(select sum(score) from score sc where sc.stu_no=st.stu_no) 总分 from student st

--删除没有学过java并且年纪大于19岁


select * from student
-- 连接：内连接(inner join )   外连接：左连接，右连接，交叉连接，全连接
--查询java成绩比C语言成绩要高的同学信息
select * ,s1.score C语言,s2.score JAVA from student st
	inner join score s1 on st.stu_no=s1.stu_no and s1.cou_no in(select cou_no from couser where cou_name='JAVA')
		inner join score s2 on st.stu_no=s2.stu_no and s2.cou_no in(select cou_no from couser where cou_name='C语言')
			 where s1.stu_no=s2.stu_no and s1.score<s2.score

--外链接
--左
select * from student st left join score sc on st.stu_no=sc.stu_no 

--右
select * from student st right join score sc on st.stu_no=sc.stu_no 

--全
select * from student st full join score sc on st.stu_no=sc.stu_no 

--交叉(卡迪尔积)
select * from student st cross join score sc where st.stu_no=sc.stu_no 

--联合
select * into bscore from score

delete from bscore

insert into bscore values(2,1,34)
insert into bscore values(2,2,45)
insert into bscore values(2,3,23)
insert into bscore values(2,4,67)

select * from score 
union
select * from bscore order by stu_no