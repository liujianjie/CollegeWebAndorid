use QQ���ݿ�;
create table QQ(
	id int primary key identity(1,1),--id
	qqnum varchar(50) not null,--qq��
	qqname varchar(50) not null,--�ǳ�
	pwd varchar(50) not null,--����
	face varchar(50) not null,--ͷ��
	names varchar(10) null,--��ʵ����
	age int null,--����
	sex varchar(10) not null,--�Ա�
	Date varchar(10) not null,--ũ������
	years varchar(20) not null,--���
	months varchar(10) not null,--�·�
	days varchar(10) not null,--�շ�
	country varchar(20) not null,--����
	province varchar(10) not null,--ʡ��
	city varchar(10) not null,--����
	mark varchar(100),--����ǩ��
	nation varchar(10) null,--����
	levels int null,--�ȼ�
	star varchar(20) null,--����
	status int not null--����״̬ 0 ���ߣ�1 ���ߣ�2 ����3 æµ
)