
USE ѧ������
GO
--Ĭ��ֵ
update S set Sinfo = NULL where Sno = 40


--����1�����н������ 1 ��ȡ���ݵ�ͬʱ������ 2 ��ȡͬһ����

begin tran
	select * from S where Sno = 40
commit tran



--����2������ 1 ��ȡ���ݵ�ͬʱ������ 2 �޸�ͬһ����
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED--����Ϊδ�ύ��
begin transaction
	update S set Sinfo = '����2����' where Sno = 40
commit transaction

SET TRANSACTION ISOLATION LEVEL READ COMMITTED--����Ϊ�ύ��
begin transaction
	update S set Sinfo = '����2����' where Sno = 40
commit transaction


SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--����Ϊ���ظ���
begin transaction
	update S set Sinfo = '����2����' where Sno = 40
commit transaction


--����3������ 1 �޸����ݵ�ͬʱ������ 2 ��ȡͬһ����
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  --����Ϊδ�ύ��
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --����Ϊ�ύ��
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  


SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--����Ϊ���ظ���
begin transaction
	select * from dbo.S where Sno = 40  
commit transaction



--����4������ 1 �޸����ݵ�ͬʱ������ 2 �޸�ͬһ����
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '����2����' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--���ս�� ��������1 ��ʧ�� ����2��������1������

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
begin tran  
	 waitfor delay '00:00:05'
    select * from S where Sno = 40   
    update STU set Sinfo = '����2����' from S STU where Sno = 40   
commit tran  
select * from S where Sno = 40;--���ս�� ��������1 ��ʧ�� ����2��������1������

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED --����Ϊδ�ύ��
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '����2����' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--���ս�� ��������1 ��ʧ�� ����2��������1������

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --����Ϊ�ύ��
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '����2����' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--���ս�� ��������1 ��ʧ�� ����2��������1������

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--����Ϊ���ظ���
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '����2����' from S STU(nolock) where Sno = 40   
commit tran  
select * from S where Sno = 40;--���ս�� ��������1 ��ʧ�� ����2��������1������



--chagne
--һ��


begin tran   
select * from S where Sno = 40  
commit tran  