--������ϰ

begin tran
declare @a int
set @a=0
	insert into student values('20080206','СС','200802','F',66)
	insert into student values('20080206','���','200802','F','a')
set @a=@a+@@error-->=21����д���
if @a>0
begin
	print 'ִ��ʧ��'
	rollback--�ع�
end
else
begin
	print 'ִ�гɹ�'
end
commit tran

--�������
--�������������:�й�����������˵ĵ��� ����������й��˵Ŀ��� ���Բ��˷�
SET deadlock_priority 
SET lock_timeout 

--���ø��뼶��:
SET transaction isolation level SERIALIZABLE

--���д���
select * from sysmessages order by error