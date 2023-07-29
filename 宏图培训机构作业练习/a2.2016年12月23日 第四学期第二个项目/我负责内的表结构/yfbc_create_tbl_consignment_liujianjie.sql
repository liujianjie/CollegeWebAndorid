
create table 刘建杰.consignment
(
       conid    varchar2(32) not null,
       DONO     varchar2(32) not null,
       pickdate date         not null,
       whid     varchar2(32) not null,
       PickID   varchar2(32) not null,
       SKUmodel varchar2(32) not null,
       packageqty number(6),
       pickqty    number(6),  
       damagedqty number(6),
       damagedreason   varchar2(100),
       totalweight     number(6),
       totalvolume     number(6)
);

comment on table 刘建杰.consignment is '发货表';
comment on column 刘建杰.consignment.conid is '主键id';
comment on column 刘建杰.consignment.DONO is '原DoNo.运单号';
comment on column 刘建杰.consignment.pickdate is '实际出库时间';
comment on column 刘建杰.consignment.whid is '仓库编码 ';
comment on column 刘建杰.consignment.PickID is '发货ID';
comment on column 刘建杰.consignment.SKUmodel is '货物型号';
comment on column 刘建杰.consignment.packageqty is '外包装数量';
comment on column 刘建杰.consignment.pickqty is '货物基本单位数量 ';
comment on column 刘建杰.consignment.damagedqty is '坏货数量';
comment on column 刘建杰.consignment.damagedreason is '坏货原因码';
comment on column 刘建杰.consignment.totalweight is '收货毛重';
comment on column 刘建杰.consignment.totalvolume is '收货体积 ';


create index ix_consignment on 刘建杰.consignment(conid);
alter table 刘建杰.consignment
      add constraint pk_consignment primary key(conid)
      using index ix_consignment    

