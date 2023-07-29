select * from emp
select * from employee;
create table department(
       deptid Integer primary key,
       deptname varchar2(20),
       parentId integer
truncate table account;
delete from employee

alter table employee add constraint PK_DEPTid1 foreign key(deptid) references department(deptid)
alter table department modify parentid integer
