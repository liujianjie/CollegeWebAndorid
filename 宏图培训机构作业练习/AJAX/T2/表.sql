create table menu_emp(
       eid integer primary key,
       ename varchar2(50)

)
alter table menu_emp add deptid integer 
insert into menu_emp values(1,'员工一');
insert into menu_emp values(2,'员工二');
insert into menu_emp values(3,'员工三');
insert into menu_emp values(4,'员工四');
insert into menu_emp values(5,'员工五');
insert into menu_emp values(6,'成员一');
insert into menu_emp values(7,'成员二');
insert into menu_emp values(8,'成员三');
insert into menu_emp values(9,'成员四');
insert into menu_emp values(10,'成员五');

create table goods(
       gid integer primary key,
       gname varchar2(20) not null,
       price integer not null,
       counts integer not null,
       changdi varchar2(20) null
)
insert into goods values(1,'商品',30,20,'上海');
insert into goods values(2,'脐橙',10,30,'赣州');
insert into goods values(3,'香蕉',2,40,'广西');


select * from  menu_emp for update
select * from  goods
select * from menu_emp where ename like '员%'
