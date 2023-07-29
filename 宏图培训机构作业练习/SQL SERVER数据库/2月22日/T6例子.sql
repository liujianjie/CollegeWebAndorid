--T-SQL游标 的使用步骤
--1,定义游标
declare stu cursor scroll for select * from student
--2.打开游标
open stu
--3.检索游标
fetch first from stu
--4.关闭游标
close stu
--5.释放游标
deallocate stu

--scroll滚动游标（能向前能向后） forward only游标（只能向前）不能与first这些一起使用
select * from student

declare stu cursor FORWARD_ONLY for select * from student
open stu
fetch next from stu
fetch first from stu--不能使用
close stu
deallocate stu

declare stu cursor scroll for select * from student
open stu
fetch next from stu
fetch first from stu--游标默认的位置不会是第一条数据
fetch next from stu--游标的位置会改变 不会每次停在默认位置
fetch prior from stu--上一条
fetch absolute -5 from stu--绝对位置 根据游标默认位置来移动
fetch relative 3 from stu--相对位置 根据游标现在位置来移动
close stu
deallocate stu

--将检索出来的数据封装在变量中
use task
declare @no varchar(20),@cno varchar(10),@score float
declare score cursor scroll for select * from studentcourse
open score
fetch next from score into @no,@cno,@score
close score
deallocate score
select @no,@cno,@score

--用游标来改变数据值 用到系统变量 @@fetch_status上一个值fetch返回的结果
declare @no varchar(20),@cno varchar(10),@score float
declare score cursor for select * from studentcourse
open score
fetch next from score into @no,@cno,@score
while(@@fetch_status=0)--提取成功
begin 
	if @cno=201
	begin
		update studentcourse set score=score+5 where  current of score
	end
	if @cno=202
	begin
		update studentcourse set score=score+5 where  current of score
	end
	if @cno=203
	begin
		update studentcourse set score=score+5 where  current of score
	end
	fetch next from score into @no,@cno,@score--当没有数据时则为 -1 或-2
end
close score
deallocate score

--利用全局变量 @@cursor_rows来循环遍历游标中的数据
declare score cursor scroll static for select * from studentcourse
open score
declare @i int,@sc float--分数依次增加 5 10 15.。。。
set @i=0
set @sc=5
while @i<@@cursor_rows
begin
	set @i=@i+1
	--update studentcourse set score=score+@sc where  current of score
	set @sc=@sc+5
	fetch next from score
end
close score
deallocate score