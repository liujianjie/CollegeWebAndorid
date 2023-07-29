BEGIN
create database ��վ���ݿ�
on primary(
	name = '��վ���ݿ�',
	filename = 'E:\��վ���ݿ�_log.mdf',
	size = 5mb,
	maxsize = 100mb,
	filegrowth = 1mb
	
)
log on(
	name = '��վ���ݿ�_log', 
	filename = 'E:\��վ���ݿ�_log.ldf',                     
	size = 2mb,                         
	maxsize = 100mb,          
	filegrowth = 10%           
)
END

USE  ��վ���ݿ�
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[Ticket]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
DROP TABLE Ticket;
END
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[Routeinfo]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
Alter TABLE Routeinfo DROP constraint fk_routeinfo;
DROP TABLE Routeinfo;
END
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[Empveh]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
Alter TABLE Empveh DROP constraint fk_empveh1;
Alter TABLE Empveh DROP constraint fk_empveh2;
DROP TABLE Empveh;
END
GO


IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[Vehicle]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
DROP TABLE Vehicle;
END
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[Employee]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
DROP TABLE Employee;
END
GO


--����1

--Ա��
create table Employee(
	eId int identity(1,1),
	eName varchar(20),
	eSex varchar(2),
	eAge tinyint,
	ePosition varchar(40),
	ePhone varchar(11),
	constraint eSex check (eSex = '��' or eSex = 'Ů'),
	constraint pk_employee primary key(eId)
)
go

--������Ϣ
create table Vehicle(
	vId int identity(1,1),
	vType varchar(20),
	vLoadcount tinyint,
	vNo varchar(20),
	constraint pk_Vehicle primary key(vId)
)
go

--������Ա����Ӧ,��Ϊһ����һ��˾��һ��������Ա
create table Empveh(
	evId int identity(1,1),
	vId int,
	eId int,
	constraint fk_empveh1 foreign key(vId) references Vehicle(vId),
	constraint fk_empveh2 foreign key(eId) references Employee(eId),
	constraint pk_Empveh primary key(evId)
)
go

--������Ϣ
create table Routeinfo(
	rId int identity(1,1),
	vId	int,
	rNo varchar(20),
	rDeparture varchar(30),
	rDetination varchar(30),
	rMileague smallint,
	rStarttime varchar(20),
	rTimecost smallint,
	rDeparturedate varchar(11),
	rNote varchar(50),
	constraint pk_routeinfo primary key(rId),
	constraint fk_routeinfo foreign key(vId) references Vehicle(vId)
)
go


--Ʊ����Ϣ
create table Ticket(
	tId int identity(1,1),
	rId int,
	tTotalvotes tinyint,
	tRemainvotes tinyint,
	tPrice float,
	constraint pk_ticket primary key(tId)
)
go
  
insert into employee
	values('��һ','��',23,'˾��',11111111111),
			('�¶�','��',24,'˾��',11111111111),
			('���� ','��',24,'˾��',11111111111),
			('С�� ','Ů',24,'������Ա',11111111111),
			('С�� ','Ů',21,'������Ա',11111111111),
			('����','Ů',23,'������Ա',11111111111),
			('����','��',24,'��Ʊ��Ա',11111111111),
			('�ܰ� ','��',24,'��Ʊ��Ա',11111111111)

insert into Vehicle
	values('����',40,'��B549SB'),('����',40,'��BQQ001'),
			('����',40,'��B22222'),('�ִ�',20,'��B45678'),
			('�ִ�',20,'��BZZZ22'),('�ִ�',20,'��BGZ567')

insert into empveh
	values(1,1),(1,4),(2,2),(2,5),(3,3),(3,6)

insert into Routeinfo
	values(1,'Z840','�人','������',380,'08:40',4,CONVERT(varchar(10), getdate(), 120 ),NULL),
		(2,'K640','�人','����',380,'09:40',3,CONVERT(varchar(10), getdate(), 120 ),NULL),
		(4,'K140','�人','Т��',74,'18:50',1,CONVERT(varchar(10), getdate(), 120 ),NULL),
		(1,'K640','�人','�差',321,'09:40',5,CONVERT(varchar(10), dateadd(day,7,getdate()), 120 ),NULL),
		(1,'K140','�人','����',430,'18:50',4,CONVERT(varchar(10), dateadd(day,7,getdate()), 120 ),NULL),
		(5,'Z841','�人','������',380,'13:40',4,CONVERT(varchar(10), getdate(), 120 ),NULL)

--����һ��������� ����Ϊ�ִ�
insert into routeinfo values(5,'Z841','�人','������',380,'19:40',4,CONVERT(varchar(10), getdate(), 120 ),NULL)

insert into Ticket
	values(1,40,40,140),(2,40,40,60),(3,20,20,120),
		(6,20,20,70),(7,20,20,80)

select * from employee
select * from Vehicle
select * from empveh
select * from Routeinfo
select * from Ticket

--����3
--��routeinfo�� ��ɾ�϶࣬�����Ǿۼ����� ������ɾ���ٶ�

create nonclustered index routeinfo_vId on routeinfo(vId)

--����4 Ϊ������Ա������ɫ��ʹ�����ݿ��Ȩ��

exec sp_addrole 'passenger_role'--�˿�

exec sp_addrole 'driver_role'--˾��

exec sp_addrole 'crew_role'--������Ա

exec sp_addrole 'saleman_role'--��ƱԱ

exec sp_addrole 'manage_role'--����Ա

GRANT SELECT ON Ticket TO passenger_role--�˿� ֻ�в�ѯƱ����Ϣ ��ticket

GRANT SELECT ON Routeinfo TO driver_role--˾�� ֻ�в�ѯ�Լ��˵�·����Ϣ

GRANT SELECT ON Routeinfo TO crew_role--������Ա ֻ�в�ѯ�Լ��˵�·����Ϣ

GRANT SELECT,update,delete,insert ON Ticket TO saleman_role--��ƱԱ �������޸� ���� ��ѯƱ ���� ��������Ʊ��

GRANT SELECT,update,delete,insert ON Routeinfo TO manage_role--����Ա�����ԶԷ�����Ϣ���������ΪҪ���ӷ�����Ϣ �Լ��޸� ��Щ


--����5

--�˿�ֻ�ܲ�ѯ���췢��ʱ��,��λ��Ʊ�� ��Щ��Ϣ
GO
CREATE VIEW passenger_routeticket
AS
SELECT t.tPrice as Ʊ��, t.tRemainvotes as ʣ����λ, v.vType as ����,v.vNo as ���ƺ�,r.rStarttime as ����ʱ��
FROM Routeinfo r
	LEFT JOIN Ticket t ON r.rId = t.rId
	INNER JOIN Vehicle v ON r.vId = v.vId
WHERE rDeparturedate = CONVERT(varchar(10), getdate(), 120)
GO
GRANT SELECT ON passenger_routeticket TO passenger_role--����Ȩ��

--˾���ͳ�����Աһ���������챻�����ĸ��� ��������
GO
CREATE VIEW drivercrew_routvehc_view
AS
SELECT emp.eName, ve.vNo, rout.rNo, rout.rDeparture, rout.rDetination
	, rout.rMileague, rout.rStarttime, rout.rTimecost, rout.rDeparturedate
FROM Employee emp
	INNER JOIN Empveh empve ON empve.eId = emp.eId
	INNER JOIN Vehicle ve ON empve.vId = ve.vId
	INNER JOIN Routeinfo rout ON rout.vId = ve.vId
WHERE rDeparturedate = CONVERT(varchar(10), getdate(), 120)
GO
GRANT SELECT ON drivercrew_routvehc_view TO driver_role
GRANT SELECT ON drivercrew_routvehc_view TO crew_role

--��ƱԱ���Կ���������Ϣ,�����������ĺ������� ���޸�����ticket������ݣ���Ϊ�˷�ֹ�Է�����Ϣ��Ĳ�������Ҫ����һ����ͼ
GO
CREATE VIEW salesman_routeinfo_view
AS
SELECT ve.vLoadcount,rout.*
FROM Routeinfo rout
inner join Vehicle ve
on ve.vId = rout.vId

GO
GRANT SELECT ON salesman_routeinfo_view TO saleman_role


--������Ա ������һ�ܳ�����Ա��˾��ʱ�������Ӧ�õÿ�����һ���Ѿ����ŵ�·����Ϣ ��˾����������Ա�����֣�������
GO
CREATE VIEW manage_routvehc_view
AS
SELECT emp.eName,emp.ePosition, ve.vNo, rout.rNo, rout.rDeparture, rout.rDetination
	, rout.rMileague, rout.rStarttime, rout.rTimecost, rout.rDeparturedate
FROM Employee emp
	INNER JOIN Empveh empve ON empve.eId = emp.eId
	INNER JOIN Vehicle ve ON empve.vId = ve.vId
	INNER JOIN Routeinfo rout ON rout.vId = ve.vId
WHERE convert(datetime, rout.rDeparturedate) > DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 7, getdate())), 0)
	AND convert(datetime, rout.rDeparturedate) < DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 14, getdate())), 0)

GO
GRANT SELECT ON manage_routvehc_view TO manage_role


--����7

SELECT t.tPrice as Ʊ��, t.tRemainvotes as ʣ����λ, v.vType as ����,v.vNo as ���ƺ�,r.rStarttime as ����ʱ��,
		r.rDeparture,r.rDetination
FROM Routeinfo r
	LEFT JOIN Ticket t ON r.rId = t.rId
	INNER JOIN Vehicle v ON r.vId = v.vId
WHERE rDeparturedate = CONVERT(varchar(10), getdate(), 120)
	AND rDeparture = '�人'
	AND rDetination = '������'

--����6

SELECT emp.eName, ve.vType, ve.vNo, rt.rNo, rt.rDeparture
	, rt.rDetination, rt.rMileague, rt.rStarttime, rt.rTimecost, rt.rDeparturedate
FROM Employee emp
	INNER JOIN Empveh ev ON emp.eId = ev.eId
	INNER JOIN Vehicle ve ON ev.vId = ve.vId
	INNER JOIN Routeinfo rt ON ve.vId = rt.vId
WHERE convert(datetime, rt.rDeparturedate) > DATEADD(wk, DATEDIFF(wk, 0, getdate()), 0)
	AND convert(datetime, rt.rDeparturedate) < DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 7, getdate())), 0)
	AND emp.eName = '��һ'

--����8
--�������������
begin tran
declare @salecount int
declare @remain int
select * from Ticket (tablockx) where rId = 1 
update Ticket set tRemainvotes = tRemainvotes - @salecount where rId = 1  
select @remain = tRemainvotes from Ticket where rId = 1 
if @remain > 0 
begin 
commit tran
end
begin 
rollback tran
end


--��һ�����
--select * from Ticket

--begin tran
--declare @currentTicket int
--declare @afterTicket int
--declare @salecount int
--set @salecount=2
--select @currentTicket=tRemainvotes from Ticket where rId = 1
--update Ticket set tRemainvotes = tRemainvotes - @salecount where rId = 1
--select @afterTicket=tRemainvotes from Ticket where rId = 1

--if @currentTicket - @salecount = @afterTicket
--begin
--  commit tran
--end
--else
--begin
--  rollback tran
--end;


select * from Ticket

--����9

--���޸�ʣ��Ʊ����װ���� 2 ��Ʊ
update Ticket set tRemainvotes = 38 where rId = 1
update Ticket set tRemainvotes = 38 where rId = 2
update Ticket set tRemainvotes = 18 where rId =6
update Ticket set tRemainvotes = 18 where rId =7

--ͳ����Ӫ�ܽ��֮ǰһ��
select tic.tId,tic.rId,ve.vType as ����,tTotalvotes as ��Ʊ��,tic.tRemainvotes as ʣ��Ʊ,tic.tprice as �۸�
from Ticket tic
inner join Routeinfo rt
on rt.rId = tic.rId
inner join Vehicle ve
on ve.vId = rt.vId
WHERE convert(datetime, rt.rDeparturedate) > DATEADD(wk, DATEDIFF(wk, 0, getdate()), 0)
	AND convert(datetime, rt.rDeparturedate) < DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 7, getdate())), 0)
	AND ve.vType = '����'

SELECT SUM(ti.tTotalvotes - ti.tRemainvotes) AS �˿�������
	, SUM((ti.tTotalvotes - ti.tRemainvotes) * ti.tPrice) AS ��Ӫ�ܽ��
FROM Routeinfo rt
	INNER JOIN Ticket ti ON ti.rId = rt.rId
	INNER JOIN Vehicle ve ON rt.vId = ve.vId
WHERE convert(datetime, rt.rDeparturedate) > DATEADD(wk, DATEDIFF(wk, 0, getdate()), 0)
	AND convert(datetime, rt.rDeparturedate) < DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 7, getdate())), 0)
	AND ve.vType = '����'
GROUP BY vType


--����sql
SELECT DATEADD(wk, DATEDIFF(wk,0,getdate()), 0)
select dateadd(day,7,getdate())
select * from routeinfo
select DATEPART(year,getdate()),DATEPART(month,getdate()),DATEPART(day,getdate())

select CONVERT(varchar(10), getdate(), 120 )

select count(*) from Routeinfo group by rDeparturedate

select * from employee
select * from Vehicle
select * from empveh
select * from Routeinfo
select * from Ticket

select DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 14, getdate())), 0)
