--����1

USE ѧ������
GO


EXEC sp_addlogin 'login1','tiger','ѧ������';

EXEC sp_addlogin 'login2','tiger','ѧ������';

EXEC sp_grantdbaccess 'login1','login1_user1'

EXEC sp_grantdbaccess 'login2','login2_user1'

--��ɫ
EXEC sp_addrole 'user1_role1'
EXEC sp_addrole 'user2_role1'

--login1_user1�û���ӽ�ɫ
EXEC sp_addrolemember 'user1_role1','login1_user1'
EXEC sp_addrolemember 'user2_role1','login2_user1'

--�����ɫȨ��
GRANT SELECT ON S To user1_role1
GRANT INSERT ON S To user1_role1--��ɫ1
GRANT SELECT ON S To user2_role1 --��ɫ2
GRANT INSERT ON S To user2_role1 --��ɫ2
GRANT UPDATE ON S To user2_role1 --��ɫ2


--������¼�û�����
SELECT * FROM S;
INSERT INTO S VALUES(41,'��С��','��Ϣ');
UPDATE S SET Sname = '��С��' WHERE Sno = 41;
SELECT * FROM S
GO


