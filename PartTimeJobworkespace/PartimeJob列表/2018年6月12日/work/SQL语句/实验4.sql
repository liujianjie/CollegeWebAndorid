/*  
  创建备份设备  
    参数1：设备类型  
    参数2：设备名称  
    参数3；备份文件的物理路径  
      
    Test1.bak是备份之后的文件名  
*/  
  
EXEC sp_addumpdevice 'disk', 'Equipment', 'E:\dump\Equipment.bak';   


IF exists (select * from sys.databases where name = '学生管理' and state_desc = 'ONLINE' )
BEGIN
BACKUP DATABASE 学生管理 to disk = 'E://学生管理.db' WITH FORMAT/*with format 是在备份设备已有的数据库备份文件叠加内容*/
END
GO


IF exists (select * from sys.databases where name = '学生管理' and state_desc = 'ONLINE' )
BEGIN 
ALTER DATABASE 学生管理 SET OFFLINE;
USE MASTER;
DROP DATABASE 学生管理;
END 
GO



IF NOT exists (select * from sys.databases where name = '学生管理' )
BEGIN
RESTORE DATABASE "学生管理" FROM DISK='E://学生管理.db' WITH REPLACE;
END
GO

USE 学生管理;
GO

SELECT * FROM  S;
GO