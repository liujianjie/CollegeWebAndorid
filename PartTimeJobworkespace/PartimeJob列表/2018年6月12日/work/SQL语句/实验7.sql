USE ѧ������
GO

--����1



IF exists (select name from sysobjects   where id=object_id(N'[stud_view1]') )
DROP VIEW stud_view1

GO


--����2

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[C]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
Alter TABLE SC DROP constraint fk_SC_2;
DROP TABLE C;
END
GO



--����3

IF exists (SELECT * FROM sys.databases WHERE name = 'ѧ������')
BEGIN 
ALTER DATABASE ѧ������ SET OFFLINE;
DROP DATABASE ѧ������;
USE master;
END
GO





