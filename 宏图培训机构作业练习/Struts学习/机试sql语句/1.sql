create table jsemp(
       emp_id integer primary key,
       emp_name varchar2(30) not null,
       emp_sex varchar2(10) not null,
       emp_salary float not null,
       join_date date not null
      
)
insert into jsemp values(1,'jork','男',7000,'21-7月-2016');
insert into jsemp values(2,'mark','男',7200,'11-11月-2016');
insert into jsemp values(3,'mary','女',7000,'20-2月-2016');
insert into jsemp values(4,'join','男',6000,'21-6月-2016');
insert into jsemp values(5,'rows','女',7000,'12-12月-2016');
select * from jsemp for update

insert into jsemp values(6,'rows','女',7000,to_date('1998-12-19','yyyy-mm-dd'));
