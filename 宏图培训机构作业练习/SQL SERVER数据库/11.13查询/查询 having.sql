use ��ϰ

--having �÷�

select shu_age,sum(shu_no)������,avg(shu_age)����ƽ���� from ���Լ�� group by shu_age having sum(shu_no)>3 order by ����ƽ���� desc

--ȡ����

select a.shu_name,a.shu_age,b.cite_no from ���Լ�� a,cite b where a.shu_no=b.cite_no--һһ��Ӧ ���������ȡ