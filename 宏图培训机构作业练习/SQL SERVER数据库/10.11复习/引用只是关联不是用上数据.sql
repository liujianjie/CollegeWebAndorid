--引用的用法 只是关联 得出 可以顺序不一样但要在这几个数据的范围
use student 
create table shi(
	shi_no int primary key,
	shi_name varchar(20) not null,
)
create table shi2(
	shi2_no int not null foreign key references shi(shi_no),
	shi2_name varchar(20),

)