insert into informations values(1,'年后','那你呢',1,1,to_date('2016-7-3','yyyy-mm-dd'),to_date('2016-7-3','yyyy-mm-dd'))
insert into informations values(2,'放假了','各位快放假了 ，大家有什么想说的吗',1,1,to_date('2016-7-3','yyyy-mm-dd'),to_date('2016-7-3','yyyy-mm-dd'))

insert into replies values(1,1,'挺好的',to_date('2016-7-3','yyyy-mm-dd'))
select * from informations
select * from replies
create sequence replies_seq
increment by 1
start with 2

select replies_seq.nextval from dual

select * from replies for update
