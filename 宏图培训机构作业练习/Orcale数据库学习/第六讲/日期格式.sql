select * from emp
select empno,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss') from emp 
insert into emp values(7935,'jork','CLERK',7782,to_date('1983-5-3 8:12:00','yyyy-mm-dd hh24:mi:ss'),1600,0,30,'��');

select * from student1
create table student1(
       stu_id integer primary key,
       stu_name varchar2(50) not null,
       stu_age integer not null,
       birthday date not null
)
insert into student1 values(2,'С��',18,'12-5��-1997')
insert into student1 values(3,'С��',19,'24-3��-1996')
insert into student1 values(4,'С��',17,'13-6��-1995')
insert into student1 values(5,'С��',18,'12-9��-1997')
