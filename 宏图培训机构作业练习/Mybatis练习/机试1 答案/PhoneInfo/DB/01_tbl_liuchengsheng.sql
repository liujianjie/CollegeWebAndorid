create table informations(
id                  number(10),
title               varchar2(30) not null,
content             varchar2(500) not null,
replyCount          number(10) not null,
viewCount           number(10) not null,
reportTime          date not null,
lastposttime        date not null
);
comment on table scott.informations is '咨询表';
comment on column scott.informations.id is '主键';
comment on column scott.informations.title is '标题';
comment on column scott.informations.content is '内容';
comment on column scott.informations.replyCount is '回复次数';
comment on column scott.informations.viewCount is '查看次数';
comment on column scott.informations.reportTime is '发表时间';
comment on column scott.informations.lastposttime is '回复时间';
--创建主键
create unique index un_ix_informations on scott.informations(id);
alter table informations 
      add constraint pk_informations primary key(id)
      using index un_ix_informations;