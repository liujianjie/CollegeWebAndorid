BEGIN
create database 车站数据库
on primary(
	name = '车站数据库',
	filename = 'E:\车站数据库_log.mdf',
	size = 5mb,
	maxsize = 100mb,
	filegrowth = 1mb
	
)
log on(
	name = '车站数据库_log', 
	filename = 'E:\车站数据库_log.ldf',                     
	size = 2mb,                         
	maxsize = 100mb,          
	filegrowth = 10%           
)
END

USE  车站数据库
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


--内容1

--员工
create table Employee(
	eId int identity(1,1),
	eName varchar(20),
	eSex varchar(2),
	eAge tinyint,
	ePosition varchar(40),
	ePhone varchar(11),
	constraint eSex check (eSex = '男' or eSex = '女'),
	constraint pk_employee primary key(eId)
)
go

--车辆信息
create table Vehicle(
	vId int identity(1,1),
	vType varchar(20),
	vLoadcount tinyint,
	vNo varchar(20),
	constraint pk_Vehicle primary key(vId)
)
go

--车辆与员工对应,因为一辆车一个司机一个乘务人员
create table Empveh(
	evId int identity(1,1),
	vId int,
	eId int,
	constraint fk_empveh1 foreign key(vId) references Vehicle(vId),
	constraint fk_empveh2 foreign key(eId) references Employee(eId),
	constraint pk_Empveh primary key(evId)
)
go

--发车信息
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


--票务信息
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
	values('刘一','男',23,'司机',11111111111),
			('陈二','男',24,'司机',11111111111),
			('张三 ','男',24,'司机',11111111111),
			('小红 ','女',24,'乘务人员',11111111111),
			('小花 ','女',21,'乘务人员',11111111111),
			('赵六','女',23,'乘务人员',11111111111),
			('孙七','男',24,'售票人员',11111111111),
			('周八 ','男',24,'售票人员',11111111111)

insert into Vehicle
	values('大宇',40,'粤B549SB'),('大宇',40,'粤BQQ001'),
			('大宇',40,'粤B22222'),('现代',20,'粤B45678'),
			('现代',20,'粤BZZZ22'),('现代',20,'粤BGZ567')

insert into empveh
	values(1,1),(1,4),(2,2),(2,5),(3,3),(3,6)

insert into Routeinfo
	values(1,'Z840','武汉','景德镇',380,'08:40',4,CONVERT(varchar(10), getdate(), 120 ),NULL),
		(2,'K640','武汉','天门',380,'09:40',3,CONVERT(varchar(10), getdate(), 120 ),NULL),
		(4,'K140','武汉','孝感',74,'18:50',1,CONVERT(varchar(10), getdate(), 120 ),NULL),
		(1,'K640','武汉','襄樊',321,'09:40',5,CONVERT(varchar(10), dateadd(day,7,getdate()), 120 ),NULL),
		(1,'K140','武汉','常德',430,'18:50',4,CONVERT(varchar(10), dateadd(day,7,getdate()), 120 ),NULL),
		(5,'Z841','武汉','景德镇',380,'13:40',4,CONVERT(varchar(10), getdate(), 120 ),NULL)

--增加一个今天出发 车型为现代
insert into routeinfo values(5,'Z841','武汉','景德镇',380,'19:40',4,CONVERT(varchar(10), getdate(), 120 ),NULL)

insert into Ticket
	values(1,40,40,140),(2,40,40,60),(3,20,20,120),
		(6,20,20,70),(7,20,20,80)

select * from employee
select * from Vehicle
select * from empveh
select * from Routeinfo
select * from Ticket

--内容3
--对routeinfo表 增删较多，建立非聚集索引 增加增删改速度

create nonclustered index routeinfo_vId on routeinfo(vId)

--内容4 为工作人员建立角色和使用数据库的权限

exec sp_addrole 'passenger_role'--乘客

exec sp_addrole 'driver_role'--司机

exec sp_addrole 'crew_role'--乘务人员

exec sp_addrole 'saleman_role'--售票员

exec sp_addrole 'manage_role'--管理员

GRANT SELECT ON Ticket TO passenger_role--乘客 只有查询票的信息 即ticket

GRANT SELECT ON Routeinfo TO driver_role--司机 只有查询自己运的路线信息

GRANT SELECT ON Routeinfo TO crew_role--乘务人员 只有查询自己运的路线信息

GRANT SELECT,update,delete,insert ON Ticket TO saleman_role--售票员 ，可以修改 增加 查询票 余数 ，总数，票价

