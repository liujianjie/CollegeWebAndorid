use 语句来创建的数据库
/*create table rbl(
	rbl_my int primary key not null,
	rbl_dy varchar(20) not null unique,
	rbl_cy int identity(1,1) not null, 
	rbl_by int not null
)创建表*/
alter table rbl drop column rbl_by--删除列
--alter table rbl alter column rbl_by char(2)--修改