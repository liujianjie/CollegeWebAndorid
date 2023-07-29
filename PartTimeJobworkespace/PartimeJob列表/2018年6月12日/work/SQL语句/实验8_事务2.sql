
USE 学生管理
GO
--默认值
update S set Sinfo = NULL where Sno = 40


--内容1）运行结果事务 1 读取数据的同时，事务 2 读取同一数据

begin tran
	select * from S where Sno = 40
commit tran



--内容2）事务 1 读取数据的同时，事务 2 修改同一数据
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED--级别为未提交读
begin transaction
	update S set Sinfo = '事务2更改' where Sno = 40
commit transaction

SET TRANSACTION ISOLATION LEVEL READ COMMITTED--级别为提交读
begin transaction
	update S set Sinfo = '事务2更改' where Sno = 40
commit transaction


SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin transaction
	update S set Sinfo = '事务2更改' where Sno = 40
commit transaction


--内容3）事务 1 修改数据的同时，事务 2 读取同一数据
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  --级别为未提交读
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --级别为提交读
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  


SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin transaction
	select * from dbo.S where Sno = 40  
commit transaction



--内容4）事务 1 修改数据的同时，事务 2 修改同一数据
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '事务2更改' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--最终结果 导致事务1 丢失了 事务2覆盖事务1更新了

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
begin tran  
	 waitfor delay '00:00:05'
    select * from S where Sno = 40   
    update STU set Sinfo = '事务2更改' from S STU where Sno = 40   
commit tran  
select * from S where Sno = 40;--最终结果 导致事务1 丢失了 事务2覆盖事务1更新了

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED --级别为未提交读
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '事务2更改' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--最终结果 导致事务1 丢失了 事务2覆盖事务1更新了

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --级别为提交读
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '事务2更改' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--最终结果 导致事务1 丢失了 事务2覆盖事务1更新了

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--级别为可重复读
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '事务2更改' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--最终结果 导致事务1 丢失了 事务2覆盖事务1更新了



--chagne
--一级


begin tran   
select * from S where Sno = 40  
commit tran  