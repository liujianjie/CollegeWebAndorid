--内容1

USE 学生管理
GO


EXEC sp_addlogin 'login1','tiger','学生管理';

EXEC sp_addlogin 'login2','tiger','学生管理';

EXEC sp_grantdbaccess 'login1','login1_user1'

EXEC sp_grantdbaccess 'login2','login2_user1'

--角色
EXEC sp_addrole 'user1_role1'
EXEC sp_addrole 'user2_role1'

--login1_user1用户添加角色
EXEC sp_addrolemember 'user1_role1','login1_user1'
EXEC sp_addrolemember 'user2_role1','login2_user1'

--授予角色权限
GRANT SELECT ON S To user1_role1
GRANT INSERT ON S To user1_role1--角色1
GRANT SELECT ON S To user2_role1 --角色2
GRANT INSERT ON S To user2_role1 --角色2
GRANT UPDATE ON S To user2_role1 --角色2


--两个登录用户操作
SELECT * FROM S;
INSERT INTO S VALUES(41,'周小五','信息');
UPDATE S SET Sname = '燕小六' WHERE Sno = 41;
SELECT * FROM S
GO


