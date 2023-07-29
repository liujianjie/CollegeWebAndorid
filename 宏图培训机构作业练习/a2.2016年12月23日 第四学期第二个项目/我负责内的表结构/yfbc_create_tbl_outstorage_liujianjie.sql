create table yfbc.out_storage
(
       outid      varchar2(32) not null,
       storerid   varchar2(32) not null,
       plandate   date not null,
       DONO       varchar2(32) not null,
       ShippingNO varchar2(32) not null,
       whid       varchar2(32) not null,
       customerid varchar2(32) not null,
       crossflag  number(1) not null,
       directflag number(1) not null,
       sku        varchar2(32) not null,
       saleqty    number(6) not    null
);

comment on table yfbc.out_storage is '����ƻ���';
comment on column yfbc.out_storage.outid is '����';
comment on column yfbc.out_storage.storerid is '����NO';
comment on column yfbc.out_storage.plandate is '�ƻ�����ʱ��';
comment on column yfbc.out_storage.DONO is 'ԭDO�ĺ���';
comment on column yfbc.out_storage.ShippingNO is '�ͻ��е��� ';
comment on column yfbc.out_storage.whid is '�ֿ���� ';
comment on column yfbc.out_storage.customerid is '�ͻ�NO ';
comment on column yfbc.out_storage.crossflag is '�Ƿ�Խ�� 0ΪδԽ�ޣ�1ΪԽ�� ';
comment on column yfbc.out_storage.directflag is '�Ƿ��������� 0Ϊδ��1Ϊy ';
comment on column yfbc.out_storage.sku is '����NO ';
comment on column yfbc.out_storage.saleqty is '�ƻ��������� ';

create index ix_out_storage on yfbc.out_storage(outid);
alter table yfbc.out_storage
      add constraint pk_out_storage primary key(outid)
      using index ix_out_storage    

