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
comment on table yfbc.in_storage is '���ƻ�';
comment on column yfbc.in_storage.inid is '����id';
comment on column yfbc.in_storage.productname is '��Ʒ����';
comment on column yfbc.in_storage.sku is '��Ʒ����';
comment on column yfbc.in_storage.purchaseqty is '��Ʒ����';
comment on column yfbc.in_storage.unit is '��λ������ǧ�ˣ�';
comment on column yfbc.in_storage.supplier is '��Ӧ��';
comment on column yfbc.in_storage.supplierno is '��Ӧ�̵绰';
comment on column yfbc.in_storage.receivename is '�ջ���';
comment on column yfbc.in_storage.receiveno is '�ջ��˺���';
comment on column yfbc.in_storage.arrivaldate is '�ƻ����ʱ��';
comment on column yfbc.in_storage.whid is '�ֿ�id';
comment on column yfbc.in_storage.inno is '���� ';
comment on column yfbc.in_storage.instate is '״̬ 0Ϊδ�յ�����1Ϊ�յ��˻�';

create index ix_in_storage on yfbc.in_storage(inid);
alter table yfbc.in_storage
      add constraint pk_in_storage primary key(inid)
      using index ix_in_storage    
      
    

--drop table in_storage
select * from in_storage for update
select * from rack
select * from goodtype

