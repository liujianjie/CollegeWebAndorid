--���ݿ�
create database T1
on primary(
	name=�߼�����T1,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\�߼����ֵ����ݿ�\�߼�����T1.mdf',
	size=3mb,
	maxsize=100mb,
	filegrowth=1mb	
)
log on(
	name=�߼�����TT1,
	filename='E:\��ͼ��ҵ��ϰ\SQL SERVER���ݿ�\�߼����ֵ����ݿ�\�߼�����TT1.ldf',
	size=3mb,
	maxsize=100mb,
	filegrowth=1mb		

)
use T1
--��
create table gongcheng(
	���̺� char(2) primary key not null,
	�������� varchar(20) not null

)

create table worker(
	ְ���� int primary key not null,
	���� varchar(20) not null

)

create table jop(
	ְ���� int primary key not null,
	ְ�� varchar(20) not null

)

create table moneys(
	ְ�� varchar(20) primary key not null,
	Сʱ������ int not null
)

create table main(
	��� int primary key identity(1,1) not null,
	���� char(2) not null references gongcheng(���̺�),
	ְ���� int not null references worker(ְ����),
	��ʱ int not null
)
alter table jop drop column ְ����
alter table jop drop PK__jop__00551192 
drop table moneys

alter table worker add ְ�� varchar(20)
alter table jop add ְ���� varchar(20)
alter table jop add Сʱ������ int
alter table jop add constraint pkzhiwu primary key (ְ����)
alter table worker add constraint YINYONG foreign key (ְ��) references jop(ְ����)