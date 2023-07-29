--仓库表
create table 刘建杰.warehouse
(
       whid     varchar2(32) not null,
       whiname  varchar2(100) not null,
       userid   varchar2(32) not null,
       whistate   number(1)    not null --0正在使用 1 停用

);
comment on table 刘建杰.warehouse is '仓库表';
comment on column 刘建杰.warehouse.whid is '主键id';
comment on column 刘建杰.warehouse.whiname is '主键名称';
comment on column 刘建杰.warehouse.userid is '用户id';
comment on column 刘建杰.warehouse.whistate is '状态 0停用 1 正在使用 ';

create index ix_warehouse on 刘建杰.warehouse(whid);
alter table 刘建杰.warehouse
      add constraint pk_warehouse primary key(whid)
      using index ix_warehouse    


