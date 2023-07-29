drop table receiving
create table yfbc.receiving
(
       reid         varchar2(32) not null,
       inid         varchar2(32) not null,
       receivedate date not null,
       whid        varchar2(32) not null,
       productname     varchar2(50) not null,
       sku         varchar2(32) not null,
       purchaseqty number(6) not null,
       unit        number(1) not null,
       shortqty    number(1),
       partflag    number(1) not null,--0部分到货，1全部到货
       putstate    number(1) not null --0为为摆货   1为已摆货
);
comment on table yfbc.receiving is '收获表';
comment on column yfbc.receiving.reid is '主键id';
comment on column yfbc.receiving.inid is '入库计划单的主键吧';
comment on column yfbc.receiving.receivedate is '实际入库时间';
comment on column yfbc.receiving.whid is '仓库编码';
comment on column yfbc.receiving.productname is '货物名称';
comment on column yfbc.receiving.sku is '货物类型';
comment on column yfbc.receiving.purchaseqty is '数量';
comment on column yfbc.receiving.unit is '单位';
comment on column yfbc.receiving.shortqty is '缺货数量';
comment on column yfbc.receiving.partflag is '0：部分到货 1：全部到货';
comment on column yfbc.receiving.putstate is '0为为摆货   1为已摆货';


create index ix_receiving on yfbc.receiving(reid);
alter table yfbc.receiving
      add constraint pk_receiving primary key(reid)
      using index ix_receiving  
     
--drop table receiving
delete r
delete put_away
select * from rack for update
select * from put_away for update
select * from warehouse
select * from receiving where to_date('2017-1-13','yyyy-mm/dd')<receivedate and receivedate<to_date('2018-6-9','yyyy-mm-dd') for update

select * from in_storage for update

select * from (select rownum r,i.* from receiving i where rownum <=(10) order by receivedate desc)where r>(0)

select * from users
select * from permissions
