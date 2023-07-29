--事务练习

begin tran
declare @a int
set @a=0
	insert into student values('20080206','小小','200802','F',66)
	insert into student values('20080206','大大','200802','F','a')
set @a=@a+@@error-->=21如果有错误
if @a>0
begin
	print '执行失败'
	rollback--回滚
end
else
begin
	print '执行成功'
end
commit tran

--解除死锁
--死锁的形象概念:中国人拿了外国人的刀叉 外国人拿了中国人的筷子 都吃不了饭
SET deadlock_priority 
SET lock_timeout 

--设置隔离级别:
SET transaction isolation level SERIALIZABLE

--所有错误
select * from sysmessages order by error