
--������ ����2��ȡҪ�ȵ�����1�޸����
begin tran   
select * from S (tablockx) where Sno = 40 ;
select * from S where Sno = 40  
commit tran  

--��ѯʱ
begin tran   
select * from S where Sno = 40  
commit tran  

--������
begin tran
select * from S where Sno = 40
update S set Sinfo='����2����' where Sno = 40 
commit tran



--һ�����Զ�ʧ����
begin tran  
	select * from dbo.S where Sno = 40
	update STU set Sinfo = '����2����' from S STU where Sno = 40   
commit tran  
select * from S where Sno = 40

