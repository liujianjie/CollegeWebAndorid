use ��������������ݿ�
create table student(
	stu_no int identity(1,1) not null,--�Զ�����
	stu_name varchar(20) not null,--����
	stu_sex char(2) check(stu_sex='��' or stu_sex='Ů') default '��' not null,--��Լ��
	stu_age int check(stu_age>0 and stu_age<100) not null,--��Լ��
	stu_num varchar(11) not null unique --ΨһԼ��
)

