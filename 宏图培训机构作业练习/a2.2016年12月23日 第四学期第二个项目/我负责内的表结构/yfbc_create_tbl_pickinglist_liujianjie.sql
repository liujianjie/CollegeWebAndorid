--拣货单列表 
--业务需求：  可选择多张计划出库单来创建拣货单，也可选择单个出库计划单。
--            所以 有多少个计划单就有多少个拣货单 要对进行拣货的信息 来自出库货物的信息
create table 刘建杰.picking_list
( 
       piid  varchar2(32) not null,
       outid varchar2(32) not null,
       sku   varchar2(32) not null,
       saleqty   number(6)  not null
       
);
comment on table 刘建杰.picking_list is '要拣货单表';
comment on column 刘建杰.picking_list.piid is '主键';
comment on column 刘建杰.picking_list.outid is '出货单id';
comment on column 刘建杰.picking_list.sku is '货物no';
comment on column 刘建杰.picking_list.saleqty is '计划拣货数量';

create index ix_picking_list on 刘建杰.picking_list(piid);
alter table 刘建杰.picking_list
      add constraint pk_picking_list primary key(piid)
      using index ix_picking_list 

