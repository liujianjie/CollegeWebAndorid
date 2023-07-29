use task
select * from student,classes
select stuno,stuname,sex,age,classname from student s
	left join classes cs on s.classno=cs.classno
--创建存储过程最简单的
create procedure up_student
as
select stuno,stuname,sex,age,classname from student s
	left join classes cs on s.classno=cs.classno

--使用
exec up_student

--参数 一个输入参数的存储过程
create procedure up_studentfind
@age int
as
select * from student where age=@age

exec up_studentfind 19

--两个形参 
create procedure up_studenttwo
@age int,
@sex char(2)
as
select * from student where age=@age and sex=@sex--使用了两个

exec up_studenttwo 19,'m'

alter procedure up_studentone
@age int,
@sex char(2)
as
select * from student where age=@age--使用了一个
 
exec up_studentone 18,'f'

--指定
declare @s char(2)
declare @a int
set @s='m'
set @a=19
exec up_studenttwo @sex=@s,@age=@a

--查看存储过程
sp_help up_studenttwo
sp_helptext up_studentone
--加密存储过程
alter procedure up_studenttwo
@age int,
@sex char(2)
with encryption--不能被修改
as
select * from student where age=@age and sex=@sex

--修改
alter --开头

--带输入输出的存储过程
create procedure up_addstudent
@stuno varchar(20),
@stuname varchar(10),
@classno varchar(20),
@sex char(2),
@age int
as
insert into student values(@stuno,@stuname,@classno,@sex,@age)

exec up_addstudent '20080206','熊二','200802','M',18

--try catch
alter procedure up_addstudent
@stuno varchar(20),
@stuname varchar(10),
@classno varchar(20),
@sex char(2),
@age char(2),--以上为输入参数
@result varchar(10) output--输出参数
as
begin try
	insert into student values(@stuno,@stuname,@classno,@sex,@age)
	set @result='成功'
end try
begin catch
	--raiserror('错误raiserror',10,3) --severity 1-10 10-18 >18严重, state 1-127
	--print '错误print'
	set @result='失败'
end catch

declare @d varchar(10)
exec up_addstudent '20080207','熊二','200802','M','a',@d output
select @d

--java程序
alter procedure up_jdbcstudent
@stuno varchar(20),
@stuname varchar(20),
@classno varchar(20),
@sex varchar(2),
@age int--以上为输入参数
as
insert into student values(@stuno,@stuname,@classno,@sex,@age)

--删除存储过程
drop　procedure up_jdbcstudent

String sql="{call up_addemp(?,?,?,?,?,?)}";
			CallableStatement cs=conn.prepareCall(sql);
			cs.setString(1, "测试5");
			cs.setInt(2, 19);
			cs.setString(3, "F");
			cs.setString(4, "2016-2-25 10:07");
			cs.setString(5, "243656768979");
			cs.setFloat(6, 7000);
			int i=cs.executeUpdate();
			if(i>0){
				System.out.println("执行成功");
			}else{
				System.out.println("执行失败");
			}