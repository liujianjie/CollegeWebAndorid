--这个是综合了实验8事务1实验8事务2，由于实验问题，必须分开两个页面运行
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

--初始化内容
update S set Sinfo = NULL where Sno = 40


--内容1)
/*首先3个级别
1.未提交读 会有脏读 会有不可重复读并发问题
2.提交读 不会有脏读 会有不可重复读并发问题
3.可重复读 不会有脏读和不可重复读并发问题

*/


--内容1）运行结果事务 1 读取数据的同时，事务 2 读取同一数据

begin tran
	select * from S where Sno = 40
	waitfor delay '00:00:07'
commit tran
select * from S where Sno = 40;--最终结果

begin transaction
	select * from S where Sno = 40;
commit transaction
select * from S where Sno = 40;--最终结果


--内容2）事务 1 读取数据的同时，事务 2 修改同一数据 并发问题：不可重复读取
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED --级别为未提交读
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--最终结果 事务1重复读

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED--级别为未提交读
begin transaction
	update S set Sinfo = '事务2更改' where Sno = 40
commit transaction


SET TRANSACTION ISOLATION LEVEL READ COMMITTED --级别为提交读
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--最终结果 事务1重复读了

SET TRANSACTION ISOLATION LEVEL READ COMMITTED--级别为提交读
begin transaction
	update S set Sinfo = '事务2更改' where Sno = 40
commit transaction

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--最终结果 事务没有重复读

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin transaction
	update S set Sinfo = '事务2更改' where Sno = 40
commit transaction


--内容3）事务 1 修改数据的同时，事务 2 读取同一数据 脏读
DBCC USEROPTIONS 
 
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  --级别为未提交读
begin tran  
	update S set Sinfo = '事务1更改' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --回滚   
select * from S where Sno = 40;--最终结果 事务2读取了没有提交的数据，脏读了

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  --级别为未提交读
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --级别为提交读
begin tran  
	update S set Sinfo = '事务1更改' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --回滚   
select * from S where Sno = 40;--最终结果 没有脏读

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --级别为提交读
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin tran  
	update S set Sinfo = '事务1更改' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --回滚   
select * from S where Sno = 40;--最终结果  没有脏读
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin transaction
	select * from dbo.S where Sno = 40  
commit transaction


--内容4）事务 1 修改数据的同时，事务 2 修改同一数据
begin tran  
    select * from dbo.S(nolock) where Sno = 40  
	waitfor delay '00:00:05' 
	update STU set Sinfo = '事务1更改' from S STU(nolock) where Sno = 40   
commit tran  
  
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '事务2更改' from S STU(nolock) where Sno = 40   
commit tran  

select * from S where Sno = 40;--最终结果 导致 丢失覆盖更新了




