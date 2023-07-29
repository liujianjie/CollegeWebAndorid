BEGIN
create database 学生管理数据库
on primary(
	name = '学生管理数据库',
	filename = 'E:\学生管理数据库_log.mdf',
	size = 5mb,
	maxsize = 100mb,
	filegrowth = 1mb
	
)
log on(
	name = '学生管理数据库_log', 
	filename = 'E:\学生管理数据库_log.ldf',                     
	size = 2mb,                         
	maxsize = 100mb,          
	filegrowth = 10%           

)
END


USE  学生管理数据库
GO

IF exists (select * from sys.databases where name = '学生管理数据库' )
EXEC sp_renamedb '学生管理数据库','学生管理'


