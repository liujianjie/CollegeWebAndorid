--ɾ��ѧ�������Ϣʱ��ͬʱɾ�����ѧ���ĳɼ�����Ϣ
use task
alter trigger d_dltstu
on student for delete
as
--ɾ�����ݵ����ݱ�������ʱ���deleted����
declare @stuno varchar(8)
select @stuno=stuno from deleted
delete from studentcourse where stuno=@stuno

delete from student where stuno='20080102'


--����һ��ѧ����Ϣʱ������һ���ɷ� id  stuno xf--inserted��������ִ��insert��update����Ҫ����в���������С�--�½�ѧ�ѱ�create table xuefei(	id int primary key identity(1,1),	stuno int not null,	xf float null)alter table xuefei alter column stuno varchar(8) not nullcreate trigger x_addstuon student after insert as--�������ݱ�����inserted��ʱ����declare @stuno varchar(8)select @stuno=stuno from insertedinsert into xuefei values(@stuno,2000)insert into student values('20008210','���Դ���','200802','m',20)--�������޸�ѧ���Ա�update�Ĵ����� ���ò���ֵ���ж� create trigger x_updstuon student for updateasif update(sex)begin	print '���ܱ��޸�'	rollback tranendupdate student set sex='m' where stuno='2008209'--�޸Ĵ�����alter--ɾ��������drop trigger x_updstu--����/����disable trigger d_dltstu on studentenable trigger d_dltstu on student--���ܴ����� with encrytion���ڱ�����alter trigger d_dltstu
on student with encryption for delete
as
--ɾ�����ݵ����ݱ�������ʱ���deleted����
declare @stuno varchar(8)
select @stuno=stuno from deleted
delete from studentcourse where stuno=@stuno


alter trigger d_dltstu
on student for delete
with encryption
as
--ɾ�����ݵ����ݱ�������ʱ���deleted����
declare @stuno varchar(8)
select @stuno=stuno from deleted
delete from studentcourse where stuno=@stuno


--�ж�ѧ�ѽ���״̬ --��ѧ������Ӷ����ֶΣ�ѧ�ѽ���״̬ statu���ѽ��� δ���壩 Ӧ��ѧ���ܶ�alter table student add statu varchar(10)alter table student add total floatcreate trigger x_jtotalon xuefei for update,insertasdeclare @stuno varchar(8)declare @yjxf floatdeclare @xyxf floatselect @stuno=stuno from insertedselect @yjxf=sum(xf) from xuefei where stuno=@stunoselect @xyxf=total from student where stuno=@stunoif @yjxf<@xyxfbegin	update student set statu='δ����' where stuno=@stunoendelsebegin 	update student set statu='�ѽ���' where stuno=@stunoendinsert into xuefei values('20008209',10000)insert into xuefei values('20008210',70000)