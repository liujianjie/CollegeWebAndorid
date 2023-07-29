--删除学生表的信息时，同时删除这个学生的成绩表信息
use task
alter trigger d_dltstu
on student for delete
as
--删除数据的数据保存在临时表的deleted表中
declare @stuno varchar(8)
select @stuno=stuno from deleted
delete from studentcourse where stuno=@stuno

delete from student where stuno='20080102'


--插入一条学生信息时，插入一条缴费 id  stuno xf--inserted表存放由于执行insert或update语句而要向表中插入的所有行。--新建学费表create table xuefei(	id int primary key identity(1,1),	stuno int not null,	xf float null)alter table xuefei alter column stuno varchar(8) not nullcreate trigger x_addstuon student after insert as--增加数据保存在inserted临时表中declare @stuno varchar(8)select @stuno=stuno from insertedinsert into xuefei values(@stuno,2000)insert into student values('20008210','测试触发','200802','m',20)--不允许修改学生性别update的触发器 是用布尔值来判断 create trigger x_updstuon student for updateasif update(sex)begin	print '不能被修改'	rollback tranendupdate student set sex='m' where stuno='2008209'--修改触发器alter--删除触发器drop trigger x_updstu--启用/禁用disable trigger d_dltstu on studentenable trigger d_dltstu on student--加密触发器 with encrytion放在表名后alter trigger d_dltstu
on student with encryption for delete
as
--删除数据的数据保存在临时表的deleted表中
declare @stuno varchar(8)
select @stuno=stuno from deleted
delete from studentcourse where stuno=@stuno


alter trigger d_dltstu
on student for delete
with encryption
as
--删除数据的数据保存在临时表的deleted表中
declare @stuno varchar(8)
select @stuno=stuno from deleted
delete from studentcourse where stuno=@stuno


--判断学费缴清状态 --给学生表添加二个字段，学费缴清状态 statu（已缴清 未缴清） 应交学费总额alter table student add statu varchar(10)alter table student add total floatcreate trigger x_jtotalon xuefei for update,insertasdeclare @stuno varchar(8)declare @yjxf floatdeclare @xyxf floatselect @stuno=stuno from insertedselect @yjxf=sum(xf) from xuefei where stuno=@stunoselect @xyxf=total from student where stuno=@stunoif @yjxf<@xyxfbegin	update student set statu='未缴清' where stuno=@stunoendelsebegin 	update student set statu='已缴清' where stuno=@stunoendinsert into xuefei values('20008209',10000)insert into xuefei values('20008210',70000)