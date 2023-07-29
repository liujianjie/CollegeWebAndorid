--1.同义词的作用：为对象取一个别名，其他用户访问该对象可以直接使用同义词，不需要属主
--创建同义词
create public synonym emp for scott.emp;
--删除同义词
drop public synonym emp;
--2.序列：一个可自增的数据库对象
create sequence seq_ora
start with 1
increment by 1
maxvalue 2000
minvalue 1
nocycle
cache 30;
--序列的使用
select seq_ora.nextval from dual;
select seq_ora.currval from dual;

create table abc(
pk_serial number(9) primary key,
name varchar2(10)
);

insert into abc(pk_serial,name)
values(seq_ora.nextval,'测试');
commit;
--Oracle表的主键用varchar2(32),全球唯一编码
select sys_guid() from dual;