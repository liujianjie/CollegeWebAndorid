use ��ϰ

select * from ���Լ��
 
--ͨ�����ѯ
--1.ģ����ѯ %
select * from ���Լ�� where shu_name like '%��%' 

--2._����һ���ַ�
select * from ���Լ�� where shu_name like '��_'

--3.[]��Χ����
select * from ���Լ�� where shu_id like '3243[1-3]'

--4.^ ȡ������ ֻ�ʺ��ڷ�Χ��
select * from ���Լ�� where shu_id like '245[^3-7]'

--5.in ĳ���ֶε�ֵ��ʲô��Χ
select * from ���Լ�� where shu_no in(1,11,3,5,6,7,2)

--6.not in����ָ����ֵ��
select * from ���Լ�� where shu_no not in(1,3)

--7.����֮��between
select * from ���Լ�� where shu_no between 1 and 9

--8.
select * from ���Լ�� where shu_no not between 1 and 9