--������ۺ���ʵ��8����1ʵ��8����2������ʵ�����⣬����ֿ�����ҳ������
IF NOT exists (select * from sys.databases where name = 'ѧ������' )
BEGIN
RESTORE DATABASE "ѧ������" FROM DISK='E://ѧ������.db' WITH REPLACE;
END
GO

USE ѧ������;
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[SC]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
DROP TABLE SC;
END
GO

IF exists (SELECT * FROM sysobjects WHERE id = object_id(N'[S]') and OBJECTPROPERTY(id, N'IsUserTable') = 1 )  
BEGIN
DROP TABLE S;
END
GO

create table S(
	Sno int not null,
	Sname varchar(50) not null,
	Sinfo varchar(50)
)
insert into S(Sno,Sname) values(40,'��');

--��ʼ������
update S set Sinfo = NULL where Sno = 40


--����1)
/*����3������
1.δ�ύ�� ������� ���в����ظ�����������
2.�ύ�� ��������� ���в����ظ�����������
3.���ظ��� ����������Ͳ����ظ�����������

*/


--����1�����н������ 1 ��ȡ���ݵ�ͬʱ������ 2 ��ȡͬһ����

begin tran
	select * from S where Sno = 40
	waitfor delay '00:00:07'
commit tran
select * from S where Sno = 40;--���ս��

begin transaction
	select * from S where Sno = 40;
commit transaction
select * from S where Sno = 40;--���ս��


--����2������ 1 ��ȡ���ݵ�ͬʱ������ 2 �޸�ͬһ���� �������⣺�����ظ���ȡ
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED --����Ϊδ�ύ��
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--���ս�� ����1�ظ���

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED--����Ϊδ�ύ��
begin transaction
	update S set Sinfo = '����2����' where Sno = 40
commit transaction


SET TRANSACTION ISOLATION LEVEL READ COMMITTED --����Ϊ�ύ��
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--���ս�� ����1�ظ�����

SET TRANSACTION ISOLATION LEVEL READ COMMITTED--����Ϊ�ύ��
begin transaction
	update S set Sinfo = '����2����' where Sno = 40
commit transaction

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--����Ϊ���ظ���
begin tran
	select * from S where Sno = 40;
	waitfor delay '00:00:07'
	select * from S where Sno = 40;
commit tran
select * from S where Sno = 40;--���ս�� ����û���ظ���

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--����Ϊ���ظ���
begin transaction
	update S set Sinfo = '����2����' where Sno = 40
commit transaction


--����3������ 1 �޸����ݵ�ͬʱ������ 2 ��ȡͬһ���� ���
DBCC USEROPTIONS 
 
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  --����Ϊδ�ύ��
begin tran  
	update S set Sinfo = '����1����' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --�ع�   
select * from S where Sno = 40;--���ս�� ����2��ȡ��û���ύ�����ݣ������

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED  --����Ϊδ�ύ��
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --����Ϊ�ύ��
begin tran  
	update S set Sinfo = '����1����' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --�ع�   
select * from S where Sno = 40;--���ս�� û�����

SET TRANSACTION ISOLATION LEVEL READ COMMITTED  --����Ϊ�ύ��
begin tran  
    select * from dbo.S where Sno = 40  
commit tran  

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--����Ϊ���ظ���
begin tran  
	update S set Sinfo = '����1����' where Sno = 40
    waitfor delay '00:00:07'  
rollback tran --�ع�   
select * from S where Sno = 40;--���ս��  û�����
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ--����Ϊ���ظ���
begin transaction
	select * from dbo.S where Sno = 40  
commit transaction


--����4������ 1 �޸����ݵ�ͬʱ������ 2 �޸�ͬһ����
begin tran  
    select * from dbo.S(nolock) where Sno = 40  
	waitfor delay '00:00:05' 
	update STU set Sinfo = '����1����' from S STU(nolock) where Sno = 40   
commit tran  
  
begin tran  
    select * from S(nolock) where Sno = 40   
    waitfor delay '00:00:05'
    update STU set Sinfo = '����2����' from S STU(nolock) where Sno = 40   
commit tran  

select * from S where Sno = 40;--���ս�� ���� ��ʧ���Ǹ�����




