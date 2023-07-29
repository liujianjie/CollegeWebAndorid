--上机作业哦
--5.1.	自己创建一个工资表，插入十条记录，然后利用游标来修改工资值：
--1.	工资低于2000的，增加800
--2.	工资在2000—3000的，增加500
--3.	工资在3000—4000的，增加200
--4.	工资高于4000的，减少100
create table salary(
	s_id int identity(1,1) primary key not null,
	s_salary float not null	
)
insert into salary values(1300)
insert into salary values(2300)
insert into salary values(3300)
insert into salary values(4300)
insert into salary values(4600)
insert into salary values(6300)
insert into salary values(3300)
insert into salary values(4700)
insert into salary values(4300)

--具体
declare @sa float,@id int
declare sa cursor scroll for select * from salary
open sa
fetch next from sa into @id,@sa
while @@fetch_status=0
begin
	if @sa<2000
		begin
		update salary set s_salary=s_salary+800 where current of sa
		end
	if @sa>2000 and @sa<3000
		begin
		update salary set s_salary=s_salary+500 where current of sa
		end
	if @sa>3000 and @sa<4000
		begin
		update salary set s_salary=s_salary+200 where current of sa
		end
	if @sa>4000
		begin
		update salary set s_salary=s_salary-100 where current of sa
		end
	fetch next from sa into @id,@sa
end
close sa
deallocate sa

