create table qqfrid(
  id integer,
  myqq varchar2(20) not null,
  friqq varchar2(20) not null,
  groupname varchar2(20) not null,
  constraint PK_QQfrid primary key(id)

)
select * from qqfrid
insert into qqfrid values(seq_review_qq.nextval,'6208' ,'7068' ,'家人');
insert into qqfrid values(seq_review_qq.nextval,'6208' ,'2023' ,'家人');
insert into qqfrid values(seq_review_qq.nextval,'6208' ,'5654' ,'同学');
insert into qqfrid values(seq_review_qq.nextval,'6208' ,'6570' ,'同学');
insert into qqfrid values(seq_review_qq.nextval,'6208' ,'8644' ,'黑名单');
insert into qqfrid values(seq_review_qq.nextval,'6208' ,'10455' ,'黑名单');
