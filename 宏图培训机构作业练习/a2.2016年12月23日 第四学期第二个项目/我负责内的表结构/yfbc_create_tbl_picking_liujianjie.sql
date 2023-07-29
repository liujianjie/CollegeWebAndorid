--拣货单 与拣货单表一一对应 实际拣货的表
create table 刘建杰.picking
(
       picid varchar2(32) not null,
       piid  varchar2(32) not null,
       packageqty         number(6) not null,
       pickqty            number(6) not null,
       damagedqty         number(6) not null,
       damagedreason      varchar2(200) not null                                                                                                                            
);
        
comment on table 刘建杰.picking is '要拣货单表';
comment on column 刘建杰.picking.picid is '主键';
comment on column 刘建杰.picking.piid is '拣货单id';
comment on column 刘建杰.picking.packageqty is '外包装数量';
comment on column 刘建杰.picking.pickqty is '货物基本单位数量';
comment on column 刘建杰.picking.damagedqty is '坏货数量';
comment on column 刘建杰.picking.damagedreason is '坏货原因码';

create index ix_picking on 刘建杰.picking(piid);
alter table 刘建杰.picking
      add constraint pk_picking primary key(piid)
      using index ix_picking
                                              
