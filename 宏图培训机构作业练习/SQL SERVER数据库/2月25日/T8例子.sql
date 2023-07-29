use task
select * from student,classes
select stuno,stuname,sex,age,classname from student s
	left join classes cs on s.classno=cs.classno
--�����洢������򵥵�
create procedure up_student
as
select stuno,stuname,sex,age,classname from student s
	left join classes cs on s.classno=cs.classno

--ʹ��
exec up_student

--���� һ����������Ĵ洢����
create procedure up_studentfind
@age int
as
select * from student where age=@age

exec up_studentfind 19

--�����β� 
create procedure up_studenttwo
@age int,
@sex char(2)
as
select * from student where age=@age and sex=@sex--ʹ��������

exec up_studenttwo 19,'m'

alter procedure up_studentone
@age int,
@sex char(2)
as
select * from student where age=@age--ʹ����һ��
 
exec up_studentone 18,'f'

--ָ��
declare @s char(2)
declare @a int
set @s='m'
set @a=19
exec up_studenttwo @sex=@s,@age=@a

--�鿴�洢����
sp_help up_studenttwo
sp_helptext up_studentone
--���ܴ洢����
alter procedure up_studenttwo
@age int,
@sex char(2)
with encryption--���ܱ��޸�
as
select * from student where age=@age and sex=@sex

--�޸�
alter --��ͷ

--����������Ĵ洢����
create procedure up_addstudent
@stuno varchar(20),
@stuname varchar(10),
@classno varchar(20),
@sex char(2),
@age int
as
insert into student values(@stuno,@stuname,@classno,@sex,@age)

exec up_addstudent '20080206','�ܶ�','200802','M',18

--try catch
alter procedure up_addstudent
@stuno varchar(20),
@stuname varchar(10),
@classno varchar(20),
@sex char(2),
@age char(2),--����Ϊ�������
@result varchar(10) output--�������
as
begin try
	insert into student values(@stuno,@stuname,@classno,@sex,@age)
	set @result='�ɹ�'
end try
begin catch
	--raiserror('����raiserror',10,3) --severity 1-10 10-18 >18����, state 1-127
	--print '����print'
	set @result='ʧ��'
end catch

declare @d varchar(10)
exec up_addstudent '20080207','�ܶ�','200802','M','a',@d output
select @d

--java����
alter procedure up_jdbcstudent
@stuno varchar(20),
@stuname varchar(20),
@classno varchar(20),
@sex varchar(2),
@age int--����Ϊ�������
as
insert into student values(@stuno,@stuname,@classno,@sex,@age)

--ɾ���洢����
drop��procedure up_jdbcstudent

String sql="{call up_addemp(?,?,?,?,?,?)}";
			CallableStatement cs=conn.prepareCall(sql);
			cs.setString(1, "����5");
			cs.setInt(2, 19);
			cs.setString(3, "F");
			cs.setString(4, "2016-2-25 10:07");
			cs.setString(5, "243656768979");
			cs.setFloat(6, 7000);
			int i=cs.executeUpdate();
			if(i>0){
				System.out.println("ִ�гɹ�");
			}else{
				System.out.println("ִ��ʧ��");
			}