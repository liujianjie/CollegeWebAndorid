use T1
--�Ǿۼ�����(���249��)
create nonclustered index index_age on student(stu_age)
--Ĭ��ҲΪ�Ǿۼ�
drop index index_age on student
create index index_age on student(stu_age)

--��ѯ����������
select * from sysindexes 
--indid=1Ϊ�ۼ����� indid>1Ϊ�Ǿۼ�
sp_helpindex student

--ʱ���ѯ�Ա�
insert into student select stu_name,stu_sex,stu_age from student
declare @time datetime
select @time=getdate()
select * from student order by stu_age
select getdate()-@time
delete from student 
truncate table student

--���һ��
alter table student add stu_card varchar(20)

insert into student values('����','��',17,'23423423')
insert into student values('��˼˼','Ů',20,'3243242323')
insert into student values('������','Ů',17,'453423543')
insert into student values('���','��',19,'45324235234')
insert into student values('����','��',16,'3454363464')

--Ψһ�ۼ� Ĭ����Ӽ��Լ�� Ĭ��Ҳ�ǷǾۼ�
create unique index index_card on student(stu_card)
insert into student values('����','��',16,'3454363464')--Ĭ��Լ���Ͳ��ܸ���

--�������
create index index_name_age on student(stu_name,stu_age)
drop index index_name_age on student

--ǿ��ʹ������
select * from student with(index=index_age)

--�������
create index index_age on student(stu_age)
with fillfactor=20

--���ۼ�����
create table indexjj(
	id int not null,
	names varchar(6) not null
)
create clustered index pk_id on indexjj(id)