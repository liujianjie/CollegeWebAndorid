create table menu_emp(
       eid integer primary key,
       ename varchar2(50)

)
alter table menu_emp add deptid integer 
insert into menu_emp values(1,'Ա��һ');
insert into menu_emp values(2,'Ա����');
insert into menu_emp values(3,'Ա����');
insert into menu_emp values(4,'Ա����');
insert into menu_emp values(5,'Ա����');
insert into menu_emp values(6,'��Աһ');
insert into menu_emp values(7,'��Ա��');
insert into menu_emp values(8,'��Ա��');
insert into menu_emp values(9,'��Ա��');
insert into menu_emp values(10,'��Ա��');

create table goods(
       gid integer primary key,
       gname varchar2(20) not null,
       price integer not null,
       counts integer not null,
       changdi varchar2(20) null
)
insert into goods values(1,'��Ʒ',30,20,'�Ϻ�');
insert into goods values(2,'���',10,30,'����');
insert into goods values(3,'�㽶',2,40,'����');


select * from  menu_emp for update
select * from  goods
select * from menu_emp where ename like 'Ա%'
