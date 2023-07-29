use 语句来创建的数据库
create table student(
	stu_no int identity(1,1) not null,--自动增长
	stu_name varchar(20) not null,--名字
	stu_sex char(2) check(stu_sex='男' or stu_sex='女') default '男' not null,--域约束
	stu_age int check(stu_age>0 and stu_age<100) not null,--域约束
	stu_num varchar(11) not null unique --唯一约束
)

