--1.创建表空间
create tablespace ts_ora
datafile 'D:\SOFTW\database\oracle\product\11.2.0\ts_ora.dbf'
size 20M autoextend on;
--修改表空间
alter tablespace ts_ora
add datafile 'D:\ts_ora.dbf' size 20M;
--删除表空间
drop tablespace ts_ora;
--2.创建用户
create user oratest 
     identified by 123456--设置密码
     default tablespace ts_ora--指定表空间
     temporary Tablespace TEMP;--指定临时表空间
--修改用户
alter user oratest identified by 123;--修改密码 
alter user oratest account unlock;--unlock  解锁/锁定
--3.用户授权
grant create session,create table  to oratest;
grant resource,connect to oratest;
--4.回收权限
revoke resource,connect from oratest;
     
--5.删除用户
drop user oratest;
