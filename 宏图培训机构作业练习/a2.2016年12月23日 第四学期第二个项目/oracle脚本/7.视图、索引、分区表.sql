--A.视图:表数据的投影，普通视图只能用于查询，
--1.针对特殊业务，会对数据量过大的表，根据条件选取一部分数据创建视图
--2.多系统开发，涉及到关联系统需要己方系统提供数据，那么一般不会将表直接授权给关联系统，通常会以视图形式提供数据
create view vw_emp as
 select * from emp;

--B.索引
--作用：方便数据的快速检索(SELECT),唯一索引具有约束作用
create index ix_emp_deptno on emp(deptno);
--C.分区表
-- less than: DATE则是小于，数值为小于等于
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
            values(sys_guid(),'分区1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区1',to_date('2013-03-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区2',to_date('2013-04-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区2',to_date('2013-05-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区2',to_date('2013-07-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区3',to_date('2013-08-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区3',to_date('2013-09-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区4',to_date('2013-11-21','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区4',to_date('2013-12-02','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区4',to_date('2013-10-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区',to_date('2016-03-01','yyyy-MM-dd')); 
insert into sales1(pk_serial,sname,sales_date)
            values(sys_guid(),'分区',to_date('2015-03-01','yyyy-MM-dd')); 
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
            values(sys_guid(),'分区1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区1',to_date('2013-01-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区1',to_date('2013-03-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区2',to_date('2013-04-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区2',to_date('2013-05-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区2',to_date('2013-07-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区3',to_date('2013-08-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区3',to_date('2013-09-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区4',to_date('2013-11-21','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区4',to_date('2013-12-02','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区4',to_date('2013-10-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区',to_date('2016-03-01','yyyy-MM-dd')); 
insert into sales2(pk_serial,sname,sales_date)
            values(sys_guid(),'分区',to_date('2015-03-01','yyyy-MM-dd')); 
            commit;
select * from user_tab_partitions a where a.table_name=upper('sales2');            

select * from sales2 partition(P1);
select * from sales2 partition(SYS_P21);
select * from sales2 partition(SYS_P22);
select * from sales2 partition(SYS_P23);
select * from sales2 partition(SYS_P24);
select * from sales2 partition(SYS_P25);
select * from sales2 partition(SYS_P26);