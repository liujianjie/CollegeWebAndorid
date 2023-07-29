--A.��ͼ:�����ݵ�ͶӰ����ͨ��ͼֻ�����ڲ�ѯ��
--1.�������ҵ�񣬻������������ı���������ѡȡһ�������ݴ�����ͼ
--2.��ϵͳ�������漰������ϵͳ��Ҫ����ϵͳ�ṩ���ݣ���ôһ�㲻�Ὣ��ֱ����Ȩ������ϵͳ��ͨ��������ͼ��ʽ�ṩ����
create view vw_emp as
 select * from emp;

--B.����
--���ã��������ݵĿ��ټ���(SELECT),Ψһ��������Լ������
create index ix_emp_deptno on emp(deptno);
--C.������
-- less than: DATE����С�ڣ���ֵΪС�ڵ���
create table sales1(
pk_serial    varchar2(32),
sname        varchar2(30),
sales_date   date
)
partition by range(sales_date)(
partition P1 values less than (to_date('2013-03-01','yyyy-MM-dd')),
partition P2 values less than (to_date('2013-07-01','yyyy-MM-dd')),
partition P3 values less than (to_date('2013-10-01','yyyy-MM-dd')),
partition P4 values less than (to_date('2014-01-01','yyyy-MM-dd')),
partition P5 values less than(maxvalue)
);
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����1',to_date('2013-03-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����2',to_date('2013-04-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����2',to_date('2013-05-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����2',to_date('2013-07-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����3',to_date('2013-08-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����3',to_date('2013-09-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����4',to_date('2013-11-21','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����4',to_date('2013-12-02','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����4',to_date('2013-10-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����',to_date('2016-03-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'����',to_date('2015-03-01','yyyy-MM-dd')); 
            commit;

select * from sales1 partition(P1);            
select * from sales1 partition(P2);    
select * from sales1 partition(P3);    
select * from sales1 partition(P4);    
select * from sales1 partition(P5);

create table sales2(
pk_serial    varchar2(32),
sname        varchar2(30),
sales_date   date
)
partition by range(sales_date)
  interval(numtoyminterval(3,'MONTH'))
  (partition P1 values less than (to_date('2013-03-01','yyyy-MM-dd'))
);    
 
 insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����1',to_date('2013-03-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����2',to_date('2013-04-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����2',to_date('2013-05-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����2',to_date('2013-07-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����3',to_date('2013-08-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����3',to_date('2013-09-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����4',to_date('2013-11-21','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����4',to_date('2013-12-02','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����4',to_date('2013-10-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����',to_date('2016-03-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'����',to_date('2015-03-01','yyyy-MM-dd')); 
            commit;
select * from user_tab_partitions a where a.table_name=upper('sales2');            

select * from sales2 partition(P1);
select * from sales2 partition(SYS_P21);
select * from sales2 partition(SYS_P22);
select * from sales2 partition(SYS_P23);
select * from sales2 partition(SYS_P24);
select * from sales2 partition(SYS_P25);
select * from sales2 partition(SYS_P26);