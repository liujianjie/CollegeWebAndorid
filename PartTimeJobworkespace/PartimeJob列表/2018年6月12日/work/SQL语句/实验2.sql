BEGIN
create database ѧ���������ݿ�
on primary(
	name = 'ѧ���������ݿ�',
	filename = 'E:\ѧ���������ݿ�_log.mdf',
	size = 5mb,
	maxsize = 100mb,
	filegrowth = 1mb
	
)
log on(
	name = 'ѧ���������ݿ�_log', 
	filename = 'E:\ѧ���������ݿ�_log.ldf',                     
	size = 2mb,                         
	maxsize = 100mb,          
	filegrowth = 10%           

)
END


USE  ѧ���������ݿ�
GO

IF exists (select * from sys.databases where name = 'ѧ���������ݿ�' )
EXEC sp_renamedb 'ѧ���������ݿ�','ѧ������'


