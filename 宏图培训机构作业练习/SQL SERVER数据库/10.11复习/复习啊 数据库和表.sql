--�������ݿ�
create database student
on primary(
	name=student,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\10.11��ϰ\student.mdf',
	size=3mb,
	maxsize=10mb,
	filegrowth=1mb
)
log on(
	name=student1,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\10.11��ϰ\student1.ldf',
	size=3mb,
	maxsize=10mb,
	filegrowth=1mb
)
--��
use student
create table wan1(
	wan1_no int identity(1,1) primary key not null,--�Զ�����
	wan1_name varchar(20) not null,
	wan1_sex char(2) check(wan1_sex='��' or wan1_sex='Ů'),
	wan1_age tinyint check(wan1_age>=0 and wan1_age<=100),
	wan1_id varchar(18) not null unique,
	wan1_nub varchar(11) not null unique,
	wan1_hh uniqueidentifier default newid() --ȫ��Ψһ��ʶ��
	wan1_name1 varchar(20) not null foreign key references wan(wan_name) --���� ����ûʲô���� ֻ�ǹ��� Ҫһ�� �����Զ�����ȥ
)
--�޸ı�
--���
alter table wan1 add wan_level int default 1
--�޸�
alter table wan1 alter column wan1_name int
--ɾ�����ĳ���ֶ�
alter table wan1 drop column wan1_name
--���
alter table wan1 add wan1_name varchar(20) not null
--ɾ����
drop table wan1