USE 学生管理
GO

--内容1



IF exists (select name from sysobjects   where id=object_id(N'[stud_view1]') )
DROP VIEW stud_view1

GO


--内容2

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[C]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
Alter TABLE SC DROP constraint fk_SC_2;
DROP TABLE C;
END
GO



--内容3

IF exists (SELECT * FROM sys.databases WHERE name = '学生管理')
BEGIN 
ALTER DATABASE 学生管理 SET OFFLINE;
DROP DATABASE 学生管理;
USE master;
END
GO





