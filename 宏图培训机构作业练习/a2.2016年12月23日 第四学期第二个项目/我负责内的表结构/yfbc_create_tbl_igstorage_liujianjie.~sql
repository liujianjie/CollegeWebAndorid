create table yfbc.in_storage
(
       inid       varchar2(32) not null,
       productname     varchar2(50) not null,
       sku      varchar2(50) not null,
       purchaseqty number(6),
       unit        number(1),
       supplier    varchar2(50),
       supplierno  varchar2(11),
       receivename varchar2(50),
       receiveno   varchar2(11),
       arrivaldate date,
       whid        varchar2(32),
       inno        varchar2(32),
       instate     number(1)
);
comment on table yfbc.in_storage is '入库计划';
comment on column yfbc.in_storage.inid is '主键id';
comment on column yfbc.in_storage.productname is '产品名称';
comment on column yfbc.in_storage.sku is '产品类型';
comment on column yfbc.in_storage.purchaseqty is '产品数量';
comment on column yfbc.in_storage.unit is '单位（件、千克）';
comment on column yfbc.in_storage.supplier is '供应商';
comment on column yfbc.in_storage.supplierno is '供应商电话';
comment on column yfbc.in_storage.receivename is '收货人';
comment on column yfbc.in_storage.receiveno is '收货人号码';
comment on column yfbc.in_storage.arrivaldate is '计划入库时间';
comment on column yfbc.in_storage.whid is '仓库id';
comment on column yfbc.in_storage.inno is '订单 ';
comment on column yfbc.in_storage.instate is '状态 0为未收到货，1为收到了货';

create index ix_in_storage on yfbc.in_storage(inid);
alter table yfbc.in_storage
      add constraint pk_in_storage primary key(inid)
      using index ix_in_storage    
      
    

--drop table in_storage
select * from in_storage for update
select * from rack
select * from goodtype

