create table a
(
       --a_id varchar2(32) primary key,
       a_id number(3) primary key,
       a_name varchar2(30) not null
)
drop table b
delete  a

create table b
(
       --b_id varchar2(32) primary key,
       b_id number(3) primary key,
       a_id number(3) not null
)
alter table b add constraint fk_tableb_a_id foreign key (a_id) reference tablea(a_id)

insert into a values(sys_guid(),'小明');

insert into a values(1,'小明');
insert into a values(2,'小红');

insert into b values(1,1);
insert into b values(2,2);
