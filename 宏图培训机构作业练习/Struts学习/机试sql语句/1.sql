create table jsemp(
       emp_id integer primary key,
       emp_name varchar2(30) not null,
       emp_sex varchar2(10) not null,
       emp_salary float not null,
       join_date date not null
      
)
insert into jsemp values(1,'jork','��',7000,'21-7��-2016');
insert into jsemp values(2,'mark','��',7200,'11-11��-2016');
insert into jsemp values(3,'mary','Ů',7000,'20-2��-2016');
insert into jsemp values(4,'join','��',6000,'21-6��-2016');
insert into jsemp values(5,'rows','Ů',7000,'12-12��-2016');
select * from jsemp for update

insert into jsemp values(6,'rows','Ů',7000,to_date('1998-12-19','yyyy-mm-dd'));
