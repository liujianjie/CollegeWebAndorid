IF NOT exists (select * from sys.databases where name = '学生管理' )
BEGIN
RESTORE DATABASE "学生管理" FROM DISK='E://学生管理.db' WITH REPLACE;
END
GO

USE 学生管理;
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[SC]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
DROP TABLE SC;
END
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[S]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
DROP TABLE S;
END
GO

create table S(
	Sno int not null,
	Sname varchar(50) not null,
	Sinfo varchar(50)
)
insert into S(Sno,Sname) values(40,'张');


USE 学生管理
GO


--默认值
update S set Sinfo = NULL where Sno = 40

--内容1）运行结果事务 1 读取数据的同时，事务 2 读取同一数据


begin tran
	select * from S where Sno = 40
	waitfor delay '00:00:07'
commit tran
select * from S where Sno = 40;--最终结果



--内容2）事务 1 读取数据的同时，事务 2 修改同一数据 并发问题：不可重复读取
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED --级别为未提交读
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--最终结果 事务1重复读


SET TRANSACTION ISOLATION LEVEL READ COMMITTED --级别为提交读
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--最终结果 事务1重复读了


SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--最终结果 事务没有重复读


--内容3）事务 1 修改数据的同时，事务 2 读取同一数据 脏读
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  --级别为未提交读
begin tran  
	update S set Sinfo = '事务1更改' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --回滚   
select * from S where Sno = 40;--最终结果 事务2读取了没有提交的数据，脏读了


SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --级别为提交读
begin tran  
	update S set Sinfo = '事务1更改' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --回滚   
select * from S where Sno = 40;--最终结果 没有脏读


SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin tran  
	update S set Sinfo = '事务1更改' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --回滚   
select * from S where Sno = 40;--最终结果  没有脏读


--内容4）事务 1 修改数据的同时，事务 2 修改同一数据 丢失 更新覆盖问题
begin tran  
    select * from dbo.S(nolock) where Sno = 40  
	waitfor delay '00:00:05' 
	update STU set Sinfo = '事务1更改' from S STU(nolock) where Sno = 40   
commit tran  


USE 学生管理
update S set Sinfo = NULL where Sno = 40

DBCC USEROPTIONS  


--change 封锁协议等级 对应 着事务隔离级别

DBCC USEROPTIONS  
update S set Sinfo = NULL where Sno = 40


--排它锁（X）持有的事务拥有，其它事务不能访问和修改，除非提交了 或 rollback了

begin tran   
select * from S (tablockx) where Sno = 40 ;
update S set Sinfo='事务1更改' where Sno = 40  
waitfor delay '00:00:15' --等待30秒   
commit tran   

--事务1查询时，普通查询时，两个事务会有冲突
begin tran   
select * from S where Sno = 40  
waitfor delay '00:00:10' --等待30秒   
commit tran  


--共享锁s锁  任何其它事务都不能修改数据，一旦已经读取数据，便立即释放资源上的共享 (S) 锁

begin tran   
select * from S with (holdlock)
where Sno = 40 --holdlock人为加锁  
waitfor delay '00:00:10' --等待30秒   
commit tran


--一级锁测试丢失更新 结果不会 不会丢失更新，恩是的，因为排它锁的原因吧 管他 用来处理实验第8题
begin tran  
    select * from dbo.S(tablockx) where Sno = 40  
	waitfor delay '00:00:10' 
	update STU set Sinfo = '事务1更改' from S STU where Sno = 40   
commit tran