GRANT SELECT,update,delete,insert ON Routeinfo TO manage_role--管理员，可以对发车信息表操作，因为要增加发车信息 以及修改 这些


--内容5

--乘客只能查询今天发车时间,座位和票价 这些信息
GO
CREATE VIEW passenger_routeticket
AS
SELECT t.tPrice as 票价, t.tRemainvotes as 剩余坐位, v.vType as 车型,v.vNo as 车牌号,r.rStarttime as 发车时间
FROM Routeinfo r
	LEFT JOIN Ticket t ON r.rId = t.rId
	INNER JOIN Vehicle v ON r.vId = v.vId
WHERE rDeparturedate = CONVERT(varchar(10), getdate(), 120)
GO
GRANT SELECT ON passenger_routeticket TO passenger_role--赋予权限

--司机和乘务人员一样，看今天被安排哪个车 运哪条线
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

--售票员可以看到发车信息,哪辆车，车的核载人数 来修改增加ticket表的数据，但为了防止对发车信息表的操作，需要设置一个视图
GO
CREATE VIEW salesman_routeinfo_view
AS
SELECT ve.vLoadcount,rout.*
FROM Routeinfo rout
inner join Vehicle ve
on ve.vId = rout.vId

GO
GRANT SELECT ON salesman_routeinfo_view TO saleman_role


--管理人员 安排下一周乘务人员和司机时间表，所以应该得看到下一周已经安排的路线信息 ，司机，乘务人员，名字，哪辆车
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


--内容7

SELECT t.tPrice as 票价, t.tRemainvotes as 剩余坐位, v.vType as 车型,v.vNo as 车牌号,r.rStarttime as 发车时间,
		r.rDeparture,r.rDetination
FROM Routeinfo r
	LEFT JOIN Ticket t ON r.rId = t.rId
	INNER JOIN Vehicle v ON r.vId = v.vId
WHERE rDeparturedate = CONVERT(varchar(10), getdate(), 120)
	AND rDeparture = '武汉'
	AND rDetination = '景德镇'

--内容6

SELECT emp.eName, ve.vType, ve.vNo, rt.rNo, rt.rDeparture
	, rt.rDetination, rt.rMileague, rt.rStarttime, rt.rTimecost, rt.rDeparturedate
FROM Employee emp
	INNER JOIN Empveh ev ON emp.eId = ev.eId
	INNER JOIN Vehicle ve ON ev.vId = ve.vId
	INNER JOIN Routeinfo rt ON ve.vId = rt.vId
WHERE convert(datetime, rt.rDeparturedate) > DATEADD(wk, DATEDIFF(wk, 0, getdate()), 0)
	AND convert(datetime, rt.rDeparturedate) < DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 7, getdate())), 0)
	AND emp.eName = '刘一'

--内容8
--给予添加排它锁
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


--第一次想的
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

--内容9

--先修改剩余票，假装售了 2 张票
update Ticket set tRemainvotes = 38 where rId = 1
update Ticket set tRemainvotes = 38 where rId = 2
update Ticket set tRemainvotes = 18 where rId =6
update Ticket set tRemainvotes = 18 where rId =7

--统计运营总金额之前一览
select tic.tId,tic.rId,ve.vType as 车型,tTotalvotes as 总票数,tic.tRemainvotes as 剩余票,tic.tprice as 价格
from Ticket tic
inner join Routeinfo rt
on rt.rId = tic.rId
inner join Vehicle ve
on ve.vId = rt.vId
WHERE convert(datetime, rt.rDeparturedate) > DATEADD(wk, DATEDIFF(wk, 0, getdate()), 0)
	AND convert(datetime, rt.rDeparturedate) < DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 7, getdate())), 0)
	AND ve.vType = '大宇'

SELECT SUM(ti.tTotalvotes - ti.tRemainvotes) AS 乘客总人数
	, SUM((ti.tTotalvotes - ti.tRemainvotes) * ti.tPrice) AS 运营总金额
FROM Routeinfo rt
	INNER JOIN Ticket ti ON ti.rId = rt.rId
	INNER JOIN Vehicle ve ON rt.vId = ve.vId
WHERE convert(datetime, rt.rDeparturedate) > DATEADD(wk, DATEDIFF(wk, 0, getdate()), 0)
	AND convert(datetime, rt.rDeparturedate) < DATEADD(wk, DATEDIFF(wk, 0, DATEADD(dd, 7, getdate())), 0)
	AND ve.vType = '大宇'
GROUP BY vType


--测试sql
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
