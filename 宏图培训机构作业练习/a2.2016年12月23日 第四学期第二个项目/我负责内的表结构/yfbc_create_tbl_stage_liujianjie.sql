--stage区
--业务：越库 如果为0则是普通收货要摆货
--          如果为1则是越库收货要拣货出库，不用摆货
create table yfbc.stage
(
       stgid varchar2(32) not null,
       reid  varchar2(32) not null,
       SKUmodel varchar2(32) not null,
       packageqty  number(6) not null,
       receiveqty   number(6) not null,
       stgstate number(1) not null
);

comment on table yfbc.stage is 'stage区';
comment on column yfbc.stage.stgid is '主键id';
comment on column yfbc.stage.reid is '收货id';
comment on column yfbc.stage.SKUmodel is '货物类型';
comment on column yfbc.stage.packageqty is '外包装数量';
comment on column yfbc.stage.receiveqty is '货物基本单位数量';
comment on column yfbc.stage.stgstate is '是否越库 0:未越库，1为越库';

create index ix_stage on yfbc.stage(stgid);
alter table yfbc.stage
      add constraint pk_stage primary key(stgid)
      using index ix_stage  
     
