create table yfbc.shelf
(
       sheid    varchar2(32) not null,
       shename  varchar2(50) not null,
       whid     varchar2(32) not null,
       shestate number(1) not null --0为已满 1为未满
);

comment on table yfbc.shelf is '货架表';
comment on column yfbc.shelf.sheid is '主键id';
comment on column yfbc.shelf.shename is '货架名称';
comment on column yfbc.shelf.whid is '仓库id 多对1';
comment on column yfbc.shelf.shestate is '状态 0为未满 1为已满 ';

create index ix_shelf on yfbc.shelf(sheid);
alter table yfbc.shelf
      add constraint pk_shelf primary key(sheid)
      using index ix_shelf    

