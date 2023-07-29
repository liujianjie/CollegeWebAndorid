use 还原的数据库
create table score(
	score_no  uniqueidentifier primary key DEFAULT NEWID() not null,--主键
	/*stu_name varchar(20) not null foreign key references student(stu_name),--引用学生名字 但要填写*/
	score int check(score>0 and score<=100) not null --分数限制
)