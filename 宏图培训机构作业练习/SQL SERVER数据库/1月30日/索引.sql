use T1
--非聚集索引(最多249个)
create nonclustered index index_age on student(stu_age)
--默认也为非聚集
drop index index_age on student
create index index_age on student(stu_age)

--查询所有索引表
select * from sysindexes 
--indid=1为聚集索引 indid>1为非聚集
sp_helpindex student

--时间查询对比
insert into student select stu_name,stu_sex,stu_age from student
declare @time datetime
select @time=getdate()
select * from student order by stu_age
select getdate()-@time
delete from student 
truncate table student

--添加一列
alter table student add stu_card varchar(20)

insert into student values('张三','男',17,'23423423')
insert into student values('李思思','女',20,'3243242323')
insert into student values('张曼曼','女',17,'453423543')
insert into student values('吴昊','男',19,'45324235234')
insert into student values('刘浩','男',16,'3454363464')

--唯一聚集 默认添加检查约束 默认也是非聚集
create unique index index_card on student(stu_card)
insert into student values('刘浩','男',16,'3454363464')--默认约束就不能该了

--组合索引
create index index_name_age on student(stu_name,stu_age)
drop index index_name_age on student

--强制使用索引
select * from student with(index=index_age)

--填充因子
create index index_age on student(stu_age)
with fillfactor=20

--创聚集索引
create table indexjj(
	id int not null,
	names varchar(6) not null
)
create clustered index pk_id on indexjj(id)