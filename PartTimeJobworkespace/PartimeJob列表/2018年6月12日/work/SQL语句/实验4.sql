/*  
  ���������豸  
    ����1���豸����  
    ����2���豸����  
    ����3�������ļ�������·��  
      
    Test1.bak�Ǳ���֮����ļ���  
*/  
  
EXEC sp_addumpdevice 'disk', 'Equipment', 'E:\dump\Equipment.bak';   


IF exists (select * from sys.databases where name = 'ѧ������' and state_desc = 'ONLINE' )
BEGIN
BACKUP DATABASE ѧ������ to disk = 'E://ѧ������.db' WITH FORMAT/*with format ���ڱ����豸���е����ݿⱸ���ļ���������*/
END
GO


IF exists (select * from sys.databases where name = 'ѧ������' and state_desc = 'ONLINE' )
BEGIN 
ALTER DATABASE ѧ������ SET OFFLINE;
USE MASTER;
DROP DATABASE ѧ������;
END 
GO



IF NOT exists (select * from sys.databases where name = 'ѧ������' )
BEGIN
RESTORE DATABASE "ѧ������" FROM DISK='E://ѧ������.db' WITH REPLACE;
END
GO

USE ѧ������;
GO

SELECT * FROM  S;
GO