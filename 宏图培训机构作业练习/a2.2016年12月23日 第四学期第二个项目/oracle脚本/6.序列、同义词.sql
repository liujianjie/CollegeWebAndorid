--1.ͬ��ʵ����ã�Ϊ����ȡһ�������������û����ʸö������ֱ��ʹ��ͬ��ʣ�����Ҫ����
--����ͬ���
create public synonym emp for scott.emp;
--ɾ��ͬ���
drop public synonym emp;
--2.���У�һ�������������ݿ����
create sequence seq_ora
start with 1
increment by 1
maxvalue 2000
minvalue 1
nocycle
cache 30;
--���е�ʹ��
select seq_ora.nextval from dual;
select seq_ora.currval from dual;

create table abc(
pk_serial number(9) primary key,
name varchar2(10)
);

insert into abc(pk_serial,name)
values(seq_ora.nextval,'����');
commit;
--Oracle���������varchar2(32),ȫ��Ψһ����
select sys_guid() from dual;