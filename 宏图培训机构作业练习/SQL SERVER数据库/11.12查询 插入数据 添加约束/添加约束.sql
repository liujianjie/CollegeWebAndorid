use ��ϰ
create table ���Լ��(
	shu_no int not null,
	shu_name varchar(20) not null,
	shu_age tinyint not null,
	shu_sex char(2) not null,
	shu_id char(20)
)
create table cite(
	cite_no int primary key not null,
	cite_name varchar(20) not null
)

--�������Լ��
alter table ���Լ�� add constraint PK primary key (shu_no)

--���ΨһԼ��
alter table ���Լ�� add constraint UN unique (shu_name)

--���Ĭ��Լ��
alter table ���Լ�� add constraint DE default 18 for shu_age--��������

--��ӷǿ�Լ��
alter table ���Լ�� alter column shu_id varchar(18)  --�޸ı���ĳ���ֶ� ����Ϊ�� 

--������Լ��
alter table ���Լ�� add constraint FK foreign key (shu_no) references cite(cite_no)

--��Ӽ��Լ��
alter table ���Լ�� add constraint CK check(shu_sex='��' or shu_sex='Ů')

--ɾ����
drop table ���Լ��