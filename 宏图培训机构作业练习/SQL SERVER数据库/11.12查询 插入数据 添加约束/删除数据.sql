--查看表
select * from cite2
--创表
create table cite2(
	cite2_no int,
	cite2_name varchar(20)
)

create table cite4(
	cite4_no int not null,
	cite4_name varchar(20)
	
)
insert into cite4 values(9,'简介')
insert into cite4 values(10,'简洁')

--一列只能1条语句
--给所有列添加数据 一个行只能一条语句
insert into cite2 values(1,'刘建杰')
insert into cite2 values(2,'刘建杰')

--给指定列添加数据  一个行只能一条语句
insert into cite2(cite2_no) values(3)

--创建一个新的表
select * into cite3 from cite2

--插入数据 拷贝
insert into cite3 select * from cite2
insert into cite3 select * from cite4
 
--拷贝一定的字段
insert into cite3(cite2_no) select cite4_no from cite4
insert into cite3(cite2_no) select cite2_no from cite2

--修改全部数据
update cite2 set cite2_name='男神'

--修改部分数据
update cite2 set cite2_name='女神' where cite2_no=2

--删除数据
delete from dbo.cite4 

--删除部分数据
delete from cite3 where cite2_no=1

--删除所有数据
truncate table cite4

--删除约束
alter table 添加约束 drop CK