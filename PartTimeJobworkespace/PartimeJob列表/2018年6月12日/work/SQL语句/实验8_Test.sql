
--排它锁 事务2读取要等到事务1修改完成
begin tran   
select * from S (tablockx) where Sno = 40 ;
select * from S where Sno = 40  
commit tran  

--查询时
begin tran   
select * from S where Sno = 40  
commit tran  

--共享锁
begin tran
select * from S where Sno = 40
update S set Sinfo='事务2更改' where Sno = 40 
commit tran



--一级测试丢失更新
begin tran  
	select * from dbo.S where Sno = 40
	update STU set Sinfo = '事务2更改' from S STU where Sno = 40   
commit tran  
select * from S where Sno = 40

