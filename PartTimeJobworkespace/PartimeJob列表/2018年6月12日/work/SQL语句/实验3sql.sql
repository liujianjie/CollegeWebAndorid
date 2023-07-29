--ʵ������1��
USE ѧ������
GO

IF exists (select name from sysobjects   where id=object_id(N'[SC]') )
DROP TABLE SC
GO

IF exists (select name from sysobjects   where id=object_id(N'[S]') )
DROP TABLE S
GO

IF exists (select name from sysobjects   where id=object_id(N'[C]' ) )
DROP TABLE C 
GO

--ѧ����ϵ��
create table S(
	Sno int not null,
	Sname varchar(50) not null,
	Ssex varchar(2)  not null,
	Sage tinyint  not null,
	sdept varchar(50) not null,
	constraint pk_S primary key(Sno),
	constraint ck_S check (Ssex = '��' or Ssex = 'Ů')
)
go

--�γ̹�ϵ��C
create table C(
	Cno smallint not null,
	Cname varchar(50) not null ,
	Cpno varchar(50),
	Ccredit tinyint  not null
	constraint pk_C  primary key(Cno),
	constraint uk_C unique(Cname)
)
go
--ѧ��-�γ̱�SC
create table SC(
	Sno int not null,
	Cno smallint not null,
	grade float  not null,
	constraint fk_SC_1 foreign key(Sno) references S(Sno), 
	constraint fk_SC_2 foreign key(Cno) references C(Cno)
)
go
--ʵ������2
insert into S values(40,'��','Ů',19,'������ϵ'); 
insert into S values(41,'��С��','��',20,'��Ϣ����ϵ');
insert into S values(42,'��С��','��',21,'ʳƷϵ'); 
insert into S values(43,'��С��','Ů',22,'��ѧϵ');

insert into C values(01,'C����','',10);
insert into C values(02,'JAVA���Գ�����ƣ�һ��','C����',10);
insert into C values(03,'C++�������','JAVA���Գ�����ƣ�һ��',10);
insert into C values(04,'���ݿ⼼����Ӧ��','C++�������',10);
insert into C values(05,'������Ϣϵͳ','���ݿ⼼����Ӧ��',10);

insert into SC values(40,01,86);
insert into SC values(40,02,90);
insert into SC values(40,03,80);
insert into SC values(40,04,70);
insert into SC values(40,05,90);
insert into SC values(43,01,80);
insert into SC values(43,02,90);
insert into SC values(43,03,80);
insert into SC values(43,04,90);
insert into SC values(43,05,70);

select * from S;select * FROM C; select * from SC

--����3���ڱ� S �����ӡ��������ڡ������У�

alter table S add Sborn Smalldatetime;

select * from S

--����4

alter table S drop column Sage;

select * from S;

--����5

drop table SC;

SELECT * FROM SC;