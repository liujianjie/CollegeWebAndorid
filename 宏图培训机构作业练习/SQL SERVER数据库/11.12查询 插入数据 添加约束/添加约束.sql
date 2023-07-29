use 练习
create table 添加约束(
	shu_no int not null,
	shu_name varchar(20) not null,
	shu_age tinyint not null,
	shu_sex char(2) not null,
	shu_id char(20)
)
create table cite(
	cite_no int primary key not null,
	cite_name varchar(20) not null
)

--添加主键约束
alter table 添加约束 add constraint PK primary key (shu_no)

--添加唯一约束
alter table 添加约束 add constraint UN unique (shu_name)

--添加默认约束
alter table 添加约束 add constraint DE default 18 for shu_age--不用括号

--添加非空约束
alter table 添加约束 alter column shu_id varchar(18)  --修改表格的某个字段 可以为空 

--添加外键约束
alter table 添加约束 add constraint FK foreign key (shu_no) references cite(cite_no)

--添加检查约束
alter table 添加约束 add constraint CK check(shu_sex='男' or shu_sex='女')

--删除表
drop table 添加约束