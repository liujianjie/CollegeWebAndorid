--�鿴��
select * from cite2
--����
create table cite2(
	cite2_no int,
	cite2_name varchar(20)
)

create table cite4(
	cite4_no int not null,
	cite4_name varchar(20)
	
)
insert into cite4 values(9,'���')
insert into cite4 values(10,'���')

--һ��ֻ��1�����
--��������������� һ����ֻ��һ�����
insert into cite2 values(1,'������')
insert into cite2 values(2,'������')

--��ָ�����������  һ����ֻ��һ�����
insert into cite2(cite2_no) values(3)

--����һ���µı�
select * into cite3 from cite2

--�������� ����
insert into cite3 select * from cite2
insert into cite3 select * from cite4
 
--����һ�����ֶ�
insert into cite3(cite2_no) select cite4_no from cite4
insert into cite3(cite2_no) select cite2_no from cite2

--�޸�ȫ������
update cite2 set cite2_name='����'

--�޸Ĳ�������
update cite2 set cite2_name='Ů��' where cite2_no=2

--ɾ������
delete from dbo.cite4 

--ɾ����������
delete from cite3 where cite2_no=1

--ɾ����������
truncate table cite4

--ɾ��Լ��
alter table ���Լ�� drop CK