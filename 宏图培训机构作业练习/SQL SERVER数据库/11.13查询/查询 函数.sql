use ��ϰ

select * from ���Լ��

--��ѯ�����
select * from cite2,cite3

--ȡ����
select a.*,b.cite_name from ���Լ�� a,cite b where a.shu_no=b.cite_no 
select top 5 ���Լ��.*,cite.cite_name from ���Լ��,cite where ���Լ��.shu_no=cite.cite_no --��ȡ����

--top��ѯ
select top 5 * from ���Լ�� where shu_no in(1,4,5,6,7,7,7,4)
--top�ٷֱȲ�ѯ
select top 50 percent * from ���Լ��

--��ȡ���� �����ͻ�ı�
select shu_no ѧ��,shu_name ���� from ���Լ��

--�Ӻ��÷�
select (shu_no+shu_id)�Ӻ��÷� from ���Լ��

--ȥ���ظ��ļ�¼
select distinct shu_age from ���Լ��

--���� ���� �� ����
select * from ���Լ�� order by shu_age asc --���� asc�ɲ���
select * from ���Լ�� order by shu_age desc--���� desc 

--�ۺϺ���
--sum��ͺ���
select sum(shu_age)������ from ���Լ��
select sum(shu_age/5+shu_id/5)���� from ���Լ��

--ƽ������ avg
select avg(shu_age)ƽ������ from ���Լ��

--max���ֵ
select max(shu_age)���ֵ from ���Լ��
select max(shu_id)���ֵ from ���Լ��--id ��varchar��������������ֵû��ʲô����

--��Сֵmin
select min(shu_age)��Сֵ from ���Լ��
select min(shu_id)��Сֵ from ���Լ��

--���� count(*)
select count(shu_age)���� from ���Լ��
select count(*)���� from ���Լ��

--����group by
select shu_age,count(shu_age) from ���Լ�� group by shu_age
select shu_id,count(shu_id) from ���Լ�� group by shu_id

--is nullֵ��is not null��Ϊ��ֵ
select * from ���Լ�� where shu_age is null
select * from ���Լ�� where shu_age is not null

--����
create table allany(
	allany_no int primary key,
	allany_name varchar(20)

)
create table allany2(
	allany2_no int foreign key references allany(allany_no),
	allany2_name varchar(20) not null,
	allany2_age tinyint not null

)--������
--all ȫ�� any ����
--all ȫ��
select * from allany2 where allany2_no=1 and allany2_age >  all(select allany2_age from allany2 where allany2_no=2)

--any ����
select * from allany2 where allany2_no=1 and allany2_age >  any(select allany2_age from allany2 where allany2_no=2)
