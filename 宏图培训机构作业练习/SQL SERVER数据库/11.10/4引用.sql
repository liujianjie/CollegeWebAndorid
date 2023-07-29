use 还原的数据库
create table score2(
	stu_name varchar(20) foreign key references student(stu_name),--引用学生名字 但要填写
	score int check(score>=0 and score<=100) not null --分数限制
)
