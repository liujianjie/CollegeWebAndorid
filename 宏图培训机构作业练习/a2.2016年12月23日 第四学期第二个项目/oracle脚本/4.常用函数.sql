--1.�ַ�����
select upper('oracle'),lower('JAVA') from dual;
--����׷��,���Ȳ��������£����󲹳��ַ�
select lpad(10,3,0)  from dual;
select rpad(10,4,'#') from dual;

--2.���ֺ���
select round(3.15,1) from dual;--��������
select trunc(3.14159,3) from  dual;--����������

--3.���ں���
select sysdate from dual;--����ʱ��
select sysdate+1 from dual;--����
select sysdate-1 from dual;--����
select add_months(sysdate,1) from  dual;--��һ���µĽ���
select next_day(sysdate,7) from dual;--��һ�����ڼ��������죺1-����������7
select last_day(sysdate) from dual; --ÿ�����һ��
select trunc(sysdate) from dual;--�������ڣ��賿0�㣩
select trunc(sysdate,'yyyy') from dual;--�����һ��(0��)
select trunc(sysdate,'MM') from dual;--���µ�һ��(0��)

select trunc(sysdate)+((30/60+7)/60+18)/24 from dual;--���� 18:07:30
--4.ת������
select to_date('2008-08-08 08:08:08','yyyy-MM-dd hh24:mi:ss') from dual;--�ַ���ת����
select to_char(sysdate,'yyyy-MM-dd hh24:mi:ss') from dual;--����ת�ַ���
--��ʽ������
select to_char(8758768767868.9878,'999,999,999,999,990.00') from dual;
select to_number('7687')+1 from dual;--�ַ���ת����
--5.��������
select nvl('me','���ǿյ�') from dual;--�����ȡ�����Ǹ�����
select nvl2('me','���ǲ��յ�','���ǿյ�') from dual;--�����Ϊ��ȡ��һ������������ȥ���һ������
select decode('xxxx','a','����a','b','null','else') from dual;--��һ��������ż����Ƚϣ����ƥ�䣬ȡ��������ֵ