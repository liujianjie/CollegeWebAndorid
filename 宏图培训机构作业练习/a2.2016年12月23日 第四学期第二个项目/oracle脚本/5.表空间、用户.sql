--1.������ռ�
create tablespace ts_ora
datafile 'D:\SOFTW\database\oracle\product\11.2.0\ts_ora.dbf'
size 20M autoextend on;
--�޸ı�ռ�
alter tablespace ts_ora
add datafile 'D:\ts_ora.dbf' size 20M;
--ɾ����ռ�
drop tablespace ts_ora;
--2.�����û�
create user oratest 
     identified by 123456--��������
     default tablespace ts_ora--ָ����ռ�
     temporary Tablespace TEMP;--ָ����ʱ��ռ�
--�޸��û�
alter user oratest identified by 123;--�޸����� 
alter user oratest account unlock;--unlock  ����/����
--3.�û���Ȩ
grant create session,create table  to oratest;
grant resource,connect to oratest;
--4.����Ȩ��
revoke resource,connect from oratest;
     
--5.ɾ���û�
drop user oratest;